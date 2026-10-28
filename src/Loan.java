import java.time.LocalDate;

public class Loan {
    Resource resource;
    Member member;
    LocalDate dueDate;

    public Loan(Member member, Resource resource, LocalDate dueDate) {
        this.member = member;
        this.resource = resource;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String toString(){
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s
                """, resource, member, getDueDate());
    }
}
