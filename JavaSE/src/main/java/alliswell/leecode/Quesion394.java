package alliswell.leecode;


import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion394 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = null;

        String s = "3[a]2[bc]";
        result = solution.digui(s);
        System.out.println(result);

        s = "3[a2[c]]";
        result = solution.digui(s);
        System.out.println(result);

        s = "21[abc]30[cd]ef";
        result = solution.digui(s);
        System.out.println(result);
    }


    static class Solution {
        public String decodeString(String s) {
            String res = "";

            // 记录'['之前的数字
            Stack<Integer> countStack = new Stack<>();
            // 记录'['之前的字符串运算结果
            Stack<String> resStack = new Stack<>();

            int index = 0;
            int curNum = 0;

            while (index < s.length()) {
                char ch = s.charAt(index);
                index++;
                if (Character.isDigit(ch)) {
                    // 如果当前字符是数字的时候，计算出来括号中的数字
//                while(Character.isDigit(ch)){
                    curNum = 10 * curNum + (ch - '0');
//                }
                } else if (ch == '[') {
                    // 遇到 '[' 时，将之前的字符和数字都压栈，并将其引用设为初始值
                    resStack.push(res);
                    res = "";
                    countStack.push(curNum);
                    curNum = 0;
                } else if (ch == ']') {
                    // 遇到 ']' 就将两个栈里面的内容弹出，拼接到 res 中
                    StringBuilder temp = new StringBuilder(resStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        temp.append(res);
                    }
                    res = temp.toString();
                } else {
                    // index 位置处的字符为字母，直接添加到res中，index++
                    res += ch;
                }
            }
            return res;
        }


        public String decodeString2(String s) {
            String res = "";
            Stack<Integer> countStack = new Stack<>();
            Stack<String> resStack = new Stack<>();
            int index = 0;
            int curNum = 0;

            while (index < s.length()) {
                char ch = s.charAt(index);
                index++;
                if (Character.isDigit(ch)) {
                    curNum = 10 * curNum + (ch - '0');
                } else if (ch == '[') {
                    resStack.push(res);
                    res = "";
                    countStack.push(curNum);
                    curNum = 0;
                } else if (ch == ']') {
                    StringBuilder temp = new StringBuilder(resStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        temp.append(res);
                    }
                    res = temp.toString();
                } else {
                    res += ch;
                }
            }
            return res;
        }

        public String digui(String s) {
            String res = "";
            int index = 0;
            int repeatTimes = 0;
            while (index < s.length()) {
                char ch = s.charAt(index);
                index++;
                if (Character.isDigit(ch)) {
                    repeatTimes = 10 * repeatTimes + (ch - '0');
                } else if ('[' == ch) {
                    String temp = digui(s);
                    for (int i = 0; i < repeatTimes; i++) {
                        res += temp;
                    }
                    repeatTimes = 0;

                } else if (']' == ch) {
                    return res;
                } else {
                    res += ch;
                }

            }
            return res;
        }


        /////(O(n),O(n))
        //当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
        //当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
        //遍历完毕后返回 res。
        public String digui2(String s) {
            return dfs(s, 0)[1];
        }

        private String[] dfs(String s, int i) {//字符串s和索引i,返回字符数组，索引i和结果string
            StringBuilder res = new StringBuilder();
            int multi = 0;//重复次数
            while (i < s.length()) {//没有走到结尾时
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {//是数字
                    multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                    //计算数字的值
                } else if (s.charAt(i) == '[') {//递归开启
                    String[] tmp = dfs(s, i + 1);
                    i = Integer.parseInt(tmp[0]);//遇到']',i=结尾索引，即右括号位置
                    while (multi > 0) {
                        res.append(tmp[1]);
                        multi--;
                    }
                } else if (s.charAt(i) == ']') {
                    return new String[]{String.valueOf(i), res.toString()};
                } else {
                    res.append(s.charAt(i));
                }
                i++;
            }
            return new String[]{String.valueOf(i), res.toString()};
        }
    }

}