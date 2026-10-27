import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {
    @Override
    public boolean canLoan(int memberID, String title, List<Loan> currentLoans) {
        for (Loan loan : currentLoans) {
            if (loan.getResource().getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                return false;
            }
        }
        return true;
    }
        @Override
        public LocalDate calculateDueDate (Resource resource, LocalDate loanDate){
        return loanDate.plusDays(30);
        // Låne max 30 dage
        }

}

