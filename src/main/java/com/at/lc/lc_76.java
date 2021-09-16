package com.at.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-09-16
 */
public class lc_76 {

    public String minWindow(String s, String t) {

        //https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
        //76. 最小覆盖子串

        int sLen = s.length();
        int tlen = t.length();

        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int needCnt = tlen;


        int I = 0, J = sLen + 1;
        int L = 0, R = 0;

        while (R < sLen) {

            char cR = s.charAt(R);
            if (need.getOrDefault(cR, 0) > 0) {
                needCnt -= 1;
            }
            need.put(cR, need.getOrDefault(cR, 0) - 1);


            if (needCnt == 0) {
                //L -> R 上包含所有 t 上的字符串
                // 从 左 向右收缩
                while (L <= R && need.get(s.charAt(L)) != 0) {
                    char cL = s.charAt(L);
                    need.put(cL, need.get(cL) + 1);
                    L++;
                }

                if (R - L < J - I) {
                    J = R;
                    I = L;
                }

                need.put(s.charAt(L), need.get(s.charAt(L)) + 1);
                needCnt += 1;
                L++;

            }

            R--;
        }

        return J - I > sLen ? "" : s.substring(I, J + 1);


    }

}
