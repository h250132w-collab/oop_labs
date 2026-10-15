// Anything that can be lent out and brought back
public interface Borrowable {
    void borrow(Member member) throws ItemNotAvailableException;
    void giveBack();
}
