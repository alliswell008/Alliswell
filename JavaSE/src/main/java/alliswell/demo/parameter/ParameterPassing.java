package alliswell.demo.parameter;

import java.lang.reflect.Field;

/**
 * Java中方法的参数传递问题
 *
 * @author chengxs
 * @date 2019/7/22
 */
public class ParameterPassing {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;

        // 方法里交换了，方法外仍没有交换
        swap2(a, b);
        System.out.println(" a : " + a);
        System.out.println(" b : " + b);
        swap3(a, b);
        System.out.println(" a : " + a);
        System.out.println(" b : " + b);

        // 方法里外都交换了
        swap(a, b);
        System.out.println(" a : " + a);
        System.out.println(" b : " + b);

        // 字符串的交换同理
        String sa = "sa";
        String sb = "sb";
        swap2(sa,sb);
        System.out.println(" sa : " + sa);
        System.out.println(" sb : " + sb);
        swap(sa,sb);
        System.out.println(" sa : " + sa);
        System.out.println(" sb : " + sb);



        Double da = 10D;
        Double db = 20D;

        // 方法里外都交换了
        swap(da, db);
        System.out.println(" da : " + da);
        System.out.println(" db : " + db);
    }

    private static void swap(Integer a, Integer b) {
        Field field = null;
        try {
            field = Integer.class.getDeclaredField("value");
            // 私有属性可访问
            field.setAccessible(true);

            Integer tmp = new Integer(a.intValue());
            field.set(a, b.intValue());
            field.set(b, tmp);

            System.out.println("swap a1 : " + a);
            System.out.println("swap b1 : " + b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void swap2(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;

        System.out.println("swap a2 : " + a);
        System.out.println("swap b2 : " + b);
    }

    private static void swap3(Integer a, Integer b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("swap a3 : " + a);
        System.out.println("swap b3 : " + b);
    }

    private static void swap(String a, String b) {
        Field field = null;
        try {
            field = String.class.getDeclaredField("value");
            // 私有属性可访问
            field.setAccessible(true);

            char[] tmp = a.toCharArray();
            field.set(a, b.toCharArray());
            field.set(b, tmp);

            System.out.println("swap sa1 : " + a);
            System.out.println("swap sb1 : " + b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void swap2(String a, String b) {
        String tmp = a;
        a = b;
        b = tmp;

        System.out.println("swap sa2 : " + a);
        System.out.println("swap sb2 : " + b);
    }



    private static void swap(Double a, Double b) {
        Field field = null;
        try {
            field = Double.class.getDeclaredField("value");
            // 私有属性可访问
            field.setAccessible(true);

            Double tmp = new Double(a.doubleValue());
            field.set(a, b.doubleValue());
            field.set(b, tmp);

            System.out.println("swap da : " + a);
            System.out.println("swap db : " + b);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
