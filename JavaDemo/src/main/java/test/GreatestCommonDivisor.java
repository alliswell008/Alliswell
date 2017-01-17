/**
 * @Title: GreatestCommonDivisor
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2017/1/17 14:33
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
 * @ClassName: GreatestCommonDivisor
 * @Description: TODO(用一句话来说明)
 * @date 2017/1/17 14:33
 */
public class GreatestCommonDivisor {
    static int count = 0;
    public static void main(String[] args)
    {
        System.out.println(getGreatestCommonDivisor(131111110, 111111111));
        System.out.println(count);
        System.out.println(4&1);
        System.out.println(131111110>>1);
        System.out.println(gcd2(131111110, 111111111));
    }

    // 入口方法
    public static int getGreatestCommonDivisor(int numberA, int numberB)
    {
        int result = 1;
        if(numberA > numberB)
            result = gcd(numberA, numberB);
        else {
            result = gcd(numberB, numberA);
        }
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

    public static int gcd2(int a, int b)
    {
        if(a == b)
            return a;
        if(a<b)
            return gcd(b, a);
        else
        if(!((a&1) == 0) && !((b&1)==0))
        {
            return gcd2(a>>1, b>>1);
        }
        else if(!((a&1) == 0) && ((b&1)==0))
        {
            return gcd2(a>>1, b);
        }
        else if(((a&1) == 0) && !((b&1)==0))
        {
            return gcd2(a, b>>1);
        }
        else
        {
            return gcd2(a, a-b);
        }

    }
}
