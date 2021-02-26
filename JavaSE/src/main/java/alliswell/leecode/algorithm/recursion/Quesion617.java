package alliswell.leecode.algorithm.recursion;


import java.util.Stack;

/**
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion617 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode result = null;

        TreeNode root1 = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5),
                        null),
                new TreeNode(2));

        TreeNode root2 = new TreeNode(2,
                new TreeNode(1,
                        null,
                        new TreeNode(4)),
                new TreeNode(3,
                        null,
                        new TreeNode(7,
                                new TreeNode(2),
                                new TreeNode(3))));

        result = solution.mergeTrees(root1, root2);
        System.out.println(result);
        result.showTree();

    }


    static class Solution {

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            // 如果 r1和r2中，只要有一个是null，函数就直接返回
            if (root1 == null || root2 == null) {
                return root1 == null ? root2 : root1;
            }
            //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
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
