package alliswell.leecode.algorithm.recursion;


import java.util.Arrays;
import java.util.Stack;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 *     - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 *         - 空数组，无子节点。
 *         - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 *             - 空数组，无子节点。
 *             - 只有一个元素，所以子节点是一个值为 1 的节点。
 *     - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 *         - 只有一个元素，所以子节点是一个值为 0 的节点。
 *         - 空数组，无子节点。
 * 示例 2：
 *
 *
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion654 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode result = null;

        int[] nums = {3,2,1,6,0,5};

        result = solution.constructMaximumBinaryTree(nums);
        System.out.println(result);
        result.showTree();

    }


    static class Solution {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums.length == 0 || nums.length == 1) {
                return nums.length == 0 ? null : new TreeNode(nums[0]);
            }

            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }

            int[] left = Arrays.copyOfRange(nums,0, maxIndex);
            int[] right = Arrays.copyOfRange(nums,maxIndex+1, nums.length);

            return new TreeNode(nums[maxIndex], constructMaximumBinaryTree(left), constructMaximumBinaryTree(right));
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        /**
         * 打印链表
         */
        public void showTree() {
            Stack<TreeNode> nodeStack = new Stack<>();
            TreeNode node = null;

            if (this != null && (this.left != null || this.right != null)) {
                nodeStack.push(this);
            }

            while (!nodeStack.isEmpty()) {
                node = nodeStack.pop();

                if (node == null) {
                    System.out.println("tree is null");
                    return;
                } else {
                    System.out.print(node.val + "->");
                    if (node.left == null) {
                        System.out.print("null->");
                    } else {
                        nodeStack.push(node.left);
                    }
                    if (node.right == null) {
                        System.out.print("null->");
                    } else {
                        nodeStack.push(node.right);
                    }
                }


            }
        }
    }
}
