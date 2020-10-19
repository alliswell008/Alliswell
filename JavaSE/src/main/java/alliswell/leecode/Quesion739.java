package alliswell.leecode;


import alliswell.demo.fordemo.ForEach;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <b>739. 每日温度</b>
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion739 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures3(temperatures);

        for (int r : result) {
            System.out.println(r);
        }
    }

    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];

            for (int i = 0; i < T.length; i++) {
                result[i] = 0;
                for (int j = i; j < T.length; j++) {
                    if (T[i] < T[j]) {
                        result[i] = j - i;
                        break;
                    }
                }
            }

            return result;
        }

        // TODO 单调栈
        public int[] dailyTemperatures2(int[] T) {
            int[] result = new int[T.length];
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < T.length; i++) {
                int temperature = T[i];
                while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                    int prevIndex = stack.pop();
                    result[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
            return result;
        }

        // TODO 单调栈
        public int[] dailyTemperatures3(int[] T) {
            int[] result = new int[T.length];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < T.length; i++) {
                int temperature = T[i];
                while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                    int prevIndex = stack.pop();
                    result[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
            return result;
        }
    }
}