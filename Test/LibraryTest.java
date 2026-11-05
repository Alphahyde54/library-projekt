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

    /* @BeforeEach
    void setUp(){
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
        member1 = new Member("Daniel", 1234, aalborgLoanPolicy);
        List<Member> members = List.of(member1);
        book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        List<Resource> resources = List.of(book1);
        List<Loan> loans = List.of();
        library = new Library(resources, members,loanPolicy);
         title = "Think Java";
         memberID = 1234;
    }

     */

    @Test
    void isAvailable() {
        final List<Resource> resources = List.of();
        final List<Member> members = List.of();
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        List<Loan> loans = new ArrayList<>();
        Library library1 = new Library(resources, members, loanPolicy, loans);
        assertTrue(library1.isAvailable(title));
    }

    @Test
    void loanMaterialTrue() {
        LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
        Member member = new Member("Daniel", 1234);
        Movie movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        List<Member> member2 = List.of(member);
        List<Resource> movie2 = List.of(movie);
        List<Loan> loans = new ArrayList<>();
        Library library = new Library(movie2, member2, standardLoanPolicy, loans);

        LoanResult result = library.loanMaterial("Interstellar", 1234);

        assertEquals(LoanResult.SUCCESS, result);
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
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        Member member = new Member("Daniel", 1234);
        Library library = new Library(List.of(book), List.of(member), new StandardLoanPolicy(), new ArrayList<>());

        assertEquals(LoanResult.WRONGID, library.loanMaterial(title, 9999));
    }
    @Test
    void loanMaterialWrongTitel() {
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        Member member = new Member("Daniel", 1234);
        Library library = new Library(List.of(book), List.of(member), new StandardLoanPolicy(), new ArrayList<>());
        assertEquals(LoanResult.WRONGTITEL, library.loanMaterial("Suicide Squad", 1234));
    }

    @Test
    void tjekHvisFejlIngenAtIngenLånOprettet(){
        LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
        Member member = new Member("Daniel", 1234);
        Movie movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        List<Member> member2 = List.of(member);
        List<Resource> movie2 = List.of(movie);
        List<Loan> loans = new ArrayList<>();
        Library library = new Library(movie2, member2, standardLoanPolicy, loans);

        LoanResult result = library.loanMaterial("Think Java", 1234);   // findes ikke

        assertEquals(LoanResult.WRONGTITEL, result);
        assertTrue(loans.isEmpty());
        assertNull(library.findLoansByMemberId(1234));
    }

    @Test
    void returnMaterial() {
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        Member member = new Member("Daniel", 1234);
        Library library = new Library(List.of(book), List.of(member), new StandardLoanPolicy(), new ArrayList<>());

        library.loanMaterial("Think Java", 1234);
        assertFalse(library.isAvailable("Think Java"));

        library.returnMaterial("Think Java");
        assertTrue(library.isAvailable("Think Java"));

//            library.loanMaterial(title, memberID);
//            assertFalse(library.isAvailable(title));
//
//            library.returnMaterial(title);
//            assertTrue(library.isAvailable(title));
    }
/*
    @Test
    void returnMaterialAndLoanAgain(){
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        library.addLoan(new Loan(new Member("Lucas", 4567, loanPolicy),book1, loanPolicy.calculateDueDate(book1)));
        assertFalse(library.isAvailable(title));

        library.returnMaterial(title);
        assertTrue(library.isAvailable(title));

        assertEquals(LoanResult.SUCCESS, library.loanMaterial(title,memberID));
    }

 */

    @Test
    void findLoansByMemberId() {
        Book book = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
        Member member = new Member("Daniel", 1234);
        Library library = new Library(List.of(book), List.of(member), new StandardLoanPolicy(), new ArrayList<>());
        assertNull(library.findLoansByMemberId(1234));

        assertNull(library.findLoansByMemberId(1234));

        library.loanMaterial("Think Java", 1234);

        assertEquals(1, library.findLoansByMemberId(1234).size());

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