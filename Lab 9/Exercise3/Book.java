import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book {
    private String isbn;
    private String title;

    public Book(String isbn, String title){
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Book)){
            return false;
        }
        Book other = (Book) obj;
        return this.isbn.equals(other.isbn);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.isbn);
    }

    @Override
    public String toString(){
        return this.title + " (" + this.isbn + ")";
    }

    public static void main(String[] args){
        Book book1 = new Book("111", "Java Basics");
        Book book2 = new Book("111", "Java Basics 2nd Edition");
        Book book3 = new Book("222", "Data Structures");

        Set<Book> books = new HashSet<>();
        System.out.println("Added book1?: " + books.add(book1));
        System.out.println("Added book2?: " + books.add(book2)); //same isbn so it is rejected
        System.out.println("Added book3?: " + books.add(book3));

        System.out.println("Do book1 and book2 have the same hash code?: " + (book1.hashCode() == book2.hashCode()));
        System.out.println("Set size: " + books.size());
        System.out.println(books);
    }
}
