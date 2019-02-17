package twelve;

import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Shelf> shelves;

    public List<Shelf> getShelves() {
        return shelves;
    }

    public int getShelf(String title) {
        for (Shelf s : shelves) {
            for (Book b : s.getBooks()) {
                if (b.getTitle().equals(title)) {
                    return shelves.indexOf(s);
                }
            }
        }
        return -1;
    }

    public Iterator<Book> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<Book> {
        private int shelfIndex;
        private int bookIndex;

        @Override
        public boolean hasNext() {
            if (shelves.size() == 0) {
                return false;
            }
            if (shelfIndex == shelves.size()-1 && bookIndex >= shelves.get(shelfIndex).getBooks().size()-1) {
                return false;
            }
            return true;
        }

        @Override
        public Book next() {
            if (!hasNext()) {
                return null;
            }
            Book b = shelves.get(shelfIndex).getBooks().get(shelfIndex);
            if (shelves.get(shelfIndex).getBooks().size()-1 == bookIndex) {
                shelfIndex++;
                bookIndex=0;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        Library l = new Library();
        Iterator<Book> it = l.iterator();
    }
}
