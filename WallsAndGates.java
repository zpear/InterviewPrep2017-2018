// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
public class WallsAndGates {
  static int[][] grid;

  public static void calculateDistances() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          checkCells(i, j, 0);
        }
      }
    }

  }

  private static void checkCells(int i, int j, int val) {
    if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == -1) {
      return;
    }
    int cell = val;
    if (grid[i][j] >= val) {
      grid[i][j] = cell;
      checkCells(i + 1, j, cell + 1);
      checkCells(i - 1, j, cell + 1);
      checkCells(i, j + 1, cell + 1);
      checkCells(i, j - 1, cell + 1);
    }
  }

  public static void main(String[] args) {
    int[][] mat = { { -2, -1, 0, -2 }, { -2, -2, -2, -1 }, { -2, -1, -2, -1 }, { 0, -1, -2, -2 } };
    grid = mat;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == -2) {
          grid[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    calculateDistances();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }

  }
}
