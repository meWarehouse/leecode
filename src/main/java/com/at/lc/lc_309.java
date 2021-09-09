package com.at.lc;

/**
 * @create 2021-09-09
 */
public class lc_309 {
    public int maxProfit(int[] prices) {

        /*
        但是在有「冷却时间」的情况下，
        如果在第 i - 1 天卖出了股票，就不能在第 i 天买入股票。因此，如果要在第 i 天买入股票，
        第二个状态转移方程中就不能使用 T[i - 1][k][0]，而应该使用 T[i - 2][k][0]

         */

        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;

        /*
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //当天持有 = max(前一天持有,今天买了)
            dp[i][1] = Math.max(dp[i - 1][1], (i > 1 ? dp[i - 2][0] : 0) - prices[i]);
        }

        return dp[len - 1][0];
        */

        int preP0 = 0, p0 = 0, p1 = -prices[0];

        for (int i = 1; i < len; i++) {

            int nextP0 = Math.max(p0, p1 + prices[i]);
            int nextP1 = Math.max(p1, preP0 - prices[i]);

            preP0 = p0;
            p0 = nextP0;
            p1 = nextP1;

        }

        return p0;
    }

}
