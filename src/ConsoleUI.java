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
                case 2 -> returnBook();
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
        library.printBooks();
       int memberNumber = Integer.parseInt(IO.readln("Hvad er dit medlemsnummer? "));
       int id = Integer.parseInt(IO.readln("Hvilken bog vil du låne? "));

       if(library.loanBook(id, memberNumber)){
           IO.println("Du har nu lånt: " + library.getBook(id));
       } else {
           IO.println("Der er sket en fejl...");
       }
    }

    public void returnBook(){
        library.printBooks();
        int id = Integer.parseInt(IO.readln("Hvilken bog vil du returnere? "));
        library.returnBook(id);
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
