import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Saves and loads the library as three csv files: items, members, loans
public class FileStore {
    private final Path itemsFile;
    private final Path membersFile;
    private final Path loansFile;

    public FileStore(Path folder) {
        this.itemsFile = folder.resolve("items.csv");
        this.membersFile = folder.resolve("members.csv");
        this.loansFile = folder.resolve("loans.csv");
    }

    public void save(Library library) throws IOException {
        Files.createDirectories(itemsFile.getParent());

        // try-with-resources closes each writer even if something fails
        try (BufferedWriter out = Files.newBufferedWriter(itemsFile)) {
            for (LibraryItem i : library.getItems()) {
                out.write(line(i.getType(), i.getId(), i.getTitle(), i.getExtra(),
                        String.valueOf(i.isAvailable())));
                out.newLine();
            }
        }
        try (BufferedWriter out = Files.newBufferedWriter(membersFile)) {
            for (Member m : library.getMembers()) {
                out.write(line(m.getId(), m.getName()));
                out.newLine();
            }
        }
        try (BufferedWriter out = Files.newBufferedWriter(loansFile)) {
            for (Loan l : library.getLoans()) {
                out.write(line(l.getItem().getId(), l.getMember().getId(),
                        l.getBorrowDate().toString()));
                out.newLine();
            }
        }
    }

    // returns how many bad lines were skipped, so the menu can warn the user
    public int load(Library library) throws IOException {
        int skipped = 0;

        // members first, then items, then loans (loans need both to exist)
        if (Files.exists(membersFile)) {
            for (String raw : Files.readAllLines(membersFile)) {
                if (raw.isBlank()) continue;
                try {
                    List<String> f = split(raw);
                    library.registerMember(new Member(f.get(0), f.get(1)));
                } catch (RuntimeException e) {
                    skipped++;
                }
            }
        }
        if (Files.exists(itemsFile)) {
            for (String raw : Files.readAllLines(itemsFile)) {
                if (raw.isBlank()) continue;
                try {
                    List<String> f = split(raw);
                    LibraryItem item;
                    if (f.get(0).equals("BOOK")) {
                        item = new Book(f.get(1), f.get(2), f.get(3));
                    } else if (f.get(0).equals("DVD")) {
                        item = new Dvd(f.get(1), f.get(2), Integer.parseInt(f.get(3)));
                    } else {
                        throw new IllegalArgumentException("unknown type");
                    }
                    item.setAvailable(Boolean.parseBoolean(f.get(4)));
                    library.addItem(item);
                } catch (RuntimeException e) {
                    skipped++;
                }
            }
        }
        if (Files.exists(loansFile)) {
            for (String raw : Files.readAllLines(loansFile)) {
                if (raw.isBlank()) continue;
                try {
                    List<String> f = split(raw);
                    LibraryItem item = library.findItem(f.get(0));
                    Member member = library.findMember(f.get(1));
                    if (item == null || member == null) {
                        throw new IllegalArgumentException("loan points to something missing");
                    }
                    library.restoreLoan(new Loan(item, member, LocalDate.parse(f.get(2))));
                } catch (RuntimeException e) {
                    skipped++;
                }
            }
        }
        return skipped;
    }

    // joins the fields with commas, quoting any field that has a comma or quote in it
    private static String line(String... fields) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(escape(fields[i]));
        }
        return sb.toString();
    }

    private static String escape(String s) {
        if (s.contains(",") || s.contains("\"")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }

    // splits one csv line, understands "quoted, fields" and "" for a quote mark
    static List<String> split(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (inQuotes) {
                if (c == '"' && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else if (c == '"') {
                    inQuotes = false;
                } else {
                    current.append(c);
                }
            } else if (c == '"') {
                inQuotes = true;
            } else if (c == ',') {
                fields.add(current.toString());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        fields.add(current.toString());
        return fields;
    }
}
