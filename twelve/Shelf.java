package twelve;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Book> books;

    public Shelf() {
        books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    boolean addBook(Book b) {
        books.add(b);
        return true;
    }

    public boolean hasBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
