import java.util.Iterator;
import java.util.LinkedList;

/*
 * Implement a function to check if a linked list
 * is a palindrome
 */
public class Palindrome <G> {
	
	public boolean checkPalindrome(LinkedList<G> list) {
		Iterator back = list.descendingIterator();
		Iterator front = list.iterator();
		
		for (int i = 0; i < list.size()/2; i++) {
			if (!back.next().equals(front.next()))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Palindrome<String> test = new Palindrome<String>();
		LinkedList<String> list1 = new LinkedList<String>();
		list1.add("m");
		list1.add("a");
		list1.add("m");
		
		System.out.println(test.checkPalindrome(list1));
		
		list1.add("x");
		System.out.println(test.checkPalindrome(list1));
		
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("x");
		list2.add("x");
		System.out.println(test.checkPalindrome(list2));
	}
}
