import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Library {
    // maps keyed by id, LinkedHashMap keeps the order things were added
    private final Map<String, LibraryItem> items = new LinkedHashMap<>();
    private final Map<String, Member> members = new LinkedHashMap<>();
    // key is the item id, because an item can only be on loan once at a time
    private final Map<String, Loan> loans = new LinkedHashMap<>();

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("An item with id " + item.getId() + " already exists");
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("A member with id " + member.getId() + " already exists");
        }
        members.put(member.getId(), member);
    }

    public Loan borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        return borrow(memberId, itemId, LocalDate.now());
    }

    // this version takes the date so a loan can be created with a date other than today
    public Loan borrow(String memberId, String itemId, LocalDate date)
            throws ItemNotAvailableException, MemberLimitExceededException {
        // 1. look up the member and the item
        Member member = members.get(memberId);
        if (member == null) {
            throw new IllegalArgumentException("No member with id " + memberId);
        }
        LibraryItem item = items.get(itemId);
        if (item == null) {
            throw new IllegalArgumentException("No item with id " + itemId);
        }
        // 2. check the member limit and the item availability
        member.checkCanBorrow();
        item.borrow(member);
        // 3. create the loan and record it in both places
        Loan loan = new Loan(item, member, date);
        member.addLoan(loan);
        loans.put(itemId, loan);
        return loan;
    }

    public void returnItem(String itemId) {
        Loan loan = loans.get(itemId);
        if (loan == null) {
            throw new IllegalArgumentException("Item " + itemId + " is not on loan");
        }
        loan.getItem().giveBack();
        loan.getMember().removeLoan(loan);
        loans.remove(itemId);
    }

    public List<Loan> listOverdue(LocalDate today) {
        return loans.values().stream()
                .filter(l -> l.isOverdue(today))
                .sorted(Comparator.comparing(Loan::getDueDate))
                .toList();
    }

    public List<LibraryItem> searchByTitle(String text) {
        String needle = text.toLowerCase();
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(needle))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    public Collection<LibraryItem> getItems() { return items.values(); }
    public Collection<Member> getMembers() { return members.values(); }
    public Collection<Loan> getLoans() { return loans.values(); }
    public LibraryItem findItem(String id) { return items.get(id); }
    public Member findMember(String id) { return members.get(id); }

    // used by the file loader to rebuild a loan from saved data
    void restoreLoan(Loan loan) {
        loan.getItem().setAvailable(false);
        loan.getMember().addLoan(loan);
        loans.put(loan.getItem().getId(), loan);
    }

    // handy for the menu, copy so the caller cannot touch the real list
    public List<LibraryItem> allItemsSorted() {
        List<LibraryItem> list = new ArrayList<>(items.values());
        list.sort(Comparator.comparing(LibraryItem::getId));
        return list;
    }
}
