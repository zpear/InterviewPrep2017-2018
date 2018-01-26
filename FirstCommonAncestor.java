/*
 * Find the first common ancestor of two nodes in a binary tree.
 * Do not store additional nodes in a data structure. The tree is
 * not necessarily a binary search tree.
 */
public class FirstCommonAncestor {
	
	// Note: Assuming all values in tree are unique
	public static class BTNode {
		int data;
		BTNode left;
		BTNode right;
		
		public BTNode(int x) {
			data = x;
		}
		public BTNode() {
			
		}
	}
	
	private BTNode tree;
	
	public FirstCommonAncestor() {
		tree = new BTNode();
	}
	
	public BTNode findFirstCommonAncestor(BTNode a, BTNode b) {
		return helpFindFCA(a, b, tree);
	}
	
	private BTNode helpFindFCA(BTNode a, BTNode b, BTNode current) {
		if (current == null) {
			return null;
		}
		
		if (current.data == a.data || current.data == b.data) {
			return current;
		} else {
			BTNode left = helpFindFCA(a, b, current.left);
			BTNode right = helpFindFCA(a, b, current.right);
			
			if (left == null) {
				return right;
			} else if (right == null) {
				return left;
			} else {
				return current;
			}
			
		}
	}
	
	public static void main(String[] args) {
		FirstCommonAncestor test = new FirstCommonAncestor();
		test.tree.data = 0;
		test.tree.left = new BTNode(5);
		test.tree.right = new BTNode(6);
		
		BTNode ancestor = test.findFirstCommonAncestor(test.tree.left, test.tree.right);
		System.out.println(ancestor.data);
		
		test.tree.right.right = new BTNode(7);
		test.tree.right.left = new BTNode(8);
		test.tree.right.left.right = new BTNode(9);
		
		ancestor = test.findFirstCommonAncestor(test.tree.right.right, test.tree.right.left.right);
		System.out.println(ancestor.data);
	}
}
