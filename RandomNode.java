import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Implement a binary tree class from scratch which, in addition to
 * insert, find, and delete, has a method getRandomNode() which returns
 * a random node from the tree. All nodes should be equally likely to 
 * be chosen.
 */
public class RandomNode {
    
	BTNode tree;
	int size = 0;
	ArrayList<BTNode> arr;
	
	public static class BTNode {
		int data;
		BTNode left;
		BTNode right;
		
		public BTNode(int x) {
			data = x;
		}	
	}
	
	public void insert(int x) {
		size++;
		Queue<BTNode> q = new LinkedList<BTNode>();
		
		if (tree == null) {
			tree = new BTNode(x);
			arr = new ArrayList<BTNode>();
			arr.add(tree);
		} else {
			q.add(tree);
			
			while (!q.isEmpty()) {
				BTNode current = q.poll();
				if (current.left == null) {
					current.left = new BTNode(x);
					arr.add(current.left);
				} else if (current.right == null) {
					current.right = new BTNode(x);
					arr.add(current.right);
				} else {
					q.add(current.left);
					q.add(current.right);
				}
			}
		}
		
	}
	
	// Uses an array representation of the tree
	// to quickly return a random BTNode
	public BTNode getRandomNodeBadSpace() {
		int toFind = (int)(Math.random() * size);
		return arr.get(toFind);
	}
	
	// Traverses tree each time to a random position
	public BTNode getRandomNodeBadTime() {
		int toFind = (int)(Math.random() * size + 1);
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(tree);
		BTNode current = new BTNode(0);
		for (int i = 1; i <= toFind; i++) {
			current = q.poll();
			
			if (current != null) {
				q.add(current.left);
				q.add(current.right);
			}
		}
		return current;
	}
	
	public static void main(String[] args) {
		RandomNode test = new RandomNode();
		test.insert(10);
		test.insert(5);
		test.insert(3);
		
		System.out.println(test.tree.data);
		System.out.println(test.tree.left.data + " " + test.tree.right.data);
		System.out.println(test.getRandomNodeBadTime().data);
		System.out.println(test.getRandomNodeBadSpace().data);
	}
}
