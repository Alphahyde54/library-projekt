import java.time.LocalDate;

public class BornholmLoanPolicy implements LoanPolicy {
    @Override
    default boolean canLoan(){
//Låne alt
    }
    @Override
    default LocalDate calculateDueDate(){
//Lydbøger kan kun lånes i 14 dage
    }
}
