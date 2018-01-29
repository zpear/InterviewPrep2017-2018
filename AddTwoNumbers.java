// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

public class AddTwoNumbers {

  // Definition for singly-linked list.
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  
  public ListNode addNumbers(ListNode a, ListNode b) {
    int carryOver = 0;
    int digitSum = 0;
    ListNode result = new ListNode(0);
    ListNode cDigit = result;
    
    while (a != null && b != null) {
      int temp = a.val + b.val + carryOver;
      carryOver = temp/10;
      digitSum = temp%10;
      cDigit.next = new ListNode(digitSum);
      cDigit = cDigit.next;
      a = a.next;
      b = b.next;
    }
    
    ListNode remaining;
    if (a == null) {
      remaining = b;
    } else {
      remaining = a;
    }
    
    while (remaining != null) {
      cDigit.next = new ListNode(remaining.val);
      cDigit = cDigit.next;
      remaining = remaining.next;
    }
    return result.next;
  }
  
  public static void main(String[] args) {
    AddTwoNumbers test = new AddTwoNumbers();
    
    ListNode a = new ListNode(2);
    a.next = new ListNode(4);
    a.next.next = new ListNode(3);
    a.next.next.next = new ListNode(1);
    
    ListNode b = new ListNode(5);
    b.next = new ListNode(6);
    b.next.next = new ListNode(4);
    
    ListNode c = test.addNumbers(a, b);
    
    while (c != null) {
      System.out.print(c.val + " ");
      c = c.next;
    }
  }
}
