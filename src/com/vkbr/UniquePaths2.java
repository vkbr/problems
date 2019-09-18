// https://leetcode.com/problems/unique-paths-ii/
package com.vkbr;

import java.util.function.Function;

public class UniquePaths2 {

  static boolean tests() {
    UniquePaths2 sol = new UniquePaths2();

    int res = sol.uniquePathsWithObstacles(new int[][]{
      new int[]{0, 0, 0},
      new int[]{0, 1, 0},
      new int[]{0, 0, 0},
    });
    if (res != 2) {
      System.out.printf("Expected 2 got %s\n", res);
      return false;
    } else {
      System.out.printf("Case#1 %s\n", res);
    }

    res = sol.uniquePathsWithObstacles(new int[][]{
      new int[]{0, 0},
      new int[]{1, 1},
      new int[]{0, 0},
    });
    if (res != 0) {
      System.out.printf("Expected 0 got %s\n", res);
      return false;
    } else {
      System.out.printf("Case#2 %s\n", res);
    }

    res = sol.uniquePathsWithObstacles(new int[][]{
      new int[]{0, 0},
    });
    if (res != 1) {
      System.out.printf("Expected 1 got %s\n", res);
      return false;
    } else {
      System.out.printf("Case#3 %s\n", res);
    }

    res = sol.uniquePathsWithObstacles(new int[][]{
      new int[]{0, 0, 0, 1, 0},
    });
    if (res != 0) {
      System.out.printf("Expected 0 got %s\n", res);
      return false;
    } else {
      System.out.printf("Case#4 %s\n", res);
    }

//    [[0,0,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]
    res = sol.uniquePathsWithObstacles(new int[][]{
      new int[]{0,0,0,0},
      new int[]{0,1,0,0},
      new int[]{0,0,0,0},
      new int[]{0,0,1,0},
      new int[]{0,0,0,0},
    });
    if (res != 7) {
      System.out.printf("Expected 7 got %s\n", res);
      return false;
    } else {
      System.out.printf("Case#5 %s\n", res);
    }

    return true;
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int cols = obstacleGrid.length;
    int rows = obstacleGrid[0].length;
    int i, j;

    if (obstacleGrid[0][0] == 1 || obstacleGrid[cols - 1][rows - 1] == 1) return 0;

    boolean hasObstacle = false;

    for (i = 0; i < cols; i++)
      for (j = 0; j < rows; j++) {
        if (obstacleGrid[i][j] == 1) {
          hasObstacle = true;
          obstacleGrid[i][j] = -1;
        }
      }

    if ((rows == 1 || cols == 1)) {
      if (hasObstacle) return 0;
      else return 1;
    }

    obstacleGrid[0][0] = 1;
    int l, t;
    for (i = 0; i < cols; i++) {
      for (j = 0; j < rows; j++) {

        if (cols == 5 && rows == 4) {
          for (int a=0; a<cols; a++) {
            for (int b=0; b<rows; b++) {
              int x = obstacleGrid[a][b];
              System.out.printf("%s%s,", x < 0 ? "" : " ", x);
            }
            System.out.print("\n");
          }
          System.out.print("----------------------\n");
        }

        if (i==0 && j==0) continue;

        t = i == 0 ? 0 : obstacleGrid[i - 1][j];
        l = j == 0 ? 0 : obstacleGrid[i][j - 1];

        if (obstacleGrid[i][j] == -1) continue;

        if (t > 0 && l > 0) {
          obstacleGrid[i][j] = t + l;
        } else if (t > 0 || l > 0) {
          obstacleGrid[i][j] = Math.max(t, l);
        } else {
          obstacleGrid[i][j] = -1;
        }
      }
    }

    return Math.max(0, obstacleGrid[cols - 1][rows - 1]);
  }
}

// 1, 1, 1, 1,
// 1, 2, 3, 4,
// 1, 3, 6,10,
// 1, 4,10,20,
// 1, 5,15,35,
