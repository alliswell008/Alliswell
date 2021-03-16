package alliswell.demo.clone;

import java.util.Arrays;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2021/3/1
 */
public class ArrayClone {

    public static void main(String[] args) {
        testInt();
        testString();
        testSystemArraycopy();
        testArraysCopyOf();
        testArraysCopyOfRange();

    }

    static void testInt() {
        int[] a1 = {1, 3};
        int[] a2 = a1.clone();

        a1[0] = 666;
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    static void testString() {
        String[] a1 = {"a1", "a2"};
        String[] a2 = a1.clone();

        a1[0] = "666";
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    static void testSystemArraycopy() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = new int[10];

        // （原数组， 原数组的开始位置， 目标数组， 目标数组的开始位置， 拷贝个数）
        System.arraycopy(a1, 1, a2, 3, 3);
        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [0, 0, 0, 2, 3, 4, 0, 0, 0, 0]
    }

    static void testArraysCopyOf() {
        int[] a1 = {1, 2, 3, 4, 5};
        // （原数组，拷贝的个数）
        int[] a2 = Arrays.copyOf(a1, 3);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [1, 2, 3]
    }

    static void testArraysCopyOfRange() {
        int[] a1 = {1, 2, 3, 4, 5};
        // （原数组，开始位置，结束位置），原数组不足时补0
        int[] a2 = Arrays.copyOfRange(a1, 3, 7);

        System.out.println(Arrays.toString(a1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(a2)); // [4, 5, 0, 0]
    }
}

//[666, 3]
//[1, 3]
//[666, a2]
//[a1, a2]
//[1, 2, 3, 4, 5]
//[0, 0, 0, 2, 3, 4, 0, 0, 0, 0]
//[1, 2, 3, 4, 5]
//[1, 2, 3]
//[1, 2, 3, 4, 5]
//[4, 5, 0, 0]
