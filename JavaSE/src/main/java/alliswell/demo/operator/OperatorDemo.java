package alliswell.demo.operator;

public class OperatorDemo {

    public static void main(String[] args) {
        getResult();
    }


    /**
     * ++或--的运算顺序：++x表示使用x的+1值，x++表示使用x的值后再对x的值+1，--同理。
     *
     * （x++)/3是先执行x/3的操作，就相当于先执行2/3，/操作取结果的整数部分，所以运行结果是0，
     * 在x使用之后才会对x的值+1再赋值给x（此时x=x+1=3）。
     * 如果将x++换成++x，就是先对x的值+1再赋给x（此时x=x+1=3）,再进行3/3操作，此时运行结果为1。
     */
    static void getResult() {
        int x = 2, t1 = 0, t2;
        t1 = x++ / 3;
        System.out.println("x1=" + x);

        x = 2;
        t2 = ++x / 3;
        System.out.println("x2=" + x);

        System.out.println("t1=" + t1 + ",t2=" + t2);
    }

}
