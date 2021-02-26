package alliswell.leecode.algorithm.recursion;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：result = [2,1,4,3]
 */
public class Quesion24 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode result = null;

        ListNode head = ListNode.initListNode(new int[]{1, 2, 3, 4, 5, 6}, 0);

        head.showNode();
        result = solution.swapPairs(head);
        result.showNode();
    }


    static class Solution {
        public ListNode swapPairs(ListNode head) {
            //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
            if (head == null || head.next == null) {
                return head;
            }

            //一共三个节点:head, next, swapPairs(next.next)
            //下面的任务便是交换这3个节点中的前两个节点
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;

            //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
            return newHead;
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



