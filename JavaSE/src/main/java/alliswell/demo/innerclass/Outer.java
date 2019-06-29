package alliswell.demo.innerclass;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/6.
 */
public class Outer {

    class Inner {}

    public static void foo() {
        new Outer().new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
        new Outer().new Inner();

        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 9;
        int[] result = new Outer().new Solution().twoSum(nums, target);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[nums.length];
            int j = 0;

            Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                numsMap.put(i, nums[i]);
            }

            for (int i = 0; i < nums.length; i++) {
                if (numsMap.containsValue(target - nums[i])) {
                    result[j] = i;
                    j ++;
                }
            }

            return result;
        }
    }
}
