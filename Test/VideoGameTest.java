import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoGameTest {
    @Test
    void testGetCreator() {
        VideoGame videoGame = new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision");

        String creator = videoGame.getCreator();

        assertEquals("Activision", creator);
        assertNotNull(creator);
    }
    @Test
    void testGetTitle(){
        VideoGame videoGame = new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision");

        String title = videoGame.getTitle();

        assertEquals("Call of Duty: Black Ops 2", title);
        assertNotNull(title);
    }
    @Test
    void testGetIdentifier(){
        VideoGame videoGame = new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision");

        String identifier = videoGame.getIdentifier();

        assertEquals("2801234567855", identifier);
        assertNotNull(identifier);
    }

}