package alliswell.leecode;


/**
 * <b>67. 二进制求和</b>
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion67 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "10";
        String b = "100";
        String s = solution.addBinary(a, b);
        System.out.println(s);
    }

    static class Solution {
        public String addBinary(String a, String b) {
            int i = a.length();
            int j = b.length();
            // 只可能有一个进位
            char[] result = new char[i > j ? i + 1 : j + 1];
            int k = result.length;

            // 进位
            int carry = 0;
            for (i -= 1, j -= 1, k -= 1; i >= 0 || j >= 0 || (k >= 0 && carry > 0); i--, j--, k--) {

                int r = carry;
                int ai = i >= 0 ? a.charAt(i) - '0' : 0;
                int bj = j >= 0 ? b.charAt(j) - '0' : 0;
                System.out.println("ai=" + ai + ",bj=" + bj);

                r += ai;
                r += bj;

                carry = r / 2;

                result[k] = (char) (r % 2 + '0');

                System.out.println(r);
            }

            // 没有进位时剔除掉
            if (result[0] == '\u0000') {
                return new String(result).substring(1, result.length);
            } else {
                return new String(result);
            }
        }
    }
}