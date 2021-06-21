package com.at.lc;

/**
 * @author zero
 * @create 2021-06-20 16:17
 */
public class lc_62 {

    /*
        62 https://leetcode-cn.com/problems/unique-paths/

        通过规律可以发现
            每个位置上的点只可能来自上面或左边，所以到达该点的路径就为它上面的路径次数+左边的路径次数
            因此在最顶上的边的位置只可能来自它的左边
            最右边的位置只可能来自它的上面


     */

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

            }
        }

        return dp[n - 1][m - 1];

    }

    public static void main(String[] args) {
        System.out.println("678");
        new lc_62().uniquePaths_1(7, 3);
    }

    public int uniquePaths_1(int m, int n) {

        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[j] = res[j - 1] + res[j];
            }
        }

        return res[m - 1];

    }

}
