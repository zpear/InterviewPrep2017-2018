import java.util.LinkedList;
import java.util.Queue;

// Given an array where elements are sorted in ascending order, 
// convert it to a height balanced BST.
public class ConvertArrToBST {
  
  public static class BSTNode {
    BSTNode left;
    BSTNode right;
    int data;
    
    public BSTNode(int x) {
      data = x;
    }
  }
  
  public BSTNode convertToTree(int[] arr) {
    return helpConvert(arr, 0, arr.length-1);
  }
  
  private BSTNode helpConvert(int[] arr, int start, int end) {
    if (start == end) {
      return new BSTNode(arr[start]);
    } else if (start == end - 1) {
      BSTNode mid = new BSTNode(arr[start]);
      mid.right = new BSTNode(arr[end]);
      return mid;
    } else if (start > end) {
      return null;
    } else {
      int middle = (start+end)/2;
      BSTNode mid = new BSTNode(arr[middle]);
      mid.left = helpConvert(arr, start, middle-1);
      mid.right = helpConvert(arr, middle+1, end);
      return mid;
    }
  }
  
  public static void main(String[] args) {
    int[] testArr = {0,1,2,3,4,5,6,7,8,9};
    ConvertArrToBST test = new ConvertArrToBST();
    
    BSTNode tree = test.convertToTree(testArr);
    
    Queue<BSTNode> q = new LinkedList<BSTNode>();
    Queue<BSTNode> next = new LinkedList<BSTNode>();
    q.add(tree);
    while(!q.isEmpty()) {
      BSTNode cNode = q.poll();
      if (cNode.left != null) {
        next.add(cNode.left);
      }
      if (cNode.right != null) {
        next.add(cNode.right);
      }
      System.out.print(cNode.data + " ");
      
      if (q.isEmpty()) {
        System.out.println();
        q.addAll(next);
        next.clear();
      }
    }
  }
}
