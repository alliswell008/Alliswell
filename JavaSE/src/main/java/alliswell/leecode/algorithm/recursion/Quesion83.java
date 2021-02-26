package alliswell.leecode.algorithm.recursion;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Quesion83 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode result = null;

        ListNode head = ListNode.initListNode(new int[]{1, 1, 2, 3, 3, 6}, 0);

        head.showNode();
        result = solution.deleteDuplicates(head);
        result.showNode();
    }


    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
            if (head == null || head.next == null) {
                return head;
            }

            if (head.val == head.next.val) {
                head = deleteDuplicates(head.next);
            } else {
                head.next = deleteDuplicates(head.next);
            }
            return head;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * 构造单向链表
         */
        public static ListNode initListNode(int[] nums, int i) {
            ListNode head = new ListNode();
            head.val = nums[i];
            if (i + 1 < nums.length) {
                head.next = initListNode(nums, i + 1);
            }
            return head;
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



