public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        // EXPLAIN: validation lives in the constructor so a bad item can never exist
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Item id cannot be empty");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Item title cannot be empty");
        }
        this.id = id.trim();
        this.title = title.trim();
    }

    // each subclass decides its own loan period (this is what makes it polymorphic)
    public abstract int loanPeriodDays();

    // used when saving to the csv file, "BOOK" or "DVD"
    public abstract String getType();

    // the extra field of each subclass (author or minutes), also for the csv file
    public abstract String getExtra();

    @Override
    public void borrow(Member member) throws ItemNotAvailableException {
        if (!available) {
            throw new ItemNotAvailableException("\"" + title + "\" (" + id + ") is already on loan");
        }
        available = false;
    }

    @Override
    public void giveBack() {
        available = true;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    // package-private on purpose, only the persistence code (same package) restores the flag
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | %s | %d days", getType(), id, title,
                available ? "available" : "on loan", loanPeriodDays());
    }
}
