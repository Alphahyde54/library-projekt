import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public Library() {

    }

    //Add functions
    public void addMember(Member member) {
        members.add(member);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    // Lists
    public Book getBook(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == id) {
                return books.get(i);
            }
        }
        return null;
    }

        public Loan getLoan ( int index){
            return loans.get(index);
        }

        public Member getMember (int memberNumber) {
            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).getID() == memberNumber) {
                    return members.get(i);
                }
            }
            return null;
        }

    public boolean isAvailable(int bookID) {
        for (Loan loan : loans) {
            if (loan.getBook().getID() == bookID) {
                return false;
            }

        }
        return true;
    }

        public boolean loanBook(int id, int memberNumber){
            if(getMember(memberNumber) != null && getBook(id) != null){
                if(isAvailable(id)){
                    Loan loan = new Loan(getMember(memberNumber), getBook(id));
                    addLoan(loan);
                    return true;
                }
            } else {
                return false;
            }
            return false;
        }

        public void returnBook(int id){
            for (int i = 0 ; i < loans.size() ; i++) {
                if(loans.get(i).getBook().getID() == id){
                    loans.remove(i);
                    IO.println("Book has been returned...");
                } else {
                    IO.println("Book already in library");
                }
            }
        }

        public ArrayList<Loan> findLoansByMemberId(int memberNumber){
            ArrayList<Loan> loanListe = new ArrayList<>();
            for(Loan loan : loans) {
                if (loan.getMember().getID() == memberNumber) {
                    loanListe.add(loan);
                }
            }
            if(loanListe.isEmpty()) {
                return null;
            }
            return loanListe;
        }

// Collections
        public void printBooks () {
            for (Book book : books) {
                if (isAvailable(book.getID())) {
                    IO.println(book + " -- Bogen er på hylden...");
                } else {
                    IO.println(book + " -- Bogen er udlånt...");
                }
            }
        }
        public void printMembers () {
            for (Member members_ : members) {
                IO.println(members_);
            }
        }
}