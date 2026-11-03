import java.util.Comparator;

public class DueDateComparator implements Comparator<Loan> {
    @Override
    public int compare(Loan loan1, Loan loan2) {
        return loan1.getDueDate().compareTo(loan2.getDueDate());
    }
}
