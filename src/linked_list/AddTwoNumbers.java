package linked_list;

import linked_list.node.ListNode;

import static linked_list.MergeTwoSortedLinkedLists.createAListNode;

public class AddTwoNumbers {
   public static void main(String[] args) {
      ListNode head = createAListNode(new int[]{1, 2, 4});
      ListNode head2 = createAListNode(new int[]{2, 8, 5, 9});

      System.out.println("S: " + addTwoNumbers(head, head2));
            System.out.println("''-");
      ListNode head3 = createAListNode(new int[]{9});
      ListNode head4 = createAListNode(new int[]{9});

      System.out.println("S: " + addTwoNumbers(head3, head4));
   }

   public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
      System.out.println("A: " + head1);
      System.out.println("B: " + head2);
      System.out.println("-----------------");

      int carry = (head1.val + head2.val) > 9 ? 1 : 0;
      ListNode sum = new ListNode((head1.val + head2.val)%10);
      ListNode start = sum;

      head1 = head1.next;
      head2 = head2.next;

      while ( head1 != null && head2 != null ) {
         sum.next = new ListNode((head1.val + head2.val + carry) % 10);
         carry = (head1.val + head2.val + carry) > 9 ? 1 : 0;

         sum = sum.next;
         head1 = head1.next;
         head2 = head2.next;
      }

      ListNode leftOver = head1 == null ? head2 : head1;
      while ( leftOver != null ) {
         sum.next = new ListNode((leftOver.val + carry) % 10);
         carry = (leftOver.val + carry) > 9 ? 1 : 0;

         sum = sum.next;
         leftOver = leftOver.next;
      }

      if ( carry!=0 ){
         sum.next = new ListNode(carry);
      }

      return start;

   }

//   public static ListNode add(ListNode total, ListNode a, ListNode b, int carry) {
////      if ( sum != null ) {
//
//      ListNode sum = total != null ? total.next : null;
////      }
//      if ( a == null & b == null ) {
//         sum = new ListNode(carry);
//         return sum;
//      } else if ( b == null ) {
//         sum = a.val + carry > 9 ?
//               add(sum, a, new ListNode(0), carry) :
//               new ListNode(a.val + carry);
////         a = a.next;
//      } else if ( a == null ) {
//         sum = b.val + carry > 9 ?
//               add(sum, new ListNode(0), b, carry) :
//               new ListNode(b.val + carry);
////         b = b.next;
//      } else {
//         sum = add(sum, a, b, carry);
//         a = a.next;
//         b = b.next;
//      }
//
//      return sum;
//   }

}
