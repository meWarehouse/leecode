package com.at.lc;

/**
 * @create 2021-09-09
 */
public class lc_714 {
    public int maxProfit(int[] prices, int fee) {

        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;

        /*
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[len - 1][0];
        */

        int p0 = 0, p1 = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            int np0 = Math.max(p0, p1 + prices[i]);
            int np1 = Math.max(p1, p0 - prices[i] - fee);

            p0 = np0;
            p1 = np1;

        }
        return p0;
    }
}
