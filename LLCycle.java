/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
*/
public class LLCycle {
  
  private static class Node {
    Node next;
  }

  boolean hasCycle(Node head) {
    if (head == null) {
      return false;
    }
    Node fast = head.next;
    Node slow = head;

    while (fast.next != null && fast.next.next != null) {
      if (fast == slow) {
        return true;
      } else {
        fast = fast.next.next;
        slow = slow.next;
      }
    }
    return false;
  }
}