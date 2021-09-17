package com.at.lc;

/**
 * @create 2021-09-17
 */
public class lc_32 {


    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 1) return 0;

        int len = s.length();
        int[] dp = new int[len];

        dp[0] = 0;
        int max = 0;

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }

                max = Math.max(dp[i], max);

            }
        }

        return max;
    }


}
