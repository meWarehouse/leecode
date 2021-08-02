package com.at.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @create 2021-08-02
 */
public class lc_96 {

    /**
     * 96. 不同的二叉搜索树
     *  https://leetcode-cn.com/problems/unique-binary-search-trees/
     *
     */


    Map<Integer,Integer> cache = new HashMap<Integer,Integer>();

    public int numTrees(int n) {

        return dfs(n);

//        int[] dp = new int[n];
//
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                dp[i] = dp[j-1]  * dp[i-j];
//            }
//        }
//
//        return dp[n];

    }

    public int dfs(int n){
        if(n <= 1){
            return 1;
        }else if(cache.containsKey(n)){
            return cache.get(n);
        }else {
            int c = 0;
            for (int i = 0; i < n; i++) {
                c+= dfs(i) * dfs(n-i-1);
            }
            cache.put(n,c);
            return c;
        }
    }

}
