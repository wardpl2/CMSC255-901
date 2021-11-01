package Labs.Lab11;

import java.util.ArrayList;

public class Bookshelf {
    private int size;
    private ArrayList<Book> books;


    /**
     * Default Constructor
     */
    public Bookshelf() {
        size = 2;
        books = new ArrayList<>();
    }

    /**
     * Parameterized Constructor
     * @param size int
     */
    public Bookshelf(int size) {
        this.size = size;
        books = new ArrayList<>();
    }

    //Getters for instance variables
    public int getSize() {
        return size;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Adds a Book to the Bookshelf
     * @param book Book
     */
    public void addBook(Book book) {
        if (books.size() < size) {
            books.add(book);
        }
    }

    /**
     * Removes the first Book on the shelf and returns that Book
     * @return The Book that is removed from the shelf
     */
    public Book removeBook() {
        if (books.size() == 0) {
            return null;
        } else {
            Book returnBook = books.get(0);
            books.remove(0);
            return returnBook;
        }
    }

    /**
     * Removes every Book that is on the Bookshelf
     */
    public void emptyBookshelf() {
        books.removeAll(books);
    }
}
