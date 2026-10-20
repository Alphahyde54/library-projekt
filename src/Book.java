import java.util.Objects;

public class Book extends Resource {
    private final double length;

    public Book(String indetifier, String title, String creator, double length) {
        super(indetifier, title, creator);
        this.length = length;
    }

    public String getIdentifier() {
        return getIdentifier();
    }
}
