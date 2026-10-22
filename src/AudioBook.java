public class AudioBook extends Resource {
    private double length;
    public AudioBook(String indetifier, String title, String creator, double length){
        super(indetifier, title, creator);
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}
