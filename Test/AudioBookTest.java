import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AudioBookTest {
    @Test
    void testGetCreator() {
        AudioBook audioBook = new AudioBook("8801234567822", "The Count Of Monte Cristo", "Alexandre Dumas", 886);

        String creator = audioBook.getCreator();

        assertEquals("Alexandre Dumas", creator);
        assertNotNull(creator);
    }

    @Test
    void testGetTitle() {
        AudioBook audioBook = new AudioBook("8801234567822", "The Count Of Monte Cristo", "Alexandre Dumas", 886);

        String title = audioBook.getTitle();

        assertEquals("The Count Of Monte Cristo", title);
        assertNotNull(title);
    }

    @Test
    void testGetIdentifier() {
        AudioBook audioBook = new AudioBook("8801234567822", "The Count Of Monte Cristo", "Alexandre Dumas", 886);

        String identifier = audioBook.getIdentifier();

        assertEquals("8801234567822", identifier);
        assertNotNull(identifier);
    }

    @Test
    void testGetLength() {
        AudioBook audioBook = new AudioBook("8801234567822", "The Count Of Monte Cristo", "Alexandre Dumas", 886);

        assertEquals(886, audioBook.getLength());
    }
}