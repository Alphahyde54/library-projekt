import java.util.*;
import java.time.LocalDate;

public interface LoanPolicy {
    boolean canLoan (int memberID, String title, List <Loan> currentLoans);
    LocalDate calculateDueDate(Resource resource, LocalDate loanDate);

}
