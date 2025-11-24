package library;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Entry point - menu driven console application
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        // optional: seed some data for quick testing
        library.seedData();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> addBookUI();
                case 2 -> viewAllUI();
                case 3 -> updateBookUI();
                case 4 -> deleteBookUI();
                case 5 -> searchByIdUI();
                case 6 -> searchByTitleUI();
                case 0 -> {
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== Library Management ===");
        System.out.println("1. Add Book");
        System.out.println("2. View All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Search Book by ID");
        System.out.println("6. Search Book by Title");
        System.out.println("0. Exit");
    }

    private static void addBookUI() {
        System.out.println("== Add New Book ==");
        int id = readInt("ID: ");
        String title = readString("Title: ");
        String author = readString("Author: ");
        int year = readInt("Year: ");
        int copies = readInt("Copies: ");

        boolean added = library.addBook(new Book(id, title, author, year, copies));
        if (added) System.out.println("Book added successfully.");
        else System.out.println("Book with this ID already exists.");
    }

    private static void viewAllUI() {
        System.out.println("== All Books ==");
        List<Book> all = library.getAllBooks();
        if (all.isEmpty()) {
            System.out.println("No books found.");
        } else {
            all.forEach(System.out::println);
        }
    }

    private static void updateBookUI() {
        System.out.println("== Update Book ==");
        int id = readInt("Enter ID of book to update: ");
        Optional<Book> opt = library.findById(id);
        if (opt.isEmpty()) {
            System.out.println("Book not found.");
            return;
        }
        System.out.println("Current: " + opt.get());
        String newTitle = readString("New Title: ");
        String newAuthor = readString("New Author: ");
        int newYear = readInt("New Year: ");
        int newCopies = readInt("New Copies: ");

        boolean ok = library.updateBook(id, newTitle, newAuthor, newYear, newCopies);
        if (ok) System.out.println("Book updated.");
        else System.out.println("Update failed.");
    }

    private static void deleteBookUI() {
        System.out.println("== Delete Book ==");
        int id = readInt("Enter ID of book to delete: ");
        boolean deleted = library.deleteBook(id);
        if (deleted) System.out.println("Book deleted.");
        else System.out.println("Book not found.");
    }

    private static void searchByIdUI() {
        System.out.println("== Search by ID ==");
        int id = readInt("Enter ID: ");
        Optional<Book> opt = library.findById(id);
        opt.ifPresentOrElse(
                b -> System.out.println("Found: " + b),
                () -> System.out.println("Book not found.")
        );
    }

    private static void searchByTitleUI() {
        System.out.println("== Search by Title ==");
        String query = readString("Enter title or part of title: ");
        List<Book> results = library.searchByTitle(query);
        if (results.isEmpty()) System.out.println("No books match.");
        else results.forEach(System.out::println);
    }

    // Helper input methods with simple validation
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
