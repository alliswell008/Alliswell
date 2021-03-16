package alliswell.leecode;


/**
 * 354. 俄罗斯套娃信封问题
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class Quesion354 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int a = solution.maxEnvelopes(new int[][]{
//                {5,4},{6,4},{6,7},{2,3},{1,2},{7,7},{8,8},
                {30, 50}, {12,2}, {3,4}, {12,15}
        });

        System.out.println(a);
    }

    static class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int count = 1;
            int[] min = envelopes[0];
            int[] max = envelopes[0];
            for (int i = 0; i < envelopes.length; i++) {
                if (envelopes[i][0] < min[0] && envelopes[i][1] < min[1]) {
                    min = envelopes[i];
                    count++;
                    printArray(min);
                    printArray(max);
                } else if (envelopes[i][0] > max[0] && envelopes[i][1] > max[1]) {
                    max = envelopes[i];
                    count++;
                    printArray(min);
                    printArray(max);
                }
            }
            return count;
        }

        public void printArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ",\t");
            }
            System.out.println();
        }
    }


}