package alliswell.demo.sort;

import java.util.Random;

/**
 * 快速排序
 *
 * 快速排序算法通过多次比较和交换来实现排序，其排序流程如下：
 * (1)首先设定一个分界值，通过该分界值将数组分成左右两部分。
 * (2)将大于或等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。此时，左边部分中各元素都小于或等于分界值，而右边部分中各元素都大于或等于分界值。
 * (3)然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * (4)重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当左、右两个部分各数据排序完成后，整个数组的排序也就完成了。
 *
 * @author chengxs
 * @date 2020/6/30
 */
public class Quicksort {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        arr = new int[]{-888, 89, -7, 999, -89, 7, 0, 7, -7};
        arr = new int[]{89, -7, 999, -89, 7, 0, -888, 7, -7};
        int len = arr.length - 1;
        arr = qsort(arr, 0, len, 0);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n===========");
        arr = new int[]{89, -7, 999, -89, 7, 0, -888, 7, -7};
        arr = qsort(arr, 0, len, 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n===========");
        arr = new int[]{89, -7, 999, -89, 7, 0, -888, 7, -7};
        arr = qsort(arr, 0, len, 2);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

    public static int[] qsort(int arr[], int start, int end, int mode) {
        int pivot = arr[getPivot(start, end, mode)];

        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else if (i == j) {

            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                System.out.print("交换次数i=" + i + ",j=" + j + ":");
                for (int k : arr) {
                    System.out.print(k + ",");
                }
                System.out.println();
            }
        }
        if (i - 1 > start) arr = qsort(arr, start, i - 1, mode);
        if (j + 1 < end) arr = qsort(arr, j + 1, end, mode);
        return arr;
    }

    private static int getPivot(int start, int end, int mode) {
        if (mode == 1) {
            // 随机快排
            return new Random().nextInt(end - start) + start + 1;
        } else if (mode == 2) {
            // 平衡快排
            return (start + end) / 2;
        } else {
            // 默认快排
            return start;
        }
    }

    /*//////////////////////////方式二////////////////////////////////*/
    // 更高效点的代码：(TextendsComparable和SortUtil都是自己封装的类，里面重写和实现了compareTo和swap方法)
//    public <T extends Comparable<? super T>> T[] quickSort(T[] targetArr,int start,int end)
//    {
//        int i=start+1,j=end;
//        T key=targetArr[start];
//        SortUtil<T> sUtil=new SortUtil<T>();
//
//        if(start==end)return(targetArr);
//
//
//        /*从i++和j--两个方向搜索不满足条件的值并交换
//         *
//         *条件为：i++方向小于key，j--方向大于key
//         */
//        while(true)
//        {
//            while(targetArr[j].compareTo(key)>0)j--;
//            while(targetArr[i].compareTo(key)<0&&i<j)i++;
//            if(i>=j)break;
//            sUtil.swap(targetArr,i,j);
//            if(targetArr[i]==key)
//            {
//                j--;
//            }else{
//                i++;
//            }
//        }
//
//        /*关键数据放到‘中间’*/
//        sUtil.swap(targetArr,start,j);
//
//        if(start<i-1)
//        {
//            this.quickSort(targetArr,start,i-1);
//        }
//        if(j+1<end)
//        {
//            this.quickSort(targetArr,j+1,end);
//        }
//
//        return targetArr;
//    }


    /*//////////////方式三：减少交换次数，提高效率/////////////////////*/
//    private <T extends Comparable<? super T>> void quickSort3(T[]targetArr,int start,int end)
//    {
//        int i=start,j=end;
//        T key=targetArr[start];
//
//        while(i<j)
//        {
//            /*按j--方向遍历目标数组，直到比key小的值为止*/
//            while(j>i&&targetArr[j].compareTo(key)>=0)
//            {
//                j--;
//            }
//            if(i<j)
//            {
//                /*targetArr[i]已经保存在key中，可将后面的数填入*/
//                targetArr[i]=targetArr[j];
//                i++;
//            }
//            /*按i++方向遍历目标数组，直到比key大的值为止*/
//            while(i<j&&targetArr[i].compareTo(key)<=0)
//                /*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/
//            {
//                i++;
//            }
//            if(i<j)
//            {
//                /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
//                targetArr[j]=targetArr[i];
//                j--;
//            }
//        }
//        /*此时i==j*/
//        targetArr[i]=key;//应加判断
//
//        /*递归调用，把key前面的完成排序*/
//        this.quickSort(targetArr,start,i-1);
//
//
//        /*递归调用，把key后面的完成排序*/
//        this.quickSort(targetArr,j+1,end);
////两个递归应加判断
//    }
}
