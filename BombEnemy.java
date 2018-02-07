//  Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' 
// (the number zero), return the maximum enemies you can kill using one bomb.
// The bomb kills all the enemies in the same row and column from the 
// planted point until it hits the wall since the wall is too strong to be destroyed.
// Note that you can only put the bomb at an empty cell.

// Example:
// For the given grid

// 0 E 0 0
// E 0 W E
// 0 E 0 0

// return 3. (Placing a bomb at (1,1) kills 3 enemies)

public class BombEnemy {
  
  public int findSiteBF(char[][] arr) {
    int maxKills = 0;
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        int cKills = 0;
        
        if (arr[i][j] != '0') {
          continue;
        }
        
        for (int left = j-1; left >= 0; left--) {
          if(arr[i][left] == 'E') {
            cKills++;
          } else if (arr[i][left] == 'W') {
            break;
          }
        }
        for (int right = j+1; right < arr[0].length; right++) {
          if(arr[i][right] == 'E') {
            cKills++;
          } else if (arr[i][right] == 'W') {
            break;
          }
        }
        for (int up = i-1; up >= 0; up--) {
          if(arr[up][j] == 'E') {
            cKills++;
          } else if (arr[up][j] == 'W') {
            break;
          }
        }
        for (int down = i+1; down < arr.length; down++) {
          if(arr[down][j] == 'E') {
            cKills++;
          } else if (arr[down][j] == 'W') {
            break;
          }
        }
        
        if (cKills > maxKills) {
          maxKills = cKills;
        }
      }
    }
    return maxKills;
  }

  public static void main(String[] args) {
    char[][] map = {{'0','E','0','0'},
                    {'E','0','W','E'},
                    {'0','E','0','0'}};
    
    BombEnemy test = new BombEnemy();
    System.out.println(test.findSiteBF(map));
    
  }
}
