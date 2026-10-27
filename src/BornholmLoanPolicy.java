import java.time.LocalDate;
import java.util.List;

public class BornholmLoanPolicy implements LoanPolicy {
    @Override
    public boolean canLoan(int memberID, String title, List<Loan> currentLoans){
        for (Loan loan : currentLoans) {
            if (loan.getResource().getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                return false;
            }
        }
        return true;
    }
    @Override
    public LocalDate calculateDueDate(Resource resource, LocalDate loanDate){
        if(resource instanceof AudioBook) {
            return loanDate.plusDays(14);
        }
        return loanDate.plusDays(30);
    // Lydbøger kan maks lånes i 14 dage
    }
}
