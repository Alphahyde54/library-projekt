void main() throws IOException {
    LoanPolicy loanPolicy = new StandardLoanPolicy();

    Path path = Path.of("C:\\Users\\danie\\OneDrive - Erhvervsakademi København\\Dokumenter\\2026-10-20,Programmering,10.csv");
    CsvMapper csvMapper = new CsvMapper();
    CsvHandler csvHandler = new CsvHandler(csvMapper);

    Path booksPath = path.resolve("book.csv");
    Path moviesPath = path.resolve("movie.csv");
    Path gamesPath = path.resolve("videogames.csv");
    Path audioPath = path.resolve("audiobook.csv");
    Path membersPath = path.resolve("members.csv");
    Path loansPath = path.resolve("loans.csv");

    List<Resource> resources = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    List<Loan> loans = new ArrayList<>();

    List<Book> books = csvHandler.loadBooks(booksPath);
    List<Movie> movies = csvHandler.loadMovies(moviesPath);
    List<VideoGame> videoGames = csvHandler.loadVideoGames(gamesPath);
    List<AudioBook> audioBooks = csvHandler.loadAudioBooks(audioPath);

    books.sort(new ResourceCreatorComparator());
    books.sort(new ResourceTitleComparator());

    movies.sort(new ResourceCreatorComparator());
    movies.sort(new ResourceTitleComparator());

    videoGames.sort(new ResourceCreatorComparator());
    videoGames.sort(new ResourceTitleComparator());

    audioBooks.sort(new ResourceTitleComparator());
    audioBooks.sort(new ResourceCreatorComparator());

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
