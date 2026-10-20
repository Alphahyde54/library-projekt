import java.util.ArrayList;
import java.util.Locale;

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
    public Resource getResource(String title) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i).getTitle().equalsIgnoreCase(title)) {
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

    public boolean isAvailable(String title) {
        for (Loan loan : loans) {
            if (loan.getResource().getTitle().equalsIgnoreCase(title)) {
                return false;
            }

        }
        return true;
    }

        public LoanResult loanMaterial(String title, int memberNumber){
            if(getMember(memberNumber) != null && getResource(title) != null){
                if(isAvailable(title)){
                    Loan loan = new Loan(getMember(memberNumber), getResource(title));
                    addLoan(loan);
                    return LoanResult.LOANED;
                }
            } else {
                return LoanResult.CANNOT_LOAN;
            }
            return LoanResult.ERROR;
        }

        public void returnMaterial(String title){
            for (int i = 0 ; i < loans.size() ; i++) {
                if(loans.get(i).getResource().getTitle().equalsIgnoreCase(title)){
                    loans.remove(i);
                    IO.println("Material has been returned...");
                } else {
                    IO.println("Material is already in the library");
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
    /*
        public void printBooks () {
            for (Book book : books) {
                if (isAvailable(book.getID())) {
                    IO.println(book + " -- Bogen er på hylden...");
                } else {
                    IO.println(book + " -- Bogen er udlånt...");
                }
            }
        }

     */

        public void printResources(){
            for(Resource resource : resources){
                IO.println(resource);
            }
        }
        public void printMembers () {
            for (Member members_ : members) {
                IO.println(members_);
            }
        }
}