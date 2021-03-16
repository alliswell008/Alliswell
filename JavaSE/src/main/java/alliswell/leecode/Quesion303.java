package alliswell.leecode;


/**
 * 303. 区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 *     NumArray(int[] nums) 使用数组 nums 初始化对象
 *     int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 *
 * 提示：
 *
 *     0 <= nums.length <= 104
 *     -105 <= nums[i] <= 105
 *     0 <= i <= j < nums.length
 *     最多调用 104 次 sumRange 方法
 */
public class Quesion303 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
        numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
        numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    }

    public static class NumArray {

        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            if (nums.length == 0) return;
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i-1] + nums[i];
            }
        }

        // 初始化一次性遍历求的前缀和后，做差即可得到范围和
        public int sumRange(int i, int j) {
            if (i==0) return sums[j];
            return sums[j] - sums[i-1];
        }
    }

    public static class NumArraySimple {

        int[] nums;

        public NumArraySimple(int[] nums) {
            this.nums = nums;
        }

        // 每次调用都会遍历数组再求和
        public int sumRange(int i, int j) {
            int result = 0;
            for (int k = i; k <= j; k++) {
                result += nums[k];
            }
            System.out.println(result);
            return result;
        }
    }


}