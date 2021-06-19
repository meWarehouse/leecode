package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 16:10
 */
public class lc_122 {

        /*

        122 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

        股票买卖获取最大利益(可交易多次)

        股票每天的价格曲线就是一个折线图 想要获取最大利益
        只需要在一段单调递增的最低点买入并且在最高点卖出


     */

    public int maxProfit_1(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if(prices[i] - prices[i-1] > 0){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }

        return maxProfit;

    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 0; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[0]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[n-1][0];


    }

}
