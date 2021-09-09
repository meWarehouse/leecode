package com.at.lc;

/**
 * @create 2021-09-09
 */
public class lc_123 {

    public int maxProfit(int[] prices) {


        if (prices == null || prices.length == 0) return 0;

        int len = prices.length;


    /*
        int[][][] dp = new int[len][3][2];

        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            //当天交易两次不持有股票 = max(前一天交易两次不持有股票,前一天交易两次持有一股今天卖出)
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            //当天交易两次持有一股 = max(前一天交易两次持有一股,前一天交易一次不持有股票今天买入)
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            //当前交易一次不持有 = max(前一天交易一次不持有,前一天交易一次持有一股今天卖出)
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //当天交易一次持有 = max(前一天交易一次持有,前一天不交易没有股票今天买入)
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);


        }

        return dp[len - 1][2][0];
        */


        int pT0 = 0, pT1 = -prices[0], pO0 = 0, pO1 = -prices[0];

        for (int i = 1; i < len; i++) {

            pT0 = Math.max(pT0, pT1 + prices[i]);
            pT1 = Math.max(pT1, pO0 - prices[i]);
            pO0 = Math.max(pO0, pO1 + prices[i]);
            pO1 = Math.max(pO1,  -prices[i]);

        }

        return pT0;


    }

}
