package com.at.lc;

/**
 * @author zero
 * @create 2021-06-20 17:28
 */
public class lc_63 {




    public int uniquePaths_1(int[][] obstacleGrid) {

        if (obstacleGrid == null) return 0;

        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;

        if (obstacleGrid[y - 1][x - 1] == 1) return 0;


        for (int i = 0; i < x; i++) {
            if (obstacleGrid[0][i] == 1) break;
            obstacleGrid[0][i] = -1;
        }

        for (int i = 0; i < y; i++) {
            if (obstacleGrid[i][0] == 1) break;
            obstacleGrid[i][0] = -1;
        }

        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {

                if (obstacleGrid[i][j] != 1) {
                    int a = obstacleGrid[i - 1][j];
                    int b = obstacleGrid[i][j - 1];
                    obstacleGrid[i][j] = (a == 1 ? 0 : a) + (b == 1 ? 0 : b);
                }
            }
        }

        return Math.abs(obstacleGrid[y - 1][x - 1]);


    }

    public int uniquePaths(int[][] obstacleGrid) {

        if (obstacleGrid == null) return 0;

        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;

        if (obstacleGrid[y - 1][x - 1] + obstacleGrid[0][0] >= 1) return 0;

        int[] dp = new int[x];
        dp[0] = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i] = 0;
                } else if (obstacleGrid[i][j] == 0 && j - 1 >= 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[x - 1];

    }

}
