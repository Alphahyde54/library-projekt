import java.time.LocalDate;
import java.util.List;

public class AalborgLoanPolicy implements LoanPolicy {
    LocalDate borrowedDate;
    @Override
    public boolean canLoan(int memberID, String title, List<Loan> currentLoans){
        for (Loan loan : currentLoans) {
            if (loan.getResource().getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                return false;
            }

        }
        int maxLimit = 0;
        for(Loan loan : currentLoans) {
            if (loan.getMember().getID() == memberID) {
                if(loan.getResource() instanceof Movie || loan.getResource() instanceof VideoGame){
                    maxLimit += 1;
                }
                if(maxLimit >= 3){
                    return false;
                }
            }
        }
        return true;
// DU kan kun låne 3 videospil eller film af gangen
    }
    @Override
    public LocalDate calculateDueDate(Resource resource){
        borrowedDate = LocalDate.now();
        return borrowedDate.plusDays(30);
// Låne max 30 dage
    }
}
