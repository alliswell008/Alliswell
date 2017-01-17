/**
 * @Title: BinaryDemo
 * @Package org.org.alliswell.demo.binarydemo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/22 16:57
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.binarydemo;

/**
 * @author alliswell008
 * @ClassName: BinaryDemo
 * @Description: TODO(用一句话来说明)
 * @date 2016/11/22 16:57
 */
public class BinaryDemo {

    public static void main(String[] args) {
        // 定义二进制数
        int b_x = 0b00000110;
        int b_y = 0b0000_0011;

        // 定义八进制数
        int o_x = 07777;
        int o_y = 000_01;

        // 定义十六进制数
        int h_x = 0xFF_FF;
        int h_y = 0x0001;

        System.out.println("b_x=" + b_x);
        System.out.println("b_y=" + b_y);
        System.out.println("o_x=" + o_x);
        System.out.println("o_y=" + o_y);
        System.out.println("h_x=" + h_x);
        System.out.println("h_y=" + h_y);

        System.out.println("---------");
        // 按位与
        System.out.println("b_x&b_y=" + (b_x&b_y));
        System.out.println("o_x&o_y=" + (o_x&o_y));
        System.out.println("h_x&h_y=" + (h_x&h_y));
        System.out.println("---------");
        // 按位或
        System.out.println("b_x|b_y=" + (b_x|b_y));
        System.out.println("o_x|o_y=" + (o_x|o_y));
        System.out.println("h_x|h_y=" + (h_x|h_y));
        System.out.println("---------");
        // 按位异或
        System.out.println("b_x^b_y=" + (b_x^b_y));

        System.out.println("---------");
        // 按位移位
        System.out.println("移位前b_x="+ Integer.toBinaryString(b_x) + "，移位后b_x=" + Integer.toBinaryString(b_x<<1));
        System.out.println("移位前o_x="+ Integer.toOctalString(o_x) + "，移位后o_x=" + Integer.toOctalString(o_x << 3));
        System.out.println("移位前h_x="+ Integer.toHexString(h_x) + "，移位后h_x=" + Integer.toHexString(h_x << 4));

    }
}
