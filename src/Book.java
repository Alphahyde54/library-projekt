import java.util.Objects;

public class Book {
    final String author;
    final String title;
    final String isbn;
    final int id;


    public Book(String author, String title, String isbn, int id){
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
    }
    public int getID(){
        return id;
    }


    @Override
    public boolean equals(Object otherObject){
        Book book = (Book) otherObject;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author)
                && Objects.equals(isbn, book.isbn) && Objects.equals(id, book.id);
    }

    @Override
    public String toString(){
        return String.format("%s; %s; ISBN %s; (%d)", author, title, isbn, id);
    }
}
