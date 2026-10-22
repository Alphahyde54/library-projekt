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
    }

    @Test
    void printMembers() {
    }
}