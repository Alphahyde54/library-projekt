import java.util.Objects;

public class Book extends Resource {
    final String author;
    final String title;
    final String isbn;
    final int id;


    public Book(String indetifier, String title, String creator, double length){
        super(indetifier, title, creator);
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
