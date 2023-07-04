import java.util.LinkedHashMap;
import java.util.Map;

public class CacheMap <K,V> extends LinkedHashMap {
    LinkedHashMap<K,V> cache = new LinkedHashMap<>(128, 0.75F, true);

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        {
            return size() > 100;
        }
    }
}
