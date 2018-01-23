/*
 * Implement a function to check if a binary tree is
 * a binary search tree
 */
public class ValidateBST {
	BSTNode root;
	
	public static class BSTNode {
		BSTNode left;
		BSTNode right;
		int data;
		
		public BSTNode(int d) {
			data = d;
		}
	}
	

	public boolean validateBST(BSTNode root, boolean right) {
		if (root == null) 
			return true;
		
		if (right) {
			if (root.data < this.root.data)
				return false;
		} else {
			if (root.data >= this.root.data)
				return false;
		}
		
		if (root.left != null && root.left.data >= root.data)
				return false;
		if (root.right != null && root.right.data < root.data)
				return false;
		
		if (root == this.root) 
			return validateBST(root.left, false) && validateBST(root.right, true);
		else
			return validateBST(root.left, right) && validateBST(root.right, right);
	}
	
	public static void main(String[] args) {
		ValidateBST test = new ValidateBST();
		test.root = new BSTNode(10);
		
		//true
		System.out.println(test.validateBST(test.root, true));
		
		test.root.left = new BSTNode(5);
		test.root.right = new BSTNode(11);
		
		//true
		System.out.println(test.validateBST(test.root, true));
		
		test.root.left.left = new BSTNode(6);
		
		//false
		System.out.println(test.validateBST(test.root, true));
		
		test.root.left.left.data = 4;
		test.root.left.right = new BSTNode(11);
		
		//false
		System.out.println(test.validateBST(test.root, true));
		
		test.root.left.right.data = 9;
		
		//true
		System.out.println(test.validateBST(test.root, true));
		
	}
}
