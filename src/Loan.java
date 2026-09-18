import java.time.LocalDate;

public class Loan {
    Book book;
    Member member;
    LocalDate borrowedDate;

    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.borrowedDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
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
                """, book, member, getDueDate());
    }
}
