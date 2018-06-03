package SolutionsWithJava;

/*
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 */

public class AddTwoNumbers2 {
    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode head = null;
        ListNode node = null;
        for (int i = 0; l1 != null || l2 != null; i++) {

            if (i == 0) {
                head = new ListNode((l1.val + l2.val) % 10);
                temp = (l1.val + l2.val) / 10;
                node = head;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if (l1 == null) {
                node.next = new ListNode((l2.val + temp) % 10);
                node = node.next;
                temp = (l2.val+temp) / 10;
                l2 = l2.next;
                continue;

            }
            if (l2 == null) {
                node.next = new ListNode((l1.val + temp) % 10);
                node = node.next;
                temp = (l1.val+temp) / 10;
                l1 = l1.next;
                continue;
            }

            node.next = new ListNode((l1.val + l2.val + temp) % 10);
            node = node.next;
            temp = (l1.val + l2.val + temp) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(temp != 0){
            node.next = new ListNode(temp);
        }

        return head;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);


        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        ListNode l = addTwoNumbers2.addTwoNumbers(node, node2);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
