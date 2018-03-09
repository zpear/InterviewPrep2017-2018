import java.util.HashMap;

/*
 * You are given a Double Link List with one pointer of each node pointing to the next node just 
 * like in a single link list. The second pointer which is arbitary pointer which can point to 
 * any node in the list and not just the previous node. 
 * 
 * The task is to complete the function copyList which take one argument the head of the linked 
 * list to be copied and should return the head of the copied linked list.
 */
public class CopyWeirdLL {
  public static class Node {
    int data;
    Node next;
    Node arb;

    public Node() {
    }

    public Node(int x) {
      data = x;
    }
  }

  public static Node copyList(Node head) {
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    Node cHead = backboneCopy(head, map);
    completeCopy(head, cHead, map);
    return cHead;
  }

  private static Node backboneCopy(Node head, HashMap<Node, Node> map) {
    Node copy = new Node();
    copy.data = head.data;
    map.put(head, copy);
    if (head.next != null) {
      copy.next = backboneCopy(head.next, map);
    }
    return copy;
  }

  private static void completeCopy(Node head, Node cHead, HashMap<Node, Node> map) {
    while (head != null) {
      cHead.arb = map.get(head.arb);
      head = head.next;
      cHead = cHead.next;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    head.arb = head.next.next;
    head.next.arb = head;
    head.next.next.arb = head.next.next.next.next;
    head.next.next.next.arb = head.next.next;
    head.next.next.next.next.arb = head.next;

    Node copy = copyList(head);
    while (copy.next != null) {
      System.out.println("at: " + copy.data + " next: " + copy.next.data + " arb: " + copy.arb.data);
      copy = copy.next;
    }
    System.out.println("at: " + copy.data + " next: " + copy.next + " arb: " + copy.arb.data);

  }

}
