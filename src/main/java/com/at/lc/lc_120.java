package com.at.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 * @create 2021-06-22 20:58
 */
public class lc_120 {
    /*
    120 https://leetcode-cn.com/problems/triangle/
     */

    public int minimumTotal_1(ArrayList<ArrayList<Integer>> triangle) {

        int m = triangle.size();

        int[][] dp = new int[m][m];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {

            List<Integer> tar = triangle.get(i);

            dp[i][0] = tar.get(0) + dp[i - 1][0];

            for (int j = 1; j < tar.size(); j++) {


                if (j == tar.size() - 1) {
                    dp[i][j] = tar.get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = tar.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }

            }
        }

        int min = dp[m - 1][0];
        for (int i = 1; i < dp[m - 1].length; i++) {
            min = Math.min(dp[m - 1][i], min);
        }


        return min;


    }


    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        int m = triangle.size();

        int[][] dp = new int[m+1][m+1];

        for (int i = m-1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1] + triangle.get(i).get(j));
            }
        }

        return dp[0][0];

    }
}
