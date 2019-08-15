package alliswell.demo.string;

/**
 * 字符串常量池
 *
 * @author chengxs
 * @date 2019/8/14
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "Programming";
        // new会在堆中产生一个新的对象，新对象的引用指向常量池中的对象
        String s2 = new String("Programming");
        // 常量池中同一个对象
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        // intern()方法从常量池中查询，如果存在则返回其引用，如果不存在则将该值复制到常量池并返回其引用
        System.out.println(s1 == s1.intern());


        String ss3 = new String("1") + new String("1");
         ss3.intern();
        String s4 = "11";
        System.out.println(ss3 == s4);

        System.out.println("TC-U9D-MJKZQ,TC-U9MJ-D/SF,TC-3000MJ-1/SF".contains("TC-U9D-MJKZQ"));
    }
}
