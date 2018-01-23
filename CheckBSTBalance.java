import java.util.Stack;

/*
 * Implement a function to check if a binary tree is balanced. A 
 * balanced tree is defined to be a tree such that the heights of
 *  the two subtrees of any node never differ by more than one.
 */
public class CheckBSTBalance {
	
	public static class BSTNode {
		// Data not necessary for this problem, so it was omitted
		BSTNode left;
		BSTNode right;
	}
	
	/*
	 * returns true if balanced, false if not
	 */
	public boolean checkTreeBalance(BSTNode root) {
		Stack<BSTNode> current = new Stack<BSTNode>();
		Stack<BSTNode> next = new Stack<BSTNode>();
		int imbalance = -1;
		boolean subTreeEnd = false;
		
		current.push(root);
		while(!current.isEmpty()) {
			BSTNode c = current.pop();
			
			if (c.left != null)
				next.push(c.left);
			if (c.right != null)
				next.push(c.right);
			
			if (c.left == null || c.right == null) 
				subTreeEnd = true;
			
			if (current.isEmpty()) {
				if (subTreeEnd) 
					imbalance++;
				if (imbalance > 1)
					return false;
				
				Stack<BSTNode> temp = current;
				current = next;
				next = temp;
			}
			
		}
		return true;	
	}
	
	public static void main(String[] args) {
		CheckBSTBalance test = new CheckBSTBalance();
		BSTNode tree = new BSTNode();
		tree.left = new BSTNode();
		tree.right = new BSTNode();
		
		//true
		System.out.println(test.checkTreeBalance(tree));
		
		//true
		tree.right.right = new BSTNode();
		System.out.println(test.checkTreeBalance(tree));
		
		//false
		tree.right.right.right = new BSTNode();
		System.out.println(test.checkTreeBalance(tree));
		
		//false
		tree.right.right.right = new BSTNode();
		tree.right.right.right.left = new BSTNode();
		System.out.println(test.checkTreeBalance(tree));

	}
}
