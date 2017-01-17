/**
 * @Title: Measurement
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/9 15:55
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package test;

/**
 * @author alliswell008
 * @ClassName: Measurement
 * @Description: <p>成员变量声明后会自动初始化（当然也可以主动初始化），
 * 局部变量则必须要主动初始化（初始化之前需要先声明变量）</p>
 * @date 2016/12/9 15:55
 */
public class Measurement {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;

    void print() {
        System.out.println(
            "Data type  Inital value\n" +
            "boolean    " + t + "\n" +
            "char       " + c + "\n" +  // 返回值为null，则不显示
            "byte       " + b + "\n" +
            "short      " + s + "\n" +
            "int        " + i + "\n" +
            "long       " + l + "\n" +
            "float      " + f + "\n" +
            "double     " + d
        );
    }

    public static void main(String[] args) {
        new Measurement().print();
    }
}


