package com.at.jz;

/**
 * @author zero
 * @create 2021-05-18 17:59
 */
public class JZ8 {


    public int jumpFloor(int target) {

        if (target <= 0) return 0;

        if (target == 1) return 1;

        int pr = 1;
        int pn = 2;

        for (int i = 2; i < target; i++) {

            pn = pr + pn;
            pr = pn - pr;

        }


        return pn;

    }

    public int jumpFloor1(int target) {

        if (target <= 0) return 0;

        if (target == 1) return 1;

        int[] dp = new int[target];

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[target - 1];

    }
}
