package alliswell.demo.operator;

/**
 * 运算符
 * 参见operator.md
 */
public class OperatorDemo {

    public static void main(String[] args) {
        getResult();
        getResult2();
        getResult3();
    }


    /**
     * ++或--的运算顺序：++x表示使用x的+1值，x++表示使用x的值后再对x的值+1，--同理。
     * <p>
     * （x++)/3是先执行x/3的操作，就相当于先执行2/3，/操作取结果的整数部分，所以运行结果是0，
     * 在x使用之后才会对x的值+1再赋值给x（此时x=x+1=3）。
     * 如果将x++换成++x，就是先对x的值+1再赋给x（此时x=x+1=3）,再进行3/3操作，此时运行结果为1。
     */
    static void getResult() {
        int x = 2, t1 = 0, t2, t3;
        t1 = x++ / 3;
        System.out.println("x1=" + x);

        x = 2;
        t2 = ++x / 3;
        System.out.println("x2=" + x);

        x = 2;
        x++;
        t3 = x / 3;

        // 注意t1和t2、t1和t3的不同
        System.out.println("t1=" + t1 + ",t2=" + t2 + ",t3=" + t3);
    }

    /**
     * 左移运算符，将运算符左边的对象向左移动运算符右边指定的位数（在低位补0）
     * "有符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。使用符号扩展机制，也就是说，如果值为正，则在高位补0，如果值为负，则在高位补1.
     * "无符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。采用0扩展机制，也就是说，无论值的正负，都在高位补0.
     */
    static void getResult2() {
        // 1111111111111111111111111111111111111111111111111111111111110110
        int x = -10;
        int x1 = x >>= 4;
        x = -10;
        int x2 = x >>>= 4;
        System.out.println("x1=" + x1 + ",x2=" + x2);
    }


    static void getResult3() {
        // 1111111111111111111111111111111111111111111111111111111111110110
        int x = 0;
        int x1 = ~x;
        x = -10;
        boolean x2 = !(x==0);
        long x3 = ~(1L);
        System.out.println("x1=" + x1 + ",x2=" + x2 + ",x3=" + x3);

    }

}
