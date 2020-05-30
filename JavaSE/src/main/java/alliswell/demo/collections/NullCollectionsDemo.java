package alliswell.demo.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;

public class NullCollectionsDemo {

    public static void main(String[] args) {
        testNullCollections();
    }

    public static void testNullCollections() {
        // key和value都允许为null
        HashMap sb = new HashMap();
        sb.put(null, null);

        // key和value都不允许为null
        Hashtable ht = new Hashtable();
        ht.put(null, "123");
        ht.put("123", null);
        ht.put(null, null);

        // 不允许为null
        TreeSet set = new TreeSet();
        set.add(null);

    }
}