package alliswell.leecode;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quesion2 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode result = null;

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(7))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7))));

        result = solution.addTwoNumbers(l1, l2);
        result.showNode();
    }


    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode curr = res;

            int carry = 0;
            while (carry > 0 || l1 != null || l2 != null) {
                int sum = carry;
                sum += (l1 != null) ? l1.val : 0;
                sum += (l2 != null) ? l2.val : 0;

                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            return res.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        /**
         * 打印链表
         */
        public void showNode() {
            if (this == null) {
                System.out.println("node is null");
                return;
            }

            if (this.next == null) {
                System.out.print(this.val + "\n");
            } else {
                System.out.print(this.val + "->");
            }

            if (this.next != null) {
                this.next.showNode();
            }
        }
    }


}