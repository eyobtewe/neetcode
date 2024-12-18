package linked_list;

import linked_list.node.ListNode;

import static linked_list.MergeTwoSortedLinkedLists.createAListNode;

public class RemoveNthNodeFromEndOfLinkedList {

   public static void main(String[] args) {
      ListNode head = createAListNode(new int[]{1, 2, 3, 4});
      System.out.println("Returned:\t" + removeNthFromEnd(head, 2));

      System.out.println();

      ListNode head2 = createAListNode(new int[]{4});
      System.out.println("Returned:\t" + removeNthFromEnd(head2, 1));

      System.out.println();

      ListNode head3 = createAListNode(new int[]{1, 4});
      System.out.println("Returned:\t" + removeNthFromEnd(head3, 2));

   }

   public static ListNode removeNthFromEnd(ListNode head, int n) {
      System.out.println("Original List:" + head + " remove "+n+"th");
      if ( head == null || head.next == null || head.equals(new ListNode()) ) {
         System.out.println("Rejected");
         if ( head != null && n == 1 ) return head.next;
         return head;
      }

      ListNode slow = head, cursor = head;

      int slowCounter = 0, length = 1, realIndex = 0;

      while ( true ) {
         if ( cursor.next == null ) break;
         cursor = cursor.next;
         length++;
      }
      System.out.println("List length: " + length);

      if ( length >= n ) {
         realIndex = length - n;
         if ( realIndex==0 ){
            return slow.next;
         }

         while ( true ) {
            if ( slowCounter+1 < realIndex ) {
//               cursor = slow;
               slow = slow.next;
               slowCounter++;
            } else {
               ListNode temp = slow.next.next;
               slow.next = temp;
               break;
            }
         }

      } else {
         return null;
      }

      System.out.println("Result:\t" + head);

      return head;
   }

}
