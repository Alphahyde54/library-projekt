void main() {
    IO.println("""
            1. København
            2. Bornholm
            3. Aalborg
            """);

    LoanPolicy loanPolicy;
    try {
        int number = Integer.parseInt(IO.readln("Hvilket bibliotek er du tilknyttet til? 1-3 "));
        switch (number) {
            case 2 -> loanPolicy = new BornholmLoanPolicy();
            case 3 -> loanPolicy = new AalborgLoanPolicy();
            default -> loanPolicy = new StandardLoanPolicy();
        }
    } catch (NumberFormatException e) {
        IO.println("Ugyldigt valg - bruger Københavns Bibliotek");
        loanPolicy = new StandardLoanPolicy();
    }

    Path path = Path.of("");
    if (loanPolicy instanceof StandardLoanPolicy) {
        path = Path.of("csv/københavn");
    } else if (loanPolicy instanceof BornholmLoanPolicy) {
        path = Path.of("csv/bornholm");
    } else if (loanPolicy instanceof AalborgLoanPolicy) {
        path = Path.of("csv/aalborg");
    }

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
    try {
        try {
            resources = csvHandler.loadResources();
        } catch (IOException e) {
            IO.println("Fejl i loadResources");
        }

        try {
            members = csvHandler.loadMembers();
        } catch (IOException e) {
            IO.println("Fejl i loadMembers");
        }
        try {
            loans = csvHandler.loadLoans(members, resources);
        } catch (IOException e) {
            IO.println("Fejl i loadLoans");
        }
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
       resources = csvHandler.loadResources(path);
   } catch (IOException e){
       IO.println("Fejl i loadResources");
   }

    try{
        members = csvHandler.loadMembers(membersPath);
    } catch (IOException e){
        IO.println("Fejl i loadMembers");
    }
    try{
        loans = csvHandler.loadLoans(members,resources, loansPath);
    } catch (IOException e) {
        IO.println("Fejl i loadLoans");
    }


        Library library = new Library(resources, members, loanPolicy, loans);
        ConsoleUI consoleUI = new ConsoleUI(library);
        consoleUI.run();
    } catch (RuntimeException e){
        IO.println("Programmet crashede " + e.getMessage());
    } finally {
        csvHandler.saveResources(resources);
        try {
            csvHandler.saveMembers(members);
        } catch (IOException e) {
            IO.println("Fejl i saveMembers");
        }
        try {
            csvHandler.saveLoans(loans);
        } catch (IOException e) {
            IO.println("Fejl i saveLoans");
        }
    }
}
