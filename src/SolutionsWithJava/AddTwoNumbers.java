package SolutionsWithJava;

/*
 * 2. Add Two Numbers
 * Runtime Beats: 55.94%
 * https://leetcode.com/problems/add-two-numbers/description/
 */

public class AddTwoNumbers {
    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode  addTwoNumbers(ListNode l1, ListNode l2) {
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
        ListNode l = AddTwoNumbers.addTwoNumbers(node, node2);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}

/*
// 以下方法对于超出integer范围的数字会报错
public class AddTwoNumbers {

    // Definition for singly-linked list.
    // ...

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0, num2 = 0;
        for (int i = 0; l1 != null; i++) {
            num1 += l1.val * Math.pow(10, i);
            l1 = l1.next;
        }
        for (int i = 0; l2 != null; i++) {
            num2 += l2.val * Math.pow(10, i);
            l2 = l2.next;
        }

        int num = num1 + num2;

        System.out.println(num);

        if(num<10){
            return new ListNode(num);
        }

        if(num<100){
            ListNode head = new ListNode(num%10);
            head.next = new ListNode(num/10);
            return head;
        }

        int i = 10;
        ListNode head = null;
        ListNode node = null;
        while (true) {

            if (i == 10) {
                head = new ListNode(num % i);
                node = head;
                i = i * 10;
                continue;
            }

            node.next = new ListNode(num % i / (i / 10));
            node = node.next;

            if (num / i < 10) {
                node.next = new ListNode(num / i);
                break;
            }
            i = i * 10;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(9);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l = AddTwoNumbers.addTwoNumbers(node, node2);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}*/
