import java.time.LocalDate;
import java.util.List;

public class BornholmLoanPolicy implements LoanPolicy {
    LocalDate borrowedDate;
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
    public LocalDate calculateDueDate(Resource resource){
        borrowedDate = LocalDate.now();
        if(resource instanceof AudioBook) {
            return borrowedDate.plusDays(14);
        }
        return borrowedDate.plusDays(30);
    // Lydbøger kan maks lånes i 14 dage
    }
    @Override
    public String toString() {
        return "Bornholms Bibliotek";
    }

}
