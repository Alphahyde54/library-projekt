import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {
    LocalDate borrowedDate;
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
        public LocalDate calculateDueDate (Resource resource){
            borrowedDate = LocalDate.now();
            return borrowedDate.plusDays(30);
        // Låne max 30 dage
        }

}

