import java.time.LocalDate;

public class Loan {
    Resource resource;
    Member member;
    LocalDate borrowedDate;

    public Loan(Member member, Resource resource, LocalDate dueDate) {
        this.member = member;
        this.resource = resource;
        this.borrowedDate = LocalDate.now();
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }


    public String toString(LocalDate dueDate){
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s
                """, resource, member, dueDate);
    }
}
