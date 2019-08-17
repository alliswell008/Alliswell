package alliswell.demo.shortdemo;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2019/8/15
 */
public class ShortDemo {

    public static void main(String[] args) {
        // 类型转换
        short s1 = 1;
        // short类型+1，存在类型自动放大为int，再赋值时需强制类型转换
        s1 = (short) (s1 + 1);
        // 避免了显式强制类型转化
        s1 += s1 +1;

        // 值越界
        short s2 = Short.MAX_VALUE;
        s2 += 1;
        System.out.println(s2);
    }
}
