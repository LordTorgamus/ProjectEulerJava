package utils.collections;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
    public static long getSum(Collection<? extends Number> collection) {
        Iterator<? extends Number> iterator = collection.iterator();
        long sum = 0;
        while(iterator.hasNext()) {
            sum += iterator.next().longValue();
        }
        
        return sum;
    }
}
