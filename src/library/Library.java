package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Library handles storage and CRUD operations for Book objects.
 */
public class Library {
    private List<Book> books = new ArrayList<>();

    // Create (Add) - returns true if added
    public boolean addBook(Book book) {
        // prevent duplicate id
        if (findById(book.getId()).isPresent()) {
            return false;
        }
        books.add(book);
        return true;
    }

    // Read - get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // return copy to protect internal list
    }

    // Update - update book details by id
    public boolean updateBook(int id, String newTitle, String newAuthor, int newYear, int newCopies) {
        Optional<Book> opt = findById(id);
        if (opt.isPresent()) {
            Book b = opt.get();
            b.setTitle(newTitle);
            b.setAuthor(newAuthor);
            b.setYear(newYear);
            b.setCopies(newCopies);
            return true;
        }
        return false;
    }

    // Delete - delete by id
    public boolean deleteBook(int id) {
        Optional<Book> opt = findById(id);
        if (opt.isPresent()) {
            books.remove(opt.get());
            return true;
        }
        return false;
    }

    // Search by ID
    public Optional<Book> findById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    // Search by title (partial match, case-insensitive)
    public List<Book> searchByTitle(String titlePart) {
        String query = titlePart.toLowerCase();
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query)) {
                result.add(b);
            }
        }
        return result;
    }

    // Basic seeded data helper (optional)
    public void seedData() {
        addBook(new Book(1, "Clean Code", "Robert C. Martin", 2008, 3));
        addBook(new Book(2, "Head First Java", "Kathy Sierra", 2005, 5));
        addBook(new Book(3, "Introduction to Algorithms", "CLRS", 2009, 2));
    }
}
