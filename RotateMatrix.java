
public class RotateMatrix {
  public static int[][] rotateMatrix(int[][] grid) {
    int n = grid.length;
    int numLoops = n/2;
    
    for (int loop = 0; loop < numLoops; loop++) {
      for (int x = 0; x < n - 2; x++) {
        
        int current = grid[loop][x];    // Step 1
        int swap = grid[x][(n-1)-loop];
        grid[x][(n-1)-loop] = current;
        current = swap;     
        swap = grid[(n-1)-loop][(n-1)-x];      // Step 2
        grid[(n-1)-loop][(n-1)-x] = current;
        current = swap;
        swap = grid[(n-1)-x][loop];
        grid[(n-1)-x][loop] = current;
        current = swap;
        grid[loop][x] = current; 
      }
    }
    return grid;  
  }
  
  public static void printGrid(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    int[][] test = {{1,2,3,4,0},{5,6,7,8,1},{9,1,2,3,9},{4,5,6,7,5}, {1,2,3,4,5}};
    printGrid(test);
    System.out.println('\n');
    printGrid(rotateMatrix(test));
    
  }
}
