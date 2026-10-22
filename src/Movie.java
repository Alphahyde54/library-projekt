public class Movie extends Resource {
    private double length;
    public Movie(String indetifier, String title, String creator, double length){
        super(indetifier, title, creator);
        this.length = length;
    }
    public double getLength() {
        return length;
    }
}
