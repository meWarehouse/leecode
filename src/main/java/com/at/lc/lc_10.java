package com.at.lc;

/**
 * @create 2021-08-21
 */
public class lc_10 {

    public boolean isMatch(String s, String p) {

        /*
            10. 正则表达式匹配
            https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/

         */


        int sL = s.length();
        int pL = p.length();


        boolean[][] dp = new boolean[sL + 1][pL + 1];
        dp[0][0] = true;

        for (int i = 1; i < pL + 1; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }


        for (int i = 1; i < sL + 1; i++) {
            for (int j = 1; j < pL + 1; j++) {

                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }

            }
        }

        return dp[sL][pL];

    }


}
