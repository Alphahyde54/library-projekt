void main() {
    LoanPolicy loanPolicy = new StandardLoanPolicy();
    LoanPolicy aalborgLoanPolicy = new AalborgLoanPolicy();
    LoanPolicy bornholmLoanPolicy = new BornholmLoanPolicy();

    List<Resource> resources = List.of(
    new Book("9781492072508", "Think Java", "Allan B. Downey", 326),
    new Book("9788763851664", "Omrids", "Rachel Cusk", 256),
    new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 466),

    new Movie("5701234567890", "Interstellar", "Christopher nolan", 169),
    new Movie("6701234567891", "Good Will Hunting", "Gus Van Sant", 126),
    new Movie("7701234567892", "Oppenheimer", "Christopher Nolan", 180),

    new AudioBook("8801234567822", "The Count Of Monte Cristo", "Alexandre Dumas", 886),
    new AudioBook("9801234567823", "Norweigan Woods", "Haruki Murakami", 384),
    new AudioBook("6801234567824", "Red Rising", "Pierce Brown", 382),

    new VideoGame("5801234567821", "League of Legends", "Riot Games"),
    new VideoGame("9901234567822", "Grand Theft Auto: San Andreas", "Rockstar Games"),
    new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision")
    );

    List<Member> members = List.of(
    new Member("Daniel", 1234, aalborgLoanPolicy),
    new Member("Loke", 9999, bornholmLoanPolicy),
    new Member("Lucas", 1212, loanPolicy)
    );
    Library library = new Library(resources, members, loanPolicy);
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}
