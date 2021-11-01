package Labs.Lab11;

public class Book {
    private String title;
    private String author;

    //Getters and Setters for instance variables
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //Constructors
    public Book() {
        title = "Test";
        author = null;
    }

    /**
     * @param title String
     * @param author String
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "\"" + title + "\" " + "by " + author;
    }
}
