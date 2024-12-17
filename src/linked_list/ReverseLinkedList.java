package linked_list;

import linked_list.node.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(
                0, new ListNode(1, new ListNode(2, new ListNode(3)))
        );
        System.out.println(head);
        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) {
            return head;
        }

        ListNode prev = null, next;

        while ( head.next != null ) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;

        return head;
    }
}
