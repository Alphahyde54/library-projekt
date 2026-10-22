import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    @Test
    void testGetResource() {
        Member member = new Member("Daniel", 1234);
        Resource movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        Loan loan = new Loan(member, movie);

        assertSame(movie, loan.getResource());
        assertNotNull(loan.getResource());
    }

    @Test
    void testGetMember() {
        Member member = new Member("Daniel", 1234);
        Resource movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        Loan loan = new Loan(member, movie);

        assertSame(member, loan.getMember());
        assertNotNull(loan.getMember());
    }

    @Test
    void testGetDueDate() {
        Member member = new Member("Daniel", 1234);
        Resource movie = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);

        Loan loan = new Loan(member, movie);

        LocalDate expectedDueDate = LocalDate.now().plusDays(14);

        assertEquals(expectedDueDate, loan.getDueDate());
        assertNotNull(loan.getDueDate());
    }

}