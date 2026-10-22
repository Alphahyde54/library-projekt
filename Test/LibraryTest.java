import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library = new Library();
    Book book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
    Member member1 = new Member("Daniel", 1234);
    String title = "Think Java";


    @Test
    void isAvailable() {
        library.addBook(book1);
        assertTrue(library.isAvailable(title));
    }

    @Test
    void loanMaterialTrue() {
    library.addMember(member1);
    library.addBook(book1);
    assertEquals(LoanResult.LOANED, library.loanMaterial(title, 1234));
    IO.println(library.findLoansByMemberId(1234));
    }
    @Test
    void loanMaterialAlreadyLoaned() {
        library.addMember(member1);
        library.addBook(book1);
        assertEquals(LoanResult.CANNOT_LOAN, library.loanMaterial(title, 1234));
        library.printLoans();
    }
    @Test
    void loanMaterialWrongMemberID() {
        library.addMember(member1);
        library.addBook(book1);
        assertEquals(LoanResult.WRONGID, library.loanMaterial(title, 1234));
    }
    @Test
    void loanMaterialWrongTitel() {
        library.addMember(member1);
        library.addBook(book1);
        assertEquals(LoanResult.WRONGTITEL, library.loanMaterial(title, 1234));
    }

    @Test
    void returnMaterial() {
    }

    @Test
    void findLoansByMemberId() {
    }

    @Test
    void printResources() {
        Library library = new Library();

        AudioBook audioBook3 = new AudioBook("6801234567824", "Red Rising", "Pierce Brown", 382);
        Movie movie3 = new Movie("7701234567892", "Oppenheimer", "Christopher Nolan", 180);
        Book book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 466);
        VideoGame videoGame3 = new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision");

        library.addAudioBook(audioBook3);
        library.addBook(book3);
        library.addMovie(movie3);
        library.addVideoGame(videoGame3);


        assertEquals(audioBook3, library.getResource("Red Rising"));
        assertEquals(book3, library.getResource("Sapiens"));
        assertEquals(movie3, library.getResource("Oppenheimer"));
        assertEquals(videoGame3, library.getResource("Call of Duty: Black Ops 2"));

        library.printResources();
    }

    @Test
    void printMembers() {
        Library library = new Library();
        Member member1 = new Member("Daniel", 1234);
        Member member2 = new Member("Loke", 4567);
        Member member3 = new Member("Lucas", 7890);

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        assertEquals(member1, library.getMember(1234));
        assertEquals(member2, library.getMember(4567));
        assertEquals(member3, library.getMember(7890));

        library.printMembers();
    }
}