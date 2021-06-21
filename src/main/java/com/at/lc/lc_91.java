package com.at.lc;

import java.util.HashMap;

/**
 * @author zero
 * @create 2021-06-21 22:12
 */
public class lc_91 {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int numDecodings_1(String s) {

        return dfs(s, 0);

    }

    /*
        91 https://leetcode-cn.com/problems/decode-ways/

     */

    public int dfs(String s, int index) {

        if (cache.containsKey(index)) return cache.get(index);

        if (index >= s.length()) return 1;

        int one = 0;
        int two = 0;

        if (s.charAt(index) != '0') {
            one = dfs(s, index + 1);
        }

        if (index + 1 < s.length() && s.charAt(index) != '0' && isValidNum(s, index)) {
            two = dfs(s, index + 2);
        }

        cache.put(index, one + two);
        return cache.get(index);

    }

    public boolean isValidNum(String s, int index) {

        int a = s.charAt(index) - 48;
        int b = s.charAt(index + 1) - 48;

        int res = a * 10 + b;

        return res >= 10 && res <= 26;

    }

    //=============================


    public int numDecodings_2(String s) {


        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int len = s.length();

        if (len == 1) return 1;

        int[] dp = new int[len];
        dp[0] = 1;

        //第二个数为 '0'
        if (s.charAt(1) != '0') {
            dp[1] = 1;
        }

        //第二个数可以与前一个数组合
        if (isValid(s, 1)) {
            dp[1] = dp[1] + dp[0];
        }

        for (int i = 2; i < len; i++) {

            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            if (isValid(s, i)) {
                dp[i] = dp[i] + dp[i - 2];
            }

        }

        return dp[len - 1];


    }

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int len = s.length();

        if (len == 1) return 1;

        int pre = 1;
        int curr = 0;

        if (s.charAt(1) != '0') {
            curr = 1;
        }

        if (isValid(s, 1)) {
            curr = curr + pre;
        }

        for (int i = 2; i < len; i++) {
            int temp = 0;
            if (s.charAt(i) != '0') {
                temp = curr;
            }
            if (isValid(s, i)) {
                temp += pre;
            }
            pre = curr;
            curr = temp;
        }

        return curr;


    }


    public boolean isValid(String str, int index) {


        int a = str.charAt(index - 1) - 48;
        int b = str.charAt(index) - 48;
        int t = a * 10 + b;
        return t >= 10 && t <= 26;
    }


}
