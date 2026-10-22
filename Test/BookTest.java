import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testGetCreator() {
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);

        String creator = book.getCreator();

        assertEquals("Allan B. Downey", creator);
        assertNotNull(creator);
    }
    @Test
    void testGetTitle(){
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);

        String title = book.getTitle();

        assertEquals("Think Java", title);
        assertNotNull(title);
    }
    @Test
    void testGetIdentifier(){
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);

        String identifier = book.getIdentifier();

        assertEquals("9781492072508", identifier);
        assertNotNull(identifier);
    }
    @Test
    void testGetLength(){
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);

       double length = book.getLength();

        assertEquals(326, length);
        assertNotNull(length);
    }
    }

