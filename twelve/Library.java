package twelve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Shelf> shelfs;

    public Library() {
        shelfs = new ArrayList<>();
    }

    public List<Shelf> getShelfs() {
        return shelfs;
    }
    int getShelf(String title) {
        for (Shelf s : shelfs) {
            if (s.hasBook(title)) {
                return shelfs.indexOf(s);
            }
        }
        return -1;
    }
    Iterator<Book> iterator() {
        return new LibraryIterator();
    }
    class LibraryIterator implements Iterator<Book> {
        private Shelf currentShelf;
        private List<Book> booksInCurrentShelf;
        private int indexInShelf;

        public LibraryIterator() {
            currentShelf = shelfs.get(0);
            booksInCurrentShelf = currentShelf.getBooks();
            indexInShelf=0;
        }

        @Override
        public boolean hasNext() {
            return shelfs.indexOf(currentShelf)==(shelfs.size()-1);
        }

        @Override
        public Book next() {
            if (indexInShelf >= booksInCurrentShelf.size()-1) {
                if (!hasNext()) {
                    return null;
                }
                currentShelf = shelfs.get(shelfs.indexOf(currentShelf)+1);
                booksInCurrentShelf = currentShelf.getBooks();
                indexInShelf = 0;
            }
            return next();
        }
    }
}
