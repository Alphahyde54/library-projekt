import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void testGetCreator() {
        Movie movie = new Movie("1234567890123", "Inception", "Christopher Nolan", 148.0);

        String creator = movie.getCreator();

        assertEquals("Christopher Nolan", creator);
        assertNotNull(creator);
    }

    @Test
    void testGetTitle() {
        Movie movie = new Movie("1234567890123", "Inception", "Christopher Nolan", 148.0);

        String title = movie.getTitle();

        assertEquals("Inception", title);
        assertNotNull(title);
    }

    @Test
    void testGetIdentifier() {
        Movie movie = new Movie("1234567890123", "Inception", "Christopher Nolan", 148.0);

        String identifier = movie.getIdentifier();

        assertEquals("1234567890123", identifier);
        assertNotNull(identifier);
    }

    @Test
    void testGetLength() {
        Movie movie = new Movie("1234567890123", "Inception", "Christopher Nolan", 148.0);

        double length = movie.getLength();

        assertEquals(148.0, length, 0.001);
    }
}
