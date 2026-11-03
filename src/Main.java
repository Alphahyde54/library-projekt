void main() {
    LoanPolicy loanPolicy = new StandardLoanPolicy();

    Path path = Path.of("C:\\Users\\danie\\OneDrive - Erhvervsakademi København\\Dokumenter\\2026-10-20,Programmering,10.csv");
    CsvMapper csvMapper = new CsvMapper();
    CsvHandler csvHandler = new CsvHandler(path, csvMapper);
    List<Resource> resources = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();

   try{
       resources = csvHandler.loadResources();
   } catch (IOException e){
       IO.println("Fejl i loadResources");
   }

    try{
        members = csvHandler.loadMembers();
    } catch (IOException e){
        IO.println("Fejl i loadMembers");
    }
    try{
        loans = csvHandler.loadLoans(members,resources);
    } catch (IOException e) {
        IO.println("Fejl i loadLoans");
    }


    csvHandler.saveResources(resources);
    try{
        csvHandler.saveMembers(members);
    } catch (IOException e) {
        IO.println("Fejl i saveMembers");
    }
    try{
        csvHandler.saveLoans(loans);
    } catch (IOException e) {
        IO.println("Fejl i saveLoans");
    }

    Library library = new Library(resources, members, loanPolicy, loans);
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}
