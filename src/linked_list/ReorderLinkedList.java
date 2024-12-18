package linked_list;

import linked_list.node.ListNode;

public class ReorderLinkedList {
   public static void reorderList(ListNode head) {

      if (head == null || head.next == null) {
         return;
      }

      // step #1: split the list into l1 & l2
      ListNode slow = head, fast = head;
      while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      ListNode l1 = head, l2 = slow.next;
      slow.next = null;

      System.out.println("List 1:\t" + l1);
      System.out.println("List 2:\t" + l2 + "\n");

      // step #2: reverse l2
      ListNode prev = null, next;
      while (true) {
         if (l2.next == null) {
            l2.next = prev;
            break;
         }
         next = l2.next;
         l2.next = prev;
         prev = l2;
         l2 = next;

      }
      System.out.println("Reversed List 2:\t" + l2 + "\n");

      // step #3: Merge l1 & reversed l2
      ListNode temp;
      boolean toggle = true;

      while (true) {
         // if (l1.next == null && l2.next == null) {
         //     break;
         // }

         if (toggle && l1.next != null) {
            temp = l1.next;
            l1.next = l2;
            l1 = temp;
         } else if (!toggle && l2.next != null) {
            temp = l2.next;
            l2.next = l1;
            l2 = temp;
         } else {
            if (toggle) {
               l1.next = l2;
            } else {
               l2.next = l1;
            }
            break;
         }

         toggle = !toggle;
      }

      System.out.println("List 1:\t" + l1);
      System.out.println("List 2:\t" + l2 + "\n");

      System.out.println("Final:\t" + head);

   }
}
