

package library;

/**
 * Simple Book model with id, title, author, year and copies
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private int copies;

    public Book(int id, String title, String author, int year, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.copies = copies;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }

    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Author: %s | Year: %d | Copies: %d",
                id, title, author, year, copies);
    }
}

