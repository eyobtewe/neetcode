package linked_list;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(head);
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        if ( head == null || head.next == null ) {
            return head;
        }


        while ( head.next != null ) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        while ( !stack.isEmpty() ) {
            head.next = stack.pop();
        }

        return head;
    }
}

class ListNode {

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


    @Override
    public String toString() {
        return "{" + val +
                "," + next +
                '}';
    }
}
