import java.util.Locale;

public class ConsoleUI {
    Library library;


    public ConsoleUI(Library library){
        this.library = library;
    }

    public void run(){
        boolean running = true;
        while (running){
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast valg: "));
            switch (choice){
                case 1 -> borrowBook();
                case 2 -> returnMaterial();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Lån");
            }
        }
        IO.println("God dag:)");
    }


    private void showMenu(){
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }

    public void borrowBook(){
        library.printResources();
       int memberNumber = Integer.parseInt(IO.readln("Hvad er dit medlemsnummer? "));
       String title = (IO.readln("Hvilket materiale vil du låne? "));

       switch(library.loanMaterial(title, memberNumber)){
           case SUCCESS -> IO.println("Du har nu lånt: " + library.getResource(title));
           case CANNOT_LOAN -> IO.println("Du kan ikke låne det valgte materiale");
           case WRONGID -> IO.println("Du har indtastet et ID, som ikke er registreret i systemet");
           case WRONGTITEL -> IO.println("Du har indtastet en titel som ikke eksistere");
           case CANNOT_LOAN_MORE -> IO.println("Du kan ikke låne " + library.getResource(title) +
                   "da man kun må have op til 3 film og/eller videospil lånt på samme tid");
           case ERROR -> IO.println("Der er sket en fejl...");
       }
    }

    public void returnMaterial(){
        library.printResources();
        String title = IO.readln("Hvad vil du gerne returnere? ");
        library.returnMaterial(title);
    }

    public void showLoans(){
        int memberNumber = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        if (!library.findLoansByMemberId(memberNumber).isEmpty()) {
            IO.println(library.findLoansByMemberId(memberNumber));
        } else {
            IO.println("Det indtastede medlemsnummer har ingen aktive lån.");
        }
    }
}
