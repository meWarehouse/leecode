package com.at.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zero
 * @create 2021-06-21 22:12
 */
public class lc_91 {



    /*
        91 https://leetcode-cn.com/problems/decode-ways/

        https://leetcode-cn.com/problems/decode-ways/solution/san-chong-jie-fa-xiang-xi-tu-jie-91-jie-6vh2k/

     */

  /*  Map<Integer,Integer> cache = new HashMap<>();

    public int numDecodings(String s) {

        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        return dfs(s,0);

    }

    public int dfs(String str,int index){

        if(index >= str.length()) return 1;
        if(cache.containsKey(index)) return cache.get(index);

        int one = 0, two = 0;

        if(str.charAt(index) != '0'){
            one = dfs(str,index+1);
        }

        if(index + 1 < str.length() && str.charAt(index) != '0' && isVaild(str,index)){
            two = dfs(str,index+2);
        }

        cache.put(index,one+two);

        return cache.get(index);

    }

    private boolean isVaild(String str, int index) {

        int a = str.charAt(index) - 48;
        int b = str.charAt(index + 1) - 48;

        int res = a * 10 + b;


        return res>=10 && res <= 26;
    }*/

    //========================================================================================

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int len = s.length();
//
//        int[] dp = new int[len+1];
//        dp[0] = 1;
//
//        for (int i = 1; i < len + 1; i++) {
//            if(s.charAt(i-1) != '0'){
//                dp[i] = dp[i-1] + dp[i];
//            }
//            if(i-2>=0 && s.charAt(i-2) != '0' && isValid(s,i)){
//                dp[i] = dp[i-2] + dp[i];
//            }
//        }
//
//        return dp[len];


        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0,b = 1,c = 0;

        for (int i = 1; i < len + 1; i++) {

            c = 0;
            if(s.charAt(i-1) != '0'){
                c+=b;
            }
            if(i-2>=0 && s.charAt(i-2) != '0' && isValid(s,i)){
                c+=a;
            }
            a = b;
            b = c;
        }

        return c;

    }


    public boolean isValid(String str, int index) {

        int a = str.charAt(index - 2) - '0';
        int b = str.charAt(index - 1) - '0';
        int res = a * 10 + b;

        return res >= 10 && res <= 26;

    }






}
