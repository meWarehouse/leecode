package com.at.jz;

/**
 * @author zero
 * @create 2021-05-22 16:55
 */
public class JZ11 {
    public int NumberOf1(int n) {

        int count = 0;
        int flag = 1;

        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }

        return count;


    }


    public int NumberOf(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}
