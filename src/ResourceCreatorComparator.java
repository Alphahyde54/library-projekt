import java.text.Collator;
import java.util.Comparator;

public class ResourceCreatorComparator implements Comparator <Resource>{
    private  final Collator collator;

    public ResourceCreatorComparator(Collator collator) {
        this.collator = collator;
    }

    @Override
    public int compare(Resource resource1, Resource resource2) {
        int result = collator.compare(resource1.getCreator(), resource2.getCreator());
        if (result != 0 ){
            return result;
        }
        return collator.compare(resource1.getTitle(),resource2.getTitle());
    }
}
