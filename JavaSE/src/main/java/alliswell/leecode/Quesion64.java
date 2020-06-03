package alliswell.leecode;


/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 *
 * 限制：
 *
 *     1 <= n <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion64 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.sumNums(10000);
        System.out.println(res);
    }

    static class Solution {
        int res = 0;
        public int sumNums(int n) {
            boolean b = n > 1 && sumNums(n - 1) > 0;
            res += n;
            return res;
        }
    }
}