package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 20:57
 */
public class lc_70 {

    /*
        70 https://leetcode-cn.com/problems/climbing-stairs/

     */
    public int climbStairs_1(int n) {

        if(n < 3) return n;

        int[] step = new int[n + 1];

        step[1] = 1;
        step[2] = 2;

        for (int i = 3; i <= n; i++) {

            step[i] = step[i - 1] + step[i - 2];

        }

        return step[n];


    }

    public int climbStairs(int n) {

        if(n < 3) return n;

        int prr = 1;
        int pr = 2;

        for (int i = 2; i < n; i++) {
            pr = prr + pr;
            prr = pr - prr;
        }

        return pr;


    }
}
