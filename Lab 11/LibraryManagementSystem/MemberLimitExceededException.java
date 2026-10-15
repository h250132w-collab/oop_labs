// Checked exception: thrown when a member already has the maximum number of loans
public class MemberLimitExceededException extends Exception {
    private static final long serialVersionUID = 1L;

    public MemberLimitExceededException(String message) {
        super(message);
    }
}
