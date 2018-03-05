
public class Knapsack {
 
  public static int max(int a, int b) {
    return (a > b) ? a : b;
  }
  
  public static int findMaxVal(int[] weights, int[] vals, int maxWeight) {
    int[][] table = new int[vals.length+1][maxWeight+1];
    
    for (int row = 1; row < table.length; row++) {
      for (int col = 1; col < table[0].length; col++) {
        int top = table[row-1][col];
        if (weights[row-1] <= col) {
          int remainingWeight = col - weights[row-1];
          table[row][col] = max(vals[row-1]+table[row-1][remainingWeight], top);
        } else {
          table[row][col] = top;
        }
      }
    }
    return table[table.length-1][table[0].length-1];
  }
  
  public static void main(String[] args) {
    int[] weights = {10, 20, 30};
    int[] vals = {60, 100, 120};
    int maxWeight = 50;
    
    System.out.println(findMaxVal(weights, vals, maxWeight));
  }
}
