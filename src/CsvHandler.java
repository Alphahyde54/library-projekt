import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    private final CsvMapper csvMapper;

    public CsvHandler(CsvMapper csvMapper){
        this.csvMapper = csvMapper;
    }

    public List<Member> loadMembers(Path path) throws IOException{
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

    public List<Book> loadBooks(Path path) throws IOException{
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
    public List<AudioBook> loadAudioBooks(Path path) throws IOException{
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
    public List<Movie> loadMovies(Path path) throws IOException{
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
    public List<VideoGame> loadVideoGames(Path path) throws IOException{
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

    public List<Resource> loadResources(Path path) throws IOException{
        List<Resource> resources = new ArrayList<>();
        resources.addAll(loadVideoGames(path.resolve("videogames.csv")));
        resources.addAll(loadAudioBooks(path.resolve("audiobook.csv")));
        resources.addAll(loadBooks(path.resolve("book.csv")));
        resources.addAll(loadMovies(path.resolve("movie.csv")));
        return resources;
    }

    public List<Loan> loadLoans(List<Member> members, List<Resource> resources, Path path) throws IOException {
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                loans.add(csvMapper.fromCsvLoan(line, members, resources));
            }
        }
        return loans;
    }

    public void saveBook(Book book, Path path)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvBook(book));
                writer.newLine();
        }
    }
    public  void saveAudio(List<AudioBook> audioBooks, Path path)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(csvMapper.toCsvAudio((Resource) audioBooks));
                writer.newLine();
        }
    }
    public  void saveMovie(List<Movie> movies, Path path)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvMovie((Resource) movies));
                writer.newLine();
        }
    }
    public  void saveGame(List<VideoGame> videoGames, Path path)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
                writer.write(csvMapper.toCsvGame((Resource) videoGames));
                writer.newLine();
        }
    }
    public  void saveMembers(List<Member> members, Path path)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Member member : members){
                writer.write(csvMapper.toCsvMember(member));
                writer.newLine();
            }
        }
    }
    public  void saveLoans(List<Loan> loans, Path path)throws IOException{
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Loan loan : loans){
                writer.write(csvMapper.toCsvLoan(loan));
                writer.newLine();
            }
        }
    }

    public void saveResources(List<Resource> resources, Path path){
        for(Resource resource : resources){
            if(resource instanceof Book){
                try {
                    saveBook((Book) resource, path);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveBooks");
                }
            } else if (resource instanceof AudioBook) {
                try {
                    saveAudio(List.of((AudioBook) resource), path);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveAudio");
                }
            } else if (resource instanceof VideoGame) {
                try {
                    saveGame(List.of((VideoGame) resource), path);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveGame");
                }
            } else if (resource instanceof Movie) {
                try {
                    saveMovie(List.of((Movie) resource), path);
                } catch(IOException e){
                    IO.println("Fejl i saveResource - saveMovie");
                }
            }
        }
    }
}
