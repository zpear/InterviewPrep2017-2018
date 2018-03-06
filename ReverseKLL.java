/*
 * reverse every k elements of a singly linked list
 */
public class ReverseKLL {
  public static class Node {
    Node next;
    int data;

    public Node(int x) {
      data = x;
    }
  }

  public static Node reverseK(Node head, int k) {
    Node prev = null;
    Node curr = head;
    Node next = null;

    int i = k;
    while (i > 0 && curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      i--;
    }

    if (curr != null) {
      head.next = reverseK(curr, k);
      return prev;
    } else {
      return prev;
    }
  }

  public static void printList(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);

    printList(head);
    Node rev = reverseK(head, 2);
    printList(rev);
  }
}
