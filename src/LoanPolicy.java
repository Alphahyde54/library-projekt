import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public interface LoanPolicy {
    boolean canLoan (Member member, Resource resource, List <Loan> currentLoans);
    LocalDate calculateDueDate(Resource resource, LocalDate loanDate);
}
