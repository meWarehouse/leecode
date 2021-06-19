package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 13:41
 */
public class lc_121 {

    /**
     * 121 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     *
     * 思路：
     *  股票只能买卖一次 T+1 操作
     *  最大利润 = 最高点 - 最低点
     *  并且 最高点只能在 最低点的后面
     *
     *
     */

    public int maxProfit_1(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {

                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }

            }
        }

        return maxProfit;

    }

    public int maxProfit(int[] prices) {

        //找到一个最小值及它后面的最大值
        int maxProfit = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if(min > prices[i]){
                min = prices[i];
            }

            if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }

        }

        return maxProfit;


    }



}
