import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    private final Path path;
    private final CsvMapper csvMapper;

    public CsvHandler(Path path, CsvMapper csvMapper){
        this.csvMapper = csvMapper;
        this.path = path;
    }

    public List<Member> loadMembers() throws IOException{
        List<Member> members = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while((line = reader.readLine()) != null){
                Member member = csvMapper.fromCsvMember(line);
                members.add(member);
            }
        }
        return members;
    }

    public List<Book> loadBooks() throws IOException{
        List<Book> books = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while((line = reader.readLine()) != null){
                Book book = csvMapper.fromCsvBook(line);
                books.add(book);
            }
        }
        return books;
    }
    public List<AudioBook> loadAudioBooks() throws IOException{
        List<AudioBook> audioBooks = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while((line = reader.readLine()) != null){
                AudioBook audioBook = csvMapper.fromCsvAudio(line);
                audioBooks.add(audioBook);
            }
        }
        return audioBooks;
    }
    public List<Movie> loadMovies() throws IOException{
        List<Movie> movies = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while((line = reader.readLine()) != null){
                Movie movie = csvMapper.fromCsvMovie(line);
                movies.add(movie);
            }
        }
        return movies;
    }
    public List<VideoGame> loadVideoGames() throws IOException{
        List<VideoGame> videoGames = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
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
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                loans.add(csvMapper.fromCsvLoan(line, members, resources));
            }
        }
        return loans;
    }

    public  void saveBook(Resource book)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvBook(book));
                writer.newLine();
        }
    }
    public  void saveAudio(Resource audioBook)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvAudio(audioBook));
                writer.newLine();
        }
    }
    public  void saveMovie(Resource movie)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvMovie(movie));
                writer.newLine();
        }
    }
    public  void saveGame(Resource videoGame)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvGame(videoGame));
                writer.newLine();
        }
    }
    public  void saveMembers(List<Member> members)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Member member : members){
                writer.write(csvMapper.toCsvMember(member));
                writer.newLine();
            }
        }
    }
    public  void saveLoans(List<Loan> loans)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Loan loan : loans){
                writer.write(csvMapper.toCsvLoan(loan));
                writer.newLine();
            }
        }
    }

    public void saveResources(List<Resource> resources){
        for(Resource resource : resources){
            if(resource instanceof Book){
                try {
                    saveBook(resource);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveBooks");
                }
            } else if (resource instanceof AudioBook) {
                try {
                    saveAudio(resource);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveAudio");
                }
            } else if (resource instanceof VideoGame) {
                try {
                    saveGame(resource);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveGame");
                }
            } else if (resource instanceof Movie) {
                try {
                    saveMovie(resource);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveMovie");
                }
            }
        }
    }
}
