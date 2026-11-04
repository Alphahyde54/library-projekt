public class Resource implements Comparable<Resource>{
    private String identifier;
    private String title;
    private String creator;
    public Resource(String identifier, String title, String creator){
        this.identifier = identifier;
        this.title = title;
        this.creator = creator;
    }
    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    @Override
    public String toString(){
        return String.format("""
                %s; %s; %s
                """, title, creator, identifier);
    }

    @Override
    public int compareTo(Resource other){
        return identifier.compareTo (other.identifier);
    }
}
