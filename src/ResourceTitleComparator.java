import java.util.Comparator;

public class ResourceTitleComparator implements Comparator<Loan> {
    @Override
    public int compare (Loan loan1, Loan loan2){
        return loan1.getBorrowDate().compareTo(loan2.getBorrowDate());
    }
}
