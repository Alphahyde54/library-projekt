import java.time.LocalDate;
import java.util.List;

public class CsvMapper {
String delimiter = ",";

    public Member fromCsvMember(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Member(
                fields[0],
                Integer.parseInt(fields[1])
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
        int memberId = Integer.parseInt(fields[1]);
        String identifier = fields[2];

        Member member = null;
        for (Member m : members) {
            if (m.getID() == memberId) member = m;
        }
        Resource resource = null;
        for (Resource r : resources) {
            if (r.getIdentifier().equals(identifier)) resource = r;
        }
        return new Loan(member, resource, LocalDate.parse(fields[5]));
    }



    public String toCsvBook(Book book){
        return book.getIdentifier() + delimiter + book.getTitle() + delimiter + book.getCreator() + delimiter + book.getLength();
    }
    public String toCsvAudio(AudioBook audioBook){
        return audioBook.getIdentifier() + delimiter + audioBook.getTitle() + delimiter + audioBook.getCreator() + delimiter + audioBook.getLength();
    }
    public String toCsvMovie(Movie movie){
        return movie.getIdentifier() + delimiter + movie.getTitle() + delimiter + movie.getCreator() + delimiter + movie.getLength();
    }
    public String toCsvGame(VideoGame videoGame){
        return videoGame.getIdentifier() + delimiter + videoGame.getTitle() + delimiter + videoGame.getCreator();
    }
    public String toCsvMember(Member member){
        return member.getNavn() + delimiter + member.getID();
    }
    public String toCsvLoan(Loan loan){
        return loan.member.getID()+ delimiter + delimiter + loan.getResource().getTitle() + delimiter + loan.getDueDate();
    }
}
