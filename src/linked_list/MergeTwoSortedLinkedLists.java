package linked_list;

import linked_list.node.ListNode;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
////        Input: list1 = [1,2,4], list2 = [1,3,5]
        ListNode head = createAListNode(new int[]{1, 2, 4});
        ListNode head2 = createAListNode(new int[]{1, 3, 5});
////        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(5)));
        System.out.println(mergeTwoLists(head, head2));
        System.out.println("--------------------------");
////        Output: [1,1,2,3,4,5]


//        list1=[-9,-7,-3,-3,-1,2,3]
//        list2=[-7,-7,-6,-6,-5,-3,2,4]
        ListNode head3 = createAListNode(new int[]{-9, -7, -3, -3, -1, 2, 3});
        ListNode head4 = createAListNode(new int[]{-7, -7, -6, -6, -5, -3, 2, 4});
//        ListNode head4 = new ListNode(1, new ListNode(3, new ListNode(5)));
        System.out.println(mergeTwoLists(head3, head4));
        System.out.println("*\t*\t*\t*\t*");
        System.out.println("-9,-7,-7,-7,-6,-6,-5,-3,-3,-3,-1,2,2,3,4");
//        Output: [1,1,2,3,4,5]
    }

//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        // Handle edge cases
//        if (list1 == null) return list2;
//        if (list2 == null) return list1;
//
//        // Initialize start of the merged list
//        ListNode start = list1.val < list2.val ? list1 : list2;
//
//        // Pointers for traversing the lists
//        ListNode current; // To keep track of the merged list
//        if (start == list1) {
//            current = list1;
//            list1 = list1.next;
//        } else {
//            current = list2;
//            list2 = list2.next;
//        }
//
//        // Traverse both lists and merge
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                current.next = list1;  // Attach list1's node
//                list1 = list1.next;   // Move list1 pointer forward
//            } else {
//                current.next = list2; // Attach list2's node
//                list2 = list2.next;   // Move list2 pointer forward
//            }
//            current = current.next;   // Move current pointer forward
//        }
//
//        // Attach the remaining nodes of the non-empty list
//        current.next = (list1 != null) ? list1 : list2;
//
//        return start;
//    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if ( list1 == null && list2 == null ) return null;
        if ( list1 == null || list1.equals(new ListNode()) ) return list2;
        if ( list2 == null || list2.equals(new ListNode()) ) return list1;

        ListNode start = list1.val < list2.val ? list1 : list2;
        ListNode curr;

        if ( start == list1 ) {
            curr = list1;
            list1 = list1.next;
        } else {
            curr = list2;
            list2 = list2.next;
        }

        while ( list1 != null && list2 != null ) {
            if ( list1.val < list2.val ) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if ( list1 != null ) curr.next = list1;
        if ( list2 != null ) curr.next = list2;


        return start;
    }

    public static ListNode createAListNode(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode cur = head;
        for ( int i = 1; i < a.length; i++ ) {
            cur.next = new ListNode(a[i]);
            cur = cur.next;

        }
        return head;

    }
}
