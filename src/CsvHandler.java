import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    private final CsvMapper csvMapper;
    private  final Path path;

    public CsvHandler(Path path, CsvMapper csvMapper){
        this.csvMapper = csvMapper;
        this.path = path;
    }

    public List<Member> loadMembers() throws IOException{
        Path file = path.resolve("members.csv");
        List<Member> members = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while((line = reader.readLine()) != null){
                Member member = csvMapper.fromCsvMember(line);
                members.add(member);
            }
        }
        return members;
    }

    public List<Book> loadBooks() throws IOException{
        Path file = path.resolve("book.csv");
        List<Book> books = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while((line = reader.readLine()) != null){
                Book book = csvMapper.fromCsvBook(line);
                books.add(book);
            }
        }
        return books;
    }
    public List<AudioBook> loadAudioBooks() throws IOException{
        Path file = path.resolve("audiobook.csv");
        List<AudioBook> audioBooks = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while((line = reader.readLine()) != null){
                AudioBook audioBook = csvMapper.fromCsvAudio(line);
                audioBooks.add(audioBook);
            }
        }
        return audioBooks;
    }
    public List<Movie> loadMovies() throws IOException{
        Path file = path.resolve("movie.csv");
        List<Movie> movies = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while((line = reader.readLine()) != null){
                Movie movie = csvMapper.fromCsvMovie(line);
                movies.add(movie);
            }
        }
        return movies;
    }
    public List<VideoGame> loadVideoGames() throws IOException{
        Path file = path.resolve("videogame.csv");
        List<VideoGame> videoGames = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(file)){
            String line;
            while((line = reader.readLine()) != null){
                VideoGame videoGame = csvMapper.fromCsvGame(line);
                videoGames.add(videoGame);
            }
        }
        return videoGames;
    }

    public List<Resource> loadResources() throws IOException{
        List<Resource> resources = new ArrayList<>();
        for(VideoGame game : loadVideoGames()){
            resources.add(game);
        }
        for(AudioBook audioBook : loadAudioBooks()){
            resources.add(audioBook);
        }
        for(Book book : loadBooks()){
            resources.add(book);
        }
        for(Movie movies : loadMovies()){
            resources.add(movies);
        }
        return resources;
    }

    public List<Loan> loadLoans(List<Member> members, List<Resource> resources) throws IOException {
        Path file = path.resolve("loans.csv");
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                loans.add(csvMapper.fromCsvLoan(line, members, resources));
            }
        }
        return loans;
    }

    public  void saveBook(List<Book> books)throws IOException{
        Path file = path.resolve("book.csv");
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            for (Book book : books) {
                writer.write(csvMapper.toCsvBook(book));
                writer.newLine();
            }
        }
    }
    public  void saveAudio(List<AudioBook> audioBooks)throws IOException{
        Path file = path.resolve("audiobook.csv");
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            for(AudioBook audioBook : audioBooks) {
                writer.write(csvMapper.toCsvAudio(audioBook));
                writer.newLine();
            }
        }
    }
    public  void saveMovie(List<Movie> movies)throws IOException{
        Path file = path.resolve("movie.csv");
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            for(Movie movie : movies) {
                writer.write(csvMapper.toCsvMovie(movie));
                writer.newLine();
            }
        }
    }
    public  void saveGame(List<VideoGame> games)throws IOException{
        Path file = path.resolve("videogame.csv");
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            for(VideoGame videoGame : games) {
                writer.write(csvMapper.toCsvGame(videoGame));
                writer.newLine();
            }
        }
    }
    public  void saveMembers(List<Member> members)throws IOException{
        Path file = path.resolve("members.csv");
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            for(Member member : members){
                writer.write(csvMapper.toCsvMember(member));
                writer.newLine();
            }
        }
    }
    public  void saveLoans(List<Loan> loans)throws IOException{
        Path file = path.resolve("loans.csv");
        try(BufferedWriter writer = Files.newBufferedWriter(file)){
            for(Loan loan : loans){
                writer.write(csvMapper.toCsvLoan(loan));
                writer.newLine();
            }
        }
    }

    public void saveResources(List<Resource> resources){
        List<Book> books = new ArrayList<>();
        List<AudioBook> audioBooks = new ArrayList<>();
        List<VideoGame> games = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        for(Resource resource : resources){
            if(resource instanceof Book){
                books.add((Book) resource);
            } else if (resource instanceof AudioBook) {
                audioBooks.add((AudioBook) resource);
            } else if (resource instanceof VideoGame) {
                games.add((VideoGame) resource);
            } else if (resource instanceof Movie) {
                movies.add((Movie) resource);
            }
        }

        try {
            saveBook(books);
        } catch (IOException e) {
            IO.println("Fejl i saveBooks");
        } try {
            saveAudio(audioBooks);
        } catch (IOException e) {
            IO.println("Fejl i saveAudio");
        } try {
            saveGame(games);
        } catch (IOException e) {
            IO.println("Fejl i saveGame");
        } try {
            saveMovie(movies);
        } catch (IOException e) {
            IO.println("Fejl i saveMovie");
        }
    }
}
