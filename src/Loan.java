import java.time.LocalDate;

public class Loan implements Comparable<Loan>{
    Resource resource;
    Member member;
    LocalDate borrowDate;
    LocalDate dueDate;

    public Loan(Member member, Resource resource,LocalDate borrowDate, LocalDate dueDate) {
        this.member = member;
        this.resource = resource;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public int compareTo(Loan other) {
        return dueDate.compareTo(other.dueDate);
    }

    public String toString(){
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s
                """, resource, member, getDueDate());
    }
}
