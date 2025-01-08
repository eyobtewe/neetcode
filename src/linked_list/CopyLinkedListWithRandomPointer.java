package linked_list;

import java.util.HashMap;

public class CopyLinkedListWithRandomPointer {

   public static void main(String[] args) {
      Node five = new Node(5);
      Node four = new Node(4);
      Node seven = new Node(7);
      Node three = new Node(3);

      three.setNext(seven);
      three.setRandom(null);

      seven.setNext(four);
      seven.setRandom(five);

      four.setNext(five);
      four.setRandom(three);

      five.setNext(null);
      five.setRandom(seven);

      System.out.println(":- " + three);

      copyRandomList(three);

   }

   public static Node copyRandomList(Node head) {

      HashMap<Node, Node> nodes = new HashMap<>();
      nodes.put(null, null);

      Node copy, current = head;

      while ( current != null ) {
         copy = new Node(current.val);
         nodes.put(current, copy);
         current = current.next;
      }

      current = head;

      while ( current != null ) {
         copy = nodes.get(current);
         copy.next = nodes.get(current.next);
         copy.random = nodes.get(current.random);
         current = current.next;
      }

      System.out.println("New List: " + nodes.get(head));
      return nodes.get(head);
   }

}

class Node {

   int val;
   Node next;
   Node random;

   public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
   }

   public void setNext(Node next) {
      this.next = next;
   }

   public String getRandom() {
      return random == null ? "(*)" : "(" + random.val + ")";
   }

   public void setRandom(Node random) {
      this.random = random;
   }

   @Override
   public String toString() {
      return val
            + getRandom()
            + ", " + next
            ;
   }
}