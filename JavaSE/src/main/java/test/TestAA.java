package test;

import java.lang.reflect.Field;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2019/7/22
 */
public class TestAA {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        swap(a, b);
        System.out.println(" a : " + a);
        System.out.println(" b : " + b);
    }

    private static void swap(Integer a, Integer b) {
//        Integer tmp = a;
//        a = b;
//        b = tmp;
//
//        System.out.println("swap a1 : " + a);
//        System.out.println("swap b1 : " + b);

//        a = a + b;
//        b = a - b;
//        a = a - b;
//        System.out.println("swap a2 : " + a);
//        System.out.println("swap b2 : " + b);

        Field field = null;
        try {
            field = Integer.class.getDeclaredField("value");
            // 私有属性可访问
            field.setAccessible(true);

            Integer tmp = new Integer(a.intValue());
            field.set(a, b.intValue());
            field.set(b, tmp);

            System.out.println("swap a3 : " + a);
            System.out.println("swap b3 : " + b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
