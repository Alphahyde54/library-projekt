import java.time.LocalDate;

public interface StandardLoanPolicy extends LoanPolicy {
    default boolean canLoan(){
//Låne alt
    }

    default LocalDate calculateDueDate(){
// Låne max 30 dage
    }
}

