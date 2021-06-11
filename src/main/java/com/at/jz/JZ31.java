package com.at.jz;

/**
 * @author zero
 * @create 2021-06-11 15:49
 */
public class JZ31 {

    public int NumberOf1Between1AndN_Solution(int n) {

        int cnt = 0;

        for (int i = 1; i <= n; i*=10) {
            int a = n/i;
            int b = n%i;
            cnt = cnt + (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }

        return cnt;

    }
}
