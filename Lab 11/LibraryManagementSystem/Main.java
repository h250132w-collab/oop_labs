import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // data folder can be passed as an argument, default is ./data
        FileStore store = new FileStore(Path.of(args.length > 0 ? args[0] : "data"));
        Library library = new Library();

        try {
            int skipped = store.load(library);
            System.out.println("Loaded " + library.getItems().size() + " items, "
                    + library.getMembers().size() + " members, "
                    + library.getLoans().size() + " loans.");
            if (skipped > 0) {
                System.out.println("Warning: " + skipped + " bad line(s) in the data files were skipped.");
            }
        } catch (IOException e) {
            System.out.println("Could not read the data files: " + e.getMessage());
        }

        boolean running = true;
        while (running) {
            printMenu();
            String choice = in.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addItem(library);
                    case "2" -> registerMember(library);
                    case "3" -> borrow(library);
                    case "4" -> returnItem(library);
                    case "5" -> listOverdue(library);
                    case "6" -> search(library);
                    case "7" -> listAll(library);
                    case "0" -> running = false;
                    default -> System.out.println("Please pick a number from the menu.");
                }
            } catch (ItemNotAvailableException | MemberLimitExceededException e) {
                System.out.println("Cannot borrow: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            store.save(library);
            System.out.println("Data saved. Goodbye.");
        } catch (IOException e) {
            System.out.println("Could not save the data: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Library Management System =====");
        System.out.println("1. Add item");
        System.out.println("2. Register member");
        System.out.println("3. Borrow");
        System.out.println("4. Return");
        System.out.println("5. List overdue items");
        System.out.println("6. Search by title");
        System.out.println("7. List all items");
        System.out.println("0. Save and exit");
        System.out.print("Choice: ");
    }

    private static String ask(String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }

    private static void addItem(Library library) {
        String type = ask("Type (B = book, D = DVD): ").toUpperCase();
        String id = ask("Item id: ");
        String title = ask("Title: ");
        if (type.equals("B")) {
            String author = ask("Author: ");
            library.addItem(new Book(id, title, author));
        } else if (type.equals("D")) {
            String text = ask("Running time in minutes: ");
            try {
                library.addItem(new Dvd(id, title, Integer.parseInt(text)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Running time must be a whole number");
            }
        } else {
            throw new IllegalArgumentException("Type must be B or D");
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library library) {
        String id = ask("Member id: ");
        String name = ask("Name: ");
        library.registerMember(new Member(id, name));
        System.out.println("Member registered.");
    }

    private static void borrow(Library library)
            throws ItemNotAvailableException, MemberLimitExceededException {
        String memberId = ask("Member id: ");
        String itemId = ask("Item id: ");
        Loan loan = library.borrow(memberId, itemId);
        System.out.println("Done. " + loan);
    }

    private static void returnItem(Library library) {
        String itemId = ask("Item id to return: ");
        library.returnItem(itemId);
        System.out.println("Item returned.");
    }

    private static void listOverdue(Library library) {
        List<Loan> overdue = library.listOverdue(LocalDate.now());
        if (overdue.isEmpty()) {
            System.out.println("Nothing is overdue.");
            return;
        }
        overdue.forEach(l -> System.out.println(l));
    }

    private static void search(Library library) {
        List<LibraryItem> found = library.searchByTitle(ask("Search text: "));
        if (found.isEmpty()) {
            System.out.println("No titles match.");
            return;
        }
        found.forEach(i -> System.out.println(i));
    }

    private static void listAll(Library library) {
        if (library.getItems().isEmpty()) {
            System.out.println("The library has no items yet.");
            return;
        }
        library.allItemsSorted().forEach(i -> System.out.println(i));
    }
}
