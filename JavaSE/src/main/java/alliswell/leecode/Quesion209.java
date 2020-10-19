package alliswell.leecode;


import java.util.Arrays;

/**
 * <b>209. 长度最小的子数组</b>
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion209 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = 6;
        int[] nums = {2,3,1,2,4,3};

        int res = solution.minSubArrayLen(s, nums);
        System.out.println(res);

        nums = new int[]{0, 2, 5, 6, 8, 12, 15};
        res = Arrays.binarySearch(nums, 7);
        System.out.println(res);
    }

    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {

            int start = 0, end = 0, sum = 0, res = 0;
            while (end < nums.length) {
                sum += nums[end];
                while (sum >= s) {
                    if (res == 0 || res >= end - start + 1) {
                        res = end - start + 1;
                    }
                    sum -= nums[start];
                    start++;
                }
                end++;
            }

            return res;
        }
    }
}