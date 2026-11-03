import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySaverTest {
    @Test
    void creatorComparatoeSortsByCreatorthenTitle(){
        var book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        var book2 = new Book("9788763851664", "Omrids", "Rachel Cusk", 256);
        var book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 466);

    var books = new ArrayList<Resource>(List.of(book1,book2,book3));
    books.sort(new ResourceCreatorComparator());

    assertEquals(List.of(book1,book2,book3), books);


}


}