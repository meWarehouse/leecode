package com.at.lc;

/**
 * @author zero
 * @create 2021-06-22 22:14
 */
public class lc_152 {
    /*
        152  https://leetcode-cn.com/problems/maximum-product-subarray/
    */
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int m = nums.length;


        int max = Integer.MIN_VALUE;
        int imax = 1,imin  = 1;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] < 0){
                imax = imin ^ imax;
                imin = imin ^ imax;
                imax = imin ^ imax;
            }

            imax = Math.max(nums[i],nums[i]*imax);
            imin = Math.min(nums[i],nums[i]*imin);

            max = Math.max(max,imax);

        }



        return max;


    }

}
