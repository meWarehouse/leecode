package com.at.leecode_1;

public class CN145 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     *
     * @param V  int整型 背包的体积
     * @param n  int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack1(int V, int n, int[][] vw) {
        // write code here
        if (V == 0 || n == 0 || vw == null) return 0;

        int[][] dp = new int[n + 1][V + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                //放不下
                if (j < vw[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //可以放下 能放下的物品的重量+减去当前物品容量后剩余可以放下的最大重量
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }

            }
        }
        return dp[n][V];

    }

    public int knapsack(int V, int n, int[][] vw) {

        int[] w=new int[V+1];
        for(int i=0;i<n;i++){
            for(int j=V;j>=vw[i][0];j--){
                w[j]=Math.max(w[j],w[j-vw[i][0]]+vw[i][1]);
            }
        }
        return w[V];


    }


}
