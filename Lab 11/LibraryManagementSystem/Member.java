import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Member id cannot be empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Member name cannot be empty");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    // checked before an item is touched, so a failed borrow leaves nothing half done
    public void checkCanBorrow() throws MemberLimitExceededException {
        if (loans.size() >= MAX_LOANS) {
            throw new MemberLimitExceededException(name + " (" + id + ") already has "
                    + MAX_LOANS + " loans, the maximum allowed");
        }
    }

    void addLoan(Loan loan) { loans.add(loan); }

    void removeLoan(Loan loan) { loans.remove(loan); }

    public String getId() { return id; }
    public String getName() { return name; }

    // read only view so outside code cannot change the list directly
    public List<Loan> getLoans() { return Collections.unmodifiableList(loans); }

    @Override
    public String toString() {
        return id + " | " + name + " | loans: " + loans.size() + "/" + MAX_LOANS;
    }
}
