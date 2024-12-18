package linked_list;

import linked_list.node.ListNode;

public class LinkedListCycleDetection {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            if (slow.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
