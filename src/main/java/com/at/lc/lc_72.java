package com.at.lc;

/**
 * @author zero
 * @create 2021-06-20 21:12
 */
public class lc_72 {

    /*
        72 https://leetcode-cn.com/problems/edit-distance/

     */

    public int minDistance(String word1, String word2) {

        int a = word1.length();
        int b = word2.length();

        int[][] dp = new int[a+1][b+1];
        dp[0][0] = 0;

        //空串变成 world1 最少需要变化的次数
        for (int i = 1; i <= a; i++) {
            dp[i][0] = i;
        }

        //空串变成 world2 最少需要变化的次数
        for (int i = 1; i <= b; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {

                char w1 = word1.charAt(i-1);
                char w2 = word2.charAt(j-1);

                //如果当前两个字符相同
                if(w2 == w1){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
                }

            }
        }

        return dp[a][b];


    }
    public boolean oneEditAway_1(String first, String second) {

        int f = first.length();
        int s = second.length();

        if (Math.abs(f - s) > 1) return false;


        int[][] dp = new int[f + 1][s + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= f; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= s; j++) {
                char w1 = first.charAt(i - 1);
                char w2 = second.charAt(j - 1);
                if (w2 == w1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                }
            }
        }

        return dp[f][s] < 2 ? true : false;

    }

    public boolean oneEditAway(String first, String second) {
        int f = first.length();
        int s = second.length();

        if (Math.abs(f - s) > 1) return false;

        int i = 0, j = 0;
        boolean flag = false;
        while (i < f && j < s) {

            char w1 = first.charAt(i);
            char w2 = second.charAt(j);

            if (w2 == w1) {
                i++;
                j++;
            } else {

                if (!flag) {
                    if (f == s) {
                        i++;
                        j++;
                    } else if (f > s) {
                        i++;
                    } else {
                        j++;
                    }
                    flag = true;
                } else return false;
            }

        }

        return true;

    }

}
