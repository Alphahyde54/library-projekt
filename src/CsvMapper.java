import java.time.LocalDate;
import java.util.List;

public class CsvMapper {
String delimiter = ",";

    public Member fromCsvMember(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Member(
                fields[1],
                Integer.parseInt(fields[0])
        );
    }

    public Book fromCsvBook(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Book(
                fields[0],
                fields[1],
                fields[2],
                Double.parseDouble(fields[3])
        );
    }
    public AudioBook fromCsvAudio(String line) {
        String[] fields = line.split(delimiter, -1);
        return new AudioBook(
                fields[0],
                fields[1],
                fields[2],
                Double.parseDouble(fields[3])
        );
    }
    public Movie fromCsvMovie(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Movie(
                fields[0],
                fields[1],
                fields[2],
                Double.parseDouble(fields[3])
        );
    }
    public VideoGame fromCsvGame(String line) {
        String[] fields = line.split(delimiter, -1);
        return new VideoGame(
                fields[0],
                fields[1],
                fields[2]
        );
    }
    public Loan fromCsvLoan(String line, List<Member> members, List<Resource> resources) {
        String[] fields = line.split(delimiter, -1);
        int memberId = Integer.parseInt(fields[0]);
        String identifier = fields[1];
        LocalDate borrowDate = LocalDate.parse(fields[2]);
        LocalDate dueDate = LocalDate.parse(fields[3]);



        Member member = null;
        for (Member m : members) {
            if (m.getID() == memberId) member = m;
        }
        Resource resource = null;
        for (Resource r : resources) {
            if (r.getIdentifier().equals(identifier)) resource = r;
        }
        return new Loan(member, resource, borrowDate, dueDate);
    }



    public String toCsvBook(Resource book) {
        if(book instanceof Book){
        return book.getIdentifier() + delimiter + book.getTitle() + delimiter + book.getCreator() + delimiter + ((Book) book).getLength();
        }
        return null;
    }
    public String toCsvAudio(Resource audioBook){
        if(audioBook instanceof AudioBook) {
            return audioBook.getIdentifier() + delimiter + audioBook.getTitle() + delimiter + audioBook.getCreator() + delimiter + ((AudioBook) audioBook).getLength();
        }
        return null;
    }
    public String toCsvMovie(Resource movie){
        if(movie instanceof Movie) {
            return movie.getIdentifier() + delimiter + movie.getTitle() + delimiter + movie.getCreator() + delimiter + ((Movie) movie).getLength();
        }
        return null;
    }
    public String toCsvGame(Resource videoGame){
            return videoGame.getIdentifier() + delimiter + videoGame.getTitle() + delimiter + videoGame.getCreator();
    }
    public String toCsvMember(Member member){
        return member.getID() + delimiter + member.getNavn();
    }
    public String toCsvLoan(Loan loan){
        return loan.member.getID()+ delimiter + loan.getResource().getIdentifier() + delimiter + loan.getBorrowDate() + delimiter + loan.getDueDate();
    }
}
