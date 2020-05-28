package alliswell.demo.string;

public class SplitDemo {

    public static void main(String[] args) {
        final String str = "a,,b,c,,,";
        String[] ary = str.split(",");
        // 预期数组长度大于4，实际为4
        System.out.println(ary.length);

        // 要注意只输出第二个空字符，末尾的空字符split方法并不会分割出来
        for (String a : ary) {
            System.out.println(a);
        }
    }
}
