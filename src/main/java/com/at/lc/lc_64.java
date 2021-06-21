package com.at.lc;

/**
 * @author zero
 * @create 2021-06-20 18:45
 */
public class lc_64 {

    public int minPathSum_1(int[][] grid) {

        if (grid == null) return 0;

        int a = grid.length;
        int b = grid[0].length;

        int[][] dp = new int[a][b];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < a; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < b; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {

                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);

            }
        }

        return dp[a - 1][b - 1];


    }

    public int minPathSum(int[][] grid) {

        if (grid == null) return 0;

        int a = grid.length;
        int b = grid[0].length;

        int[] dp = new int[b];
        dp[0] = grid[0][0];
        for (int i = 1; i < b; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < a; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < b; j++) {

                dp[j] = grid[i][j] = Math.min(dp[j], dp[j - 1]);

            }
        }

        return dp[b-1];


    }
}
