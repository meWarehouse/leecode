package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 23:29
 */
public class lc_189 {
     /*

    189 https://leetcode-cn.com/problems/rotate-array/

     */

    public void rotate_1(int[] nums, int k) {

        //将后面的k个元素先放入一个新的数组中，再将原来的数组中的 nums.length-k 个数组后移k位
        //最后将后面的k个元素添加到 nums 数组中

        int len = nums.length;

        if(nums == null || len < 2) return;

        if(k >= len) k = k % len;

        if(k == 0) return;

        int[] tail = new int[k];
        int j = 0;
        for (int i = len-k; i < len ; i++) {
            tail[j++] = nums[i];
        }

        for (int i = len - k - 1; i  >= 0 ; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tail[i];
        }


    }

    public void rotate_2(int[] nums, int k) {

        int len = nums.length;

        if(nums == null || len < 2) return;

        if(k >= len) k = k % len;

        if(k == 0) return;

        while (k-- > 0){

            int t = nums[len-1];
            for (int i = len-2; i >=0 ; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = t;

        }

    }

    public void rotate(int[] nums, int k) {

        //数组反转
        int len = nums.length;

        if(nums == null || len < 2 || k % len == 0) return;

        if(k >= len) k = k % len;


        revorse(nums,0,len-1);
        revorse(nums,0,k-1);
        revorse(nums,k,len-1);

    }

    public void revorse(int[] arr,int start,int end){
        while (start < end){
            arr[start] = arr[start] ^ arr[end];
            arr[end] = arr[start] ^ arr[end];
            arr[start] = arr[start] ^ arr[end];

            start++;
            end--;
        }

    }
}
