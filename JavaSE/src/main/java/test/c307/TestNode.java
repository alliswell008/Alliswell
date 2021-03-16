package test.c307;

/**
 * 2、对于一个链表（自己简单实现该数据结构），实现两两翻转，然后输出翻转之后的结果。比如输入的链表时：1->2->3->4->5，翻转之后，输出：2->1->4->3->5。
 */
public class TestNode {

    public static void main(String[] args) {
        Node root = Node.initNode(new int[]{1, 2, 3, 4, 5, 6}, 0);
        root.showNode();
        System.out.println("\n-----------");
        Node result = Node.fanZhuan(root);
        result.showNode();
    }

    public static class Node {
        Node next;
        int value;
        // 同一分组的value交换
        int group;

        /**
         * 构造单向链表
         */
        public static Node initNode(int[] nums, int i) {
            Node root = new Node();
            root.value = nums[i];
            root.group = i / 2 + 1;
            if (i + 1 < nums.length) {
                root.next = initNode(nums, i + 1);
            }
            return root;
        }

        /**
         * 翻转链表
         */
        public static Node fanZhuan(Node node) {
            if (node != null && node.next != null) {
                Node temp = node.next;
                node.next = fanZhuan(temp.next);
                temp.next = node;
                return temp;

//            if (node.next.group == node.group) {
//                int temp = node.value;
//                node.value = node.next.value;
//                node.next.value = temp;
//            }
//
//            if (node.next.next != null) {
//                fanZhuan(node.next.next);
//            }
            }
            return node;
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
                System.out.print(this.value);
            } else {
                System.out.print(this.value + "->");
            }

            if (this.next != null) {
                this.next.showNode();
            }
        }
    }
}
