package com.at.leecode;

public class CN92 {


    /*
    https://blog.csdn.net/hrn1216/article/details/51534607


        题目描述
        给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则输出-1。
        示例1
        输入
        复制
        "1A2C3D4B56","B1D23CA45B6A"
        返回值
        复制
        "123456"
        说明
        "123456"和“12C4B6”都是最长公共子序列，任意输出一个。
        备注:
        1 \leq |str_1|, |str_2| \leq 5\,0001≤∣str
        1
        ​
        ∣,∣str
        2
        ​
        ∣≤5000

     */

    public static void main(String[] args) {


//        new CN92().LCS("1A2C3D4B56", "B1D23CA45B6A");
        System.out.println(new CN92().LCS("13456778", "357486782"));
    }


    public String LCS (String s1, String s2) {
        // write code here

        if (s1 == null || s2 == null) return "-1";

        int n1 = s1.length(), n2 = s2.length();

        if (n1 == 0 || n2 == 0) return "-1";

        int[][] dp = new int[n1 + 1][n2 + 1];

        //相等对角线+1   不相等上左对角线max
        for (int i = 1; i <= n1; i++) {
            char ch1 = s1.charAt(i-1);
            for (int j = 1; j <= n2; j++) {
                char ch2 = s2.charAt(j-1);
                if(ch2 != ch1){
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        while (n1 != 0 && n2 != 0){

            if(s1.charAt(n1-1) == s2.charAt(n2-1)){
                sb.append(s1.charAt(n1-1));
                n1--;
                n2--;
            }else{
                if(dp[n1-1][n2] > dp[n1][n2-1]){
                    n1--;
                }else {
                    n2--;
                }
            }

        }

        if(sb.length() == 0) return "-1";


        return sb.reverse().toString();
    }
}
