// Checked exception: thrown when someone tries to borrow an item that is already out
public class ItemNotAvailableException extends Exception {
    private static final long serialVersionUID = 1L;

    public ItemNotAvailableException(String message) {
        super(message);
    }
}
