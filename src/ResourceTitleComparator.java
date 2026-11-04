import java.util.Comparator;

public class ResourceTitleComparator implements Comparator<Resource> {
    @Override
    public int compare(Resource resource1, Resource resource2) {
        return resource1.getTitle().compareTo(resource2.getTitle());
    }
}
