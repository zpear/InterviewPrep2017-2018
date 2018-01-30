import java.util.LinkedList;
import java.util.Queue;

// Given a binary tree, return the level order traversal of its nodes' values.
//(ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

public class BTLevelOrderTraversal {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }    
  }
  
  public void printLevelOrder(TreeNode tree) {
    // Want a breadth-first traversal, print as we go
    Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
    Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
    
    currentLevel.add(tree);
    while (!currentLevel.isEmpty()) {
      TreeNode current = currentLevel.poll();
      System.out.print(current.val + " ");
      
      if (current.left != null) {
        nextLevel.add(current.left);
      } 
      if (current.right != null) {
        nextLevel.add(current.right);
      }
      // Switching to the next level of the tree
      if (currentLevel.isEmpty()) {
        currentLevel.addAll(nextLevel);
        nextLevel.clear();
        System.out.println();
      }
    }
  }
  
  public static void main(String[] args) {
    BTLevelOrderTraversal test = new BTLevelOrderTraversal();
    TreeNode tree = new TreeNode(3);
    tree.left = new TreeNode(9);
    tree.right = new TreeNode(20);
    tree.right.left = new TreeNode(15);
    tree.right.right = new TreeNode(7);
    
    test.printLevelOrder(tree);
  }
}
