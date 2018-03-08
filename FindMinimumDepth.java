/*
 * Find shortest path in a binary tree
 */
public class FindMinimumDepth {
  public static class Node {
    Node left;
    Node right;
  }
  
  public static int getShortestPath(Node root) {
    if (root == null)
      return 0;
    int left = getShortestPath(root.left);
    int right = getShortestPath(root.right);
    
    int path = (left > right) ? right : left;
    path++;
    return path;
  }
  
  public static void main(String[] args) {
    Node root = new Node();
    root.right = new Node();
    root.left = new Node();
    root.left.left = new Node();
    root.left.right = new Node();
    System.out.println(getShortestPath(root));
  }
}
