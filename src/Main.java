void main() {
    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);

    Book book1 = new Book("9781492072508", "Think Java", "Allan B. Downey", 326);
    Book book2 = new Book("9788763851664", "Omrids", "Rachel Cusk", 256);
    Book book3 = new Book("9780062316097", "Sapiens", "Yuval Noah Harari", 466);
    Movie movie1 = new Movie("5701234567890", "Interstellar", "Christopher nolan", 169);
    Movie movie2 = new Movie("6701234567891", "Good Will Hunting", "Gus Van Sant", 126);
    Movie movie3 = new Movie("7701234567892", "Oppenheimer", "Christopher Nolan", 180);
    AudioBook audioBook1 = new AudioBook("8801234567822", "The Count Of Monte Cristo", "Alexandre Dumas", 886);
    AudioBook audioBook2 = new AudioBook("9801234567823", "Norweigan Woods", "Haruki Murakami", 384);
    AudioBook audioBook3 = new AudioBook("6801234567824", "Red Rising", "Pierce Brown", 382);
    VideoGame videoGame1 = new VideoGame("5801234567821", "League of Legends", "Riot Games");
    VideoGame videoGame2 = new VideoGame("9901234567822", "Grand Theft Auto: San Andreas", "Rockstar Games");
    VideoGame videoGame3 = new VideoGame("2801234567855", "Call of Duty: Black Ops 2", "Activision");



    Member member1 = new Member("Daniel", 1234);
    Member member2 = new Member("Loke", 4567);
    Member member3 = new Member("Lucas", 7890);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addMovie(movie1);
    library.addMovie(movie2);
    library.addMovie(movie3);
    library.addAudioBook(audioBook1);
    library.addAudioBook(audioBook2);
    library.addAudioBook(audioBook3);
    library.addVideoGame(videoGame1);
    library.addVideoGame(videoGame2);
    library.addVideoGame(videoGame3);

    consoleUI.run();
}
