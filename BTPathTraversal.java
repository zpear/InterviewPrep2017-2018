// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]
public class BTPathTraversal {
  public static class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int x) {
      data = x;
    }
  }
  
  public static void printPaths(Node root, String prefix) {
    if (root.left != null) {
      printPaths(root.left, prefix + root.data + "->");
    }
    if (root.right != null) {
      printPaths(root.right, prefix + root.data + "->");
    }
    if (root.left == null && root.right == null) {
      System.out.println(prefix + root.data);
    }
  }
  
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.right = new Node(5);
    root.right = new Node(3);
    
    printPaths(root, "");
  }
}
