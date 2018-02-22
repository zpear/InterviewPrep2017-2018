public class MaxIslandTwoDArr {

  public int findMaxRegion(int[][] grid) {
    int rows = grid.length;
    int columns = grid[0].length;
    int max = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        int temp = searchRegion(r, c, grid);
        if (temp > max) {
          max = temp;
        }
      }
    }
    return max;
  }

  private int searchRegion(int row, int column, int[][] grid) {
    if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) {
      return 0;
    } else if (grid[row][column] != 1) {
      return 0;
    } else {
      int count = 1;
      grid[row][column] = 0;
      count += searchRegion(row + 1, column, grid);
      count += searchRegion(row, column + 1, grid);
      count += searchRegion(row + 1, column + 1, grid);
      count += searchRegion(row - 1, column - 1, grid);
      count += searchRegion(row - 1, column + 1, grid);
      count += searchRegion(row + 1, column - 1, grid);
      return count;
    }

  }
}