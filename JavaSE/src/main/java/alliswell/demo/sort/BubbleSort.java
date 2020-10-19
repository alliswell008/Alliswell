package alliswell.demo.sort;

import alliswell.demo.fordemo.ForEach;

/**
 * 冒泡排序
 *
 * 冒泡排序算法的原理如下：
 * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2.对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * @author chengxs
 * @date 2020/6/30
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {89, -7, 999, -89, 7, 0, -888, 7, -7};
//        for (int k : arr) {
//            System.out.print(k + ",");
//        }
        System.out.println();
        bubbleSort(arr);
//        for (int k : arr) {
//            System.out.print(k + ",");
//        }
    }

    public static void bubbleSort(int arr[]) {

        for(int i =0 ; i<arr.length-1 ; i++) {
            for(int j=0 ; j<arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    System.out.print("交换次数i=" + i + ",j=" + j + ":");
                    for (int k : arr) {
                        System.out.print(k + ",");
                    }
                    System.out.println();
                }
                System.out.print("遍历次数i=" + i + ",j=" + j + ":");
                for (int k : arr) {
                    System.out.print(k + ",");
                }
                System.out.println();
            }
        }
    }
}
