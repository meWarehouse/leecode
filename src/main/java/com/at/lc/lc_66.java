package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 20:43
 */
public class lc_66 {
    /*
        66. https://leetcode-cn.com/problems/plus-one/

        遇 9 进位
        特殊的需要扩容

    */

    public int[] plusOne(int[] digits) {

        int index = digits.length - 1;
        while (index >= 0) {
            int val = digits[index] + 1;
            if (val >= 10) {
                digits[index] = val % 10;
                if (index == 0) {
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                }
                index--;
            } else {
                digits[index] = val;
                break;
            }
        }

        return digits;

    }
}
