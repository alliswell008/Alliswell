/**
 * @Title: GreatestCommonDivisor
 * @Package org.alliswell.demo.greatestcommondivisordemo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/25 0:53
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.greatestcommondivisordemo;

/**
 * @author alliswell008
 * @ClassName: GreatestCommonDivisor
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/25 0:53
 */
public class GreatestCommonDivisor {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("最大公约数：" + getGreatestCommonDivisor(131111110, 111111111));
        System.out.println("辗转相除的次数（用于考虑效率问题）：" + count);

        System.out.println("===============");
        System.out.println(4&1);
        System.out.println(2&1);
        System.out.println("偶数与1按位与结果为0");
        System.out.println(5&1);
        System.out.println(3&1);
        System.out.println("奇数与1按位与结果为1");
        System.out.println("根据此特性可以判断一个整数的奇偶性");
        System.out.println("===============");

        System.out.println("若一个数为偶数则可以进行移位操作" + (131111110>>1));

        System.out.println(111111111 % 65555555);
    }

    // 入口方法
    public static int getGreatestCommonDivisor(int numberA, int numberB)
    {
        long stime = System.currentTimeMillis();
        int result = 1;
        if(numberA > numberB)
            result = gcd2(numberA, numberB);
        else {
            result = gcd2(numberB, numberA);
        }
        long etime = System.currentTimeMillis();
        System.out.println("辗转相除法执行时间：" + (etime - stime));
        return result;
    }

    // 辗转相除法
    public static int gcd(int a, int b)
    {
        count ++;
        if(a%b == 0)
            return b;
        else
            return gcd(b, a%b);
    }

    /**
     * 辗转相减法
     * @param a
     * @param b
     * @return
     */
    public static int gcd2(int a, int b)
    {
        if(a == b)
            return a;
        if(a<b)
            return gcd(b, a);
        else
        if((a&1) == 0 && (b&1) == 0)
        {
            return gcd2(a>>1, b>>1);
        }
        else if((a&1) == 0 && !((b&1)==0))
        {
            return gcd2(a>>1, b);
        }
        else if(!((a&1) == 0) && (b&1)==0)
        {
            return gcd2(a, b>>1);
        }
        else
        {
            return gcd2(a, a-b);
        }

    }
}
