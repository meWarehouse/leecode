package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 19:56
 */
public class lc_11 {


    /*

        11 https://leetcode-cn.com/problems/container-with-most-water/

        一个容器能盛多少水取决于最短的边及两条边的距离（最短的木板*距离）


     */


    public int maxArea_1(int[] height) {


        int maxArea = 0;

        //固定最左边 移动右边
        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int area = Math.min(height[i], height[j]) * (j - i);

                maxArea = Math.max(maxArea, area);

            }
        }

        return maxArea;


    }

    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1;
        int maxArea = 0;

        //固定长边 移动短边
        while (l < r) {
            int area = 0;

            if (height[r] > height[l]) {
                area = height[l] * (r - l);
                l++;
            } else {
                area = height[r] * (r - l);
                r--;
            }
            maxArea = maxArea > area ? maxArea : area;

        }

        return maxArea;
    }
}
