package alliswell.leecode.algorithm.recursion;


/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion101 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = false;

        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(1),
                                null),
                        new TreeNode(4)),
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(3,
                                null,
                                new TreeNode(1))));

        result = solution.isSymmetric(root);
        System.out.println(result);

        root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(2,
                        null,
                        new TreeNode(3)));

        result = solution.isSymmetric(root);
        System.out.println(result);
    }


    static class Solution {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return dfs(root.left, root.right);
        }

        public boolean dfs(TreeNode left, TreeNode right) {

            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            return dfs(left.left, right.right) && dfs(left.right, right.left);
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
    }



}