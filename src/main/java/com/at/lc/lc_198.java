package com.at.lc;



/**
 * @create 2021-08-22
 */
public class lc_198 {
    /**
     * 198. 打家劫舍
     * <p>
     * https://leetcode-cn.com/problems/house-robber/
     */

    public static void main(String[] args) {

    }


    /**
     * 不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
     * dp[i] = max(nums[i]+dp[i-2],dp[i-1])
     */


//    public int rob(int[] nums) {
//
//        if (nums == null || nums.length < 1) return 0;
//
//        int len = nums.length;
//
//        if(len == 1) return nums[0];
//
//        int[] dp = new int[len];
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0],nums[1]);
//
//        for (int i = 2; i < len; i++) {
//            //max(偷当前房间,不偷当前房间)
//            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
//
//        }
//
//        return dp[len-1];
//
//    }


    public int rob(int[] nums) {

        if (nums == null || nums.length < 1) return 0;

        // 不偷       偷
        int p1 = 0, p2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(nums[i] + p2, p1);
            p2 = p1;
            p1 = curr;
        }

        return p1;

    }


}
