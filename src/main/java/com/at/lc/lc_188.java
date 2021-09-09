package com.at.lc;

/**
 * @create 2021-09-09
 */
public class lc_188 {
    public int maxProfit(int k, int[] prices) {

    /*
            一个有收益的交易至少需要两天（在前一天买入，在后一天卖出，前提是买入价格低于卖出价格）。
            如果股票价格数组的长度为 n，则有收益的交易的数量最多为 n / 2（整数除法）。
            因此 k 的临界值是 n / 2。如果给定的 k 不小于临界值，即 k >= n / 2，则可以将 k 扩展为正无穷，此时问题等价于情况二


         */

        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;

        //
        if (k >= len / 2) return maxProfit(prices);

        //
    /*
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j >0 ; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }

        return dp[len-1][k][0];
        */
        int[][] dp = new int[k+1][2];
        for (int i = 1; i <=k ; i++) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0 ; j--) {

                dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0] - prices[i]);

            }
        }

        return dp[k][0];


    }

    public int maxProfit(int[] prices) {

        //        int max = 0;
        //
        //        for (int i = 1; i < prices.length; i++) {
        //            if (prices[i] > prices[i - 1]) {
        //                max = max + prices[i] - prices[i - 1];
        //            }
        //        }
        //
        //        return max;

        int len = prices.length;

        //        int[][] dp = new int[len][2];
        //
        //        dp[0][0] = 0;
        //        dp[0][1] = -prices[0];
        //
        //        for (int i = 1; i < len; i++) {
        //            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        //        }
        //
        //        return dp[len - 1][0];

        int p0 = 0, p1 = -prices[0];

        for (int i = 1; i < len; i++) {
            int np0 = Math.max(p0, p1 + prices[i]);
            int np1 = Math.max(p1, p0 - prices[i]);
            p0 = np0;
            p1 = np1;
        }

        return p0;
    }

}
