package com.at;


import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.FpUtils;

import javax.jnlp.IntegrationService;
import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Spliterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zero
 * @create 2021-06-10 18:47
 */
public class Main1 {


    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        new Main1().numDecodings("226");


    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    public int numDecodings_1(String s) {

        return dfs(s, 0);

    }

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


    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();

        if (n == 1) return 1;

        int[] dp = new int[n];

        dp[0] = 1;

        if (s.charAt(1) != 0) dp[1] = 1;

        if (isValidNum(s, 1)) {
            dp[1] = dp[1] + dp[0];
        }

        for (int i = 2; i < n; i++) {

            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            if (isValidNum(s, i)) {
                dp[i] = dp[i] + dp[i - 2];
            }

        }


        return dp[n - 1];


    }


}
