package com.at.lc;

/**
 * @create 2021-08-22
 */
public class lc_213 {

      /*

            213. 打家劫舍 II
                https://leetcode-cn.com/problems/house-robber-ii/submissions/

     */


    public int rob(int[] nums) {

        if(nums == null || nums.length < 1) return 0;

        int len = nums.length;

        if(len == 1) return nums[0];

        return Math.max(process(nums,0,len-2),process(nums,1,len-1));
    }

    public int process(int[] nums,int s,int e){
        int p1 = 0,p2 = 0;

        for (int i = s; i <=e; i++) {

            int curr = Math.max(nums[i]+p2,p1);
            p2 = p1;
            p1 = curr;

        }

        return p1;
    }



}
