package alliswell.demo.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest2 {
    public static final String INSTANCE_HASHCODE = "instance.hashcode:";
    private static String str;
    private Integer a;
    private Integer b;

    private HashMapTest2() {
    }

    private HashMapTest2(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Map<HashMapTest2, Integer> map = new HashMap<HashMapTest2, Integer>();
        HashMapTest2 instance = new HashMapTest2(1);
        System.out.println(INSTANCE_HASHCODE + instance.hashCode());
        HashMapTest2 newInstance = new HashMapTest2(33);
        String s = "newInstance.hashcode:";
        System.out.println(s + newInstance.hashCode());
        map.put(instance, 1);
        map.put(newInstance, 2);
        Integer value = map.get(instance);
        str = "instance value:";
        System.out.println(str + value);
        Integer value1 = map.get(newInstance);
        System.out.println("newInstance value:"+value1);
        System.out.println("size:"+ map.size());
        System.out.println(instance.equals(newInstance));


        int h;
        String keys = "asffs";
        int r = (h = keys.hashCode()) ^ h >>> 16;
        System.out.println(keys);

        System.out.println(r);
        Collections.synchronizedMap(new HashMap<>());
        ArrayList arrayList = new ArrayList();
        for (Object ignored : arrayList) {
            Vector v = null;
        }
        r = 0b00000110 >>> 1 & 2;
        System.out.println(Integer.toBinaryString(r));

        ConcurrentHashMap<Void, Void> cmap = new ConcurrentHashMap<>();

    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof HashMapTest)) {

            return false;
        } else {
            HashMapTest2 other = (HashMapTest2)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                Integer this$data = this.getA();
                Integer other$data = other.getA();
                if(this$data == null) {
                    if(other$data != null) {
                        return false;
                    }
                } else if(!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }
    protected boolean canEqual(Object other) {
        return other instanceof HashMapTest;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getA() {
        return a;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        Integer $data = this.getA();
        int result1 = result * 59 + ($data == null?43:$data.hashCode());
        return result1;
    }
}
//运行结果：
//instance value:1
//newInstance value:2
