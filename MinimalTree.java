import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a sorted (increasing order) array with unique 
 * integer elements, write an algorithm to create a 
 * binary search tree with minimal height.
 */
public class MinimalTree {
	
	public Node makeTree(int[] arr) {
		if (arr.length == 1) {
			return new Node(arr[0]);
		} else if (arr.length < 1) {
			return null;
		} else {
			int[] left;
			int[] right;
			left = new int[arr.length/2];
			if (arr.length % 2 == 0) 
				right = new int[arr.length/2 - 1];
			 else 
				right = new int[arr.length/2];	
			System.arraycopy(arr, 0, left, 0, left.length);
			System.arraycopy(arr, left.length+1, right, 0, right.length);
			
			Node r = new Node(arr[arr.length/2]);
			r.left = makeTree(left);
			r.right = makeTree(right);
			return r;
		}
		
	}
	
	public void printTree(Node n) {
		Queue<Node> toPrint = new LinkedList<Node>();
		toPrint.add(n);
		int i = 0;
		int j = 1;
		while (!toPrint.isEmpty()) {
			Node x = toPrint.poll();
			if (x != null) {
				toPrint.add(x.left);
				toPrint.add(x.right);
				System.out.print(x.data + " ");
				i++;
				if (i == j) {
					System.out.println();
					j *= 2;
					i = 0;
				}
			}
		}		
	}
	
	
	public static class Node {
			Node left;
			Node right;
			int data;
			
			public Node() {}
			
			public Node(int d) {
				data = d;
			}	
	}
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		MinimalTree test = new MinimalTree();
		Node n = test.makeTree(arr);
		test.printTree(n);	
		
	}

}
