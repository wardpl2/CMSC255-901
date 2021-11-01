package Labs.Lab11;

public class Lab11 {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Ready Player One", "Ernest Cline");
        Book book3 = new Book();

        System.out.println("*Individual Books*");
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        Bookshelf bookshelf = new Bookshelf(3);

        bookshelf.addBook(book1);
        bookshelf.addBook(book2);
        bookshelf.addBook(book3);

        System.out.println("*For loop for Bookshelf*");
        for (Book B : bookshelf.getBooks()) {
            System.out.println(B.toString());
        }

        bookshelf.emptyBookshelf();

        System.out.println("*For loop to print an empty Bookshelf*");
        for (Book B : bookshelf.getBooks()) {
            System.out.println(B.toString());
        }
    }
}
