import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Library {
    private final List<Resource> resources;
    private final List<Member> members;
    private final List<Loan> loans;
    private LoanPolicy loanPolicy;

    public Library(List<Resource> resources, List<Member> members, LoanPolicy loanPolicy, List<Loan> loans) {

        this.resources = resources;
        this.members = members;
        this.loans = loans;
        this.loanPolicy = loanPolicy;
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

    public List<Loan> getLoans() {
        return loans;
    }
    // Lists
    public Resource getResource(String title) {
        if(title.trim().isEmpty()){
            return null;
        }
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i).getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                return resources.get(i);
            }
        }
        return null;
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
            if (loan.getResource().getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
                return false;
            }

        }
        return true;
    }
    public LoanResult loanMaterial(String title, int memberNumber){
        if (getMember(memberNumber) == null){
            return LoanResult.WRONGID;
        }
        if (getResource(title) == null){
            return LoanResult.WRONGTITEL;
        }
        if (!isAvailable(title)){
            return LoanResult.CANNOT_LOAN;
        }
        LoanPolicy currentPolicy = this.loanPolicy;
        if (!currentPolicy.canLoan(memberNumber, title, loans)){
            return LoanResult.CANNOT_LOAN_MORE;
        }
        LocalDate dueDate = currentPolicy.calculateDueDate(getResource(title));
        Loan loan = new Loan(getMember(memberNumber), getResource(title), LocalDate.now(), dueDate);
        addLoan(loan);
        return LoanResult.SUCCESS;
    }
    /*
    public LoanResult loanMaterial(String title, int memberNumber){
            if(getMember(memberNumber) != null && getResource(title) != null){
                if(isAvailable(title)){
                    Loan loan = new Loan(getMember(memberNumber), getResource(title));
                    addLoan(loan);
                    return LoanResult.LOANED;
                } else {
                    return LoanResult.CANNOT_LOAN;
                }
            } else if (getMember(memberNumber) == null) {
                return LoanResult.WRONGID;
            } else if(getResource(title) == null) {
                return LoanResult.WRONGTITEL;
            }
            return LoanResult.ERROR;
        }

     */

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
        public void printLoans() {
            for(Loan loan : loans){
                IO.println(loan);
            }
        }
        public LoanPolicy setPolicy(String name){
            LoanPolicy standardLoanPolicy = new StandardLoanPolicy();
            LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
            LoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();
            String cleanName = name.toLowerCase().trim();
            if (cleanName.contains("Aalborg".toLowerCase().trim())){
                this.loanPolicy = aalborgLoanPolicy;
            }
             else if (cleanName.contains("Bornholm".toLowerCase().trim())){
                this.loanPolicy = bornholmLoanPolicy;
            } else {
                this.loanPolicy = standardLoanPolicy;
            }
            return this.loanPolicy;
        }
        public LoanPolicy getPolicy() {
            return this.loanPolicy;
        }
        public List<Resource> resourcesSortedByTitle(){
            List<Resource> resourcesSorted = new ArrayList<>(this.resources);
            resourcesSorted.sort(new ResourceTitleComparator());
            return resourcesSorted;
        }
        public List<Resource> resourcesSortedByCreator() {
            List<Resource> resourcesSorted = new ArrayList<>(this.resources);
            resourcesSorted.sort(new ResourceCreatorComparator());
            return resourcesSorted;
        }
        public List<Loan> loansSortedByDueDate() {
            List<Loan> sortedLoans = new ArrayList<>(this.loans);
            sortedLoans.sort(new DueDateComparator());
            return sortedLoans;
        }
        
}