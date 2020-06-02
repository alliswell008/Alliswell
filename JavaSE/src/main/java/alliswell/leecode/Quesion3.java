package alliswell.leecode;


import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);


        s = "bbbbb";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);


        s = "pwwkew";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }


    static class Solution {
        HashMap<String, Integer> map = new HashMap<>();
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (map.containsKey(ch)) {
                    max = map.size() > max ? map.size() : max;
                    map.clear();
                } else {
                    map.put(ch + "", map.size() + 1);
                    max = map.size();
                }
            }
            return max;
        }
    }
}