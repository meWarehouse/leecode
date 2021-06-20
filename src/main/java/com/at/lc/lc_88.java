package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 21:57
 */
public class lc_88 {
    /*

        88 https://leetcode-cn.com/problems/merge-sorted-array/

        归并

        逆向归避免覆盖num1中的数据

     */

    public void merge_1(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0 && n == 0 || n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] sort = new int[n + m];

        int p1 = 0, p2 = 0, k = 0;

        while (p1 < m || p2 < n) {

            if (p1 == m) {
                sort[k] = nums2[p2++];
            } else if (p2 == n) {
                sort[k] = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                sort[k] = nums1[p1++];
            } else {
                sort[k] = nums2[p2++];
            }

            k++;

        }

        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0 && n == 0 || n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int p1 = m - 1, p2 = n - 1, k = nums1.length - 1;

        while (p1 >= 0  || p2 >= 0){

            if(p1 < 0){
                nums1[k] = nums2[p2--];
            }else if(p2 < 0){
                nums1[k] = nums1[p1--];
            }else if(nums1[p1] <= nums2[p2]){
                nums1[k] = nums2[p2--];
            }else {
                nums1[k] = nums1[p1--];
            }

            k--;

        }


    }
}
