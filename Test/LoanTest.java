import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    @Test
    void testGetResource() {
        LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
        LocalDate dueDate = LocalDate.now();
        Member member = new Member("Daniel", 1234);
        Resource movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        Loan loan = new Loan(member, movie, LocalDate.now(), dueDate);

        assertSame(movie, loan.getResource());
        assertNotNull(loan.getResource());
    }

    @Test
    void testGetMember() {
        LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
        LocalDate dueDate = LocalDate.now();
        Member member = new Member("Daniel", 1234);
        Resource movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        Loan loan = new Loan(member, movie, LocalDate.now(), dueDate);

        assertSame(member, loan.getMember());
        assertNotNull(loan.getMember());
    }
    @Test
    void testGetDueDate() {
        LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
        Member member = new Member("Daniel", 1234);
        Resource movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        LocalDate expectedDueDate = LocalDate.now().plusDays(14);

        Loan loan = new Loan(member, movie, LocalDate.now(), expectedDueDate);

        assertEquals(expectedDueDate, loan.getDueDate());
        assertNotNull(loan.getDueDate());
    }
}