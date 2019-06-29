package alliswell.demo.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;

public class NullCollectionsDemo {

    public static void main(String[] args) {
        testNullCollections();
    }

    public static void testNullCollections() {
        HashMap sb = new HashMap();

        sb.put(null, null);
        TreeSet set = new TreeSet();
        set.add(null);

        Hashtable ht = new Hashtable();
        ht.put(null, null);
    }
}