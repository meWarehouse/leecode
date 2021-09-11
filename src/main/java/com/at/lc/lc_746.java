package com.at.lc;

/**
 * @create 2021-09-11
 */
public class lc_746 {
    /*
    746. 使用最小花费爬楼梯
        https://leetcode-cn.com/problems/min-cost-climbing-stairs/submissions/
     */

    public int minCostClimbingStairs(int[] cost) {

        if(cost == null || cost.length == 0) return 0;

        int len = cost.length;

        int[] dp = new int[len + 1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= len ; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[len];

    }
}
