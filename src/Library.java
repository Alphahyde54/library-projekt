import java.util.ArrayList;

public class Library {
    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public Library() {

    }

    //Add functions
    public void addMember(Member member) {
        members.add(member);
    }

    public void addBook(Book book) {
        resources.add(book);
    }

    public void addVideoGame(VideoGame videoGame){
        resources.add(videoGame);
    }
    public void addMovie(Movie movie){
        resources.add(movie);
    }
    public void addAudioBook(AudioBook audioBook){
        resources.add(audioBook);
    }


    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    // Lists
    public Resource getResource(String identifier) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i).getIdentifier().equalsIgnoreCase(identifier)) {
                return resources.get(i);
            }
        }
        return null;
    }

        public Loan getLoan (int index){
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

    public boolean isAvailable(String identifier) {
        for (Loan loan : loans) {
            if (loan.getBook().getIdentifier().equalsIgnoreCase(identifier)) {
                return false;
            }

        }
        return true;
    }

        public LoanResult loanMaterial(String identifier, int memberNumber){
            if(getMember(memberNumber) != null && getResource(identifier) != null){
                if(isAvailable(identifier)){
                    Loan loan = new Loan(getMember(memberNumber), getResource(identifier));
                    addLoan(loan);
                    return LoanResult.LOANED;
                }
            } else {
                return LoanResult.CANNOT_LOAN;
            }
            return LoanResult.ERROR;
        }

        public void returnMaterial(int id){
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