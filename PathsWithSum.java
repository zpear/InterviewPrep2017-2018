import java.util.Iterator;
import java.util.LinkedList;

/*
 * Binary tree of nodes w/ positive or negative integer value.
 * Count number of paths that sum to a given value. Path does not
 * need to start/end at the root or leaf, but must go downwards
 */
public class PathsWithSum {
	
	public static class BTNode {
		BTNode left;
		BTNode right;
		int data;
		
		public BTNode(int d) {
			data = d;
		}
	}
	
	public int numPathsWSum(BTNode root, int sum) {
		LinkedList<Integer> possPaths = new LinkedList<Integer>();
		return numPathsHelper(root, sum, possPaths);
	}
	
	private int numPathsHelper(BTNode root, int sum, LinkedList<Integer> possPaths) {
		int count = 0;
		if (root == null)
			return 0;
		if (root.data == sum)
			count++;
		Iterator<Integer> i = possPaths.iterator();
		
		for (int z = 0; z < possPaths.size(); z++) {
			Integer cPath = i.next();
			cPath += root.data;
			if (cPath.intValue() == sum)
				count++;
		}
		
		possPaths.add(root.data);
		
		return count + numPathsHelper(root.left, sum, possPaths) + numPathsHelper(root.right, sum, possPaths);		
	}
	
	public static void main(String[] args) {
		PathsWithSum test = new PathsWithSum();
		
		BTNode root = new BTNode(10);
		int sum = 10;
		
		root.right = new BTNode(0);
		root.right.right = new BTNode(10);
		
		// 4
		System.out.println(test.numPathsWSum(root, sum));
		
		root.left = new BTNode(-10);
		root.left.left = new BTNode(10);
		
		//6
		System.out.println(test.numPathsWSum(root, sum));
	}
}
