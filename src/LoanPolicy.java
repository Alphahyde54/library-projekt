import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public interface LoanPolicy {
    boolean canLoan (int memberID, String title, List <Loan> currentLoans);
    LocalDate calculateDueDate(Resource resource);
}
