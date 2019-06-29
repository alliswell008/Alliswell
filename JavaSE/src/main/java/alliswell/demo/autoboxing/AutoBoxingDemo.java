package alliswell.demo.autoboxing;

/**
 * Created by Administrator on 2018/3/2.
 * 如果a==c且b==c，则a与不一定相等
 */
public class AutoBoxingDemo {

    public static void main(String[] args) {
        Integer a = new Integer(150);
        Integer b = 150;
        int c = 150;
        Integer d = 150;

        System.out.println(a == b); //false
        System.out.println(a == c); //true
        System.out.println(b == c); //true
        System.out.println(b == d); //true
    }
}
