import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;
    Book book1;
    Member member1;
    String title;
    int memberID;

    @BeforeEach
    void setUp(){
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
        List<Member> members = List.of(new Member("Daniel", 1234, aalborgLoanPolicy));
        book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        List<Resource> resources = List.of(book1);
        List<Loan> loans = List.of();
        library = new Library(resources, members,loanPolicy);
         title = "Think Java";
         memberID = 1234;
    }

    @Test
    void isAvailable() {
        assertTrue(library.isAvailable(title));
    }

    @Test
    void loanMaterialTrue() {
    assertEquals(LoanResult.LOANED, library.loanMaterial(title, memberID));
    IO.println(library.findLoansByMemberId(memberID));
    }
    /*
    @Test
    void loanMaterialAlreadyLoaned() {
        library.addLoan(new Loan(new Member("Lucas", 4567),book1));
        assertEquals(LoanResult.CANNOT_LOAN, library.loanMaterial(title, memberID));
    }
     */
    @Test
    void loanMaterialWrongMemberID() {
        assertEquals(LoanResult.WRONGID, library.loanMaterial(title, 9999));
    }
    @Test
    void loanMaterialWrongTitel() {
        assertEquals(LoanResult.WRONGTITEL, library.loanMaterial("Suicide Squad", memberID));
    }

    @Test
    void tjekHvisFejlIngenAtIngenLånOprettet(){
        library.loanMaterial(title,9999);
        assertTrue(library.isAvailable(title));
        assertNull(library.findLoansByMemberId(memberID));
    }

    @Test
    void returnMaterial() {
            library.loanMaterial(title, memberID);
            assertFalse(library.isAvailable(title));

            library.returnMaterial(title);
            assertTrue(library.isAvailable(title));
    }

    @Test
    void returnMaterialAndLoanAgain(){
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        library.addLoan(new Loan(new Member("Lucas", 4567, loanPolicy),book1, loanPolicy.calculateDueDate(book1)));
        assertFalse(library.isAvailable(title));

        library.returnMaterial(title);
        assertTrue(library.isAvailable(title));

        assertEquals(LoanResult.SUCCESS, library.loanMaterial(title,memberID));
    }

    @Test
    void findLoansByMemberId() {
        assertNull(library.findLoansByMemberId(memberID));

        library.loanMaterial(title, memberID);

        var loans = library.findLoansByMemberId(memberID);
        assertEquals(1, loans.size());

    }
/*
    @Test
    void findObjectByMemberId() {
        var loan = new Loan(member1, book1);

        assertSame(member1, loan.getMember());
        assertSame(book1, loan.getResource());

        //assertSame(loan, );

    }

 */

}