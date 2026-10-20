import java.time.LocalDate;

public class Loan {
    Resource resource;
    Member member;
    LocalDate borrowedDate;

    public Loan(Member member, Resource resource) {
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

    public LocalDate getDueDate() {
        if (!(borrowedDate==null)){
            return borrowedDate.plusDays(14);
        }
        return null;
    }


    public String toString(){
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s
                """, resource, member, getDueDate());
    }
}
