package com.at.leecode_1;


public class CN127 {

    /*
        给定两个字符串str1和str2,输出两个字符串的最长公共子串
        题目保证str1和str2的最长公共子串存在且唯一。
        示例1
        输入
        复制
        "1AB2345CD","12345EF"
        返回值
        复制
        "2345"
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
        System.out.println(new CN127().test("1AB22345CD", "12345EF"));
//        System.out.println(new CN127().test("d8Wt20lnSgAw0HgauN2Kspyr298H6wQWMO3tMNRpWmR25NNTD4VTnq16LX80khSMEG0W5V72cIDLvy0WB1Nfnz4z51qrGNKT3xImT141NY92514w8AF5q1sul7MVNFZnGengc03vO912lFftHDkWpMwWN0SY4pXO1QLji18ujkZV4vr449Wo495WOyIXiO4C9M5L7hQ4tX9ePvV5ohnX00e4mOW28xO968cdR266Ej5M","MV3Et2Q4x4YFlN304p5oLJzVT5zdfz8X83srj64mAx18Ai8kE82aF4so17uR3tD7Nch9CO775WHeVD166zgogKQAj4y04EjJ6Mc23Uvmt11NY92514w8AF5q1sul7MVNFZndJq1vh7qx45XOwP1k1M9jsbB3MLc9FFoy825lu0Cs9Bh3Xm84p5C36r6USQrF96W0b05RfF308001LpK89056qQ8517YFj4pM"));
//        System.out.println(new CN127().test("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80","U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));
    }

    //滑动窗口
    public String LCS1 (String str1, String str2) {

        if(str1 == null || str2 == null ) return "";

        StringBuilder builder = new StringBuilder();
        int s = 0,e = 1;

        while (e < str1.length() + 1 ){

            String substring = str1.substring(s, e);

            if(str2.contains(substring)){
                if(builder.length() < e - s){
                    builder.delete(0,builder.length());
                    builder.append(str1,s,e);
                }
            }else {
                s++;
            }

            e++;
        }

        if(builder.length() == 0) return "";

        return builder.toString();

    }


        //动态规划
    public String LCS (String str1, String str2) {

        if(str1 == null || str2 == null ) return "";

        int n1 = str1.length(),n2 = str2.length();

        if(n1 == 0 || n2 == 0) return "";

        int[][] dp = new int[n1+1][n2+1];

        int maxL = 0,x = 0;


        for (int i = 1; i <= n1; i++) {
            char ch1 = str1.charAt(i-1);
            for (int j = 1; j <= n2; j++) {
                char ch2 = str2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(maxL < dp[i][j]){
                        maxL = dp[i][j];
                        x = i;
                    }
                }
            }

        }


        return maxL == 0 ? "" : str1.substring(x - maxL,x);

    }


    public String test(String str1,String str2){

        //动态规划

        if(str1 == null || str2 == null) return "";

        int n1 = str1.length();
        int n2 = str2.length();

        if(n1 == 0 || n2 == 0) return "";

        int dp[][] = new int[n1+1][n2+1];

        int[] pre = new int[n2+1];
        int[] curr = new int[n2+1];


        int maxL = 0,x = 0;

//        for (int i = 1; i <=n1 ; i++) {
//            for (int j = 1; j <=n2 ; j++) {
//                if(str1.charAt(i-1) == str2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                    if(maxL < dp[i][j]){
//                        maxL = dp[i][j];
//                        x = i;
//                    }
//                }
//            }
//        }

        boolean flag = false;

        for (int i = 1; i <=n1 ; i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= n2 ; j++) {
                char ch2 = str2.charAt(j - 1);
                if(ch1 == ch2){
                   flag = true;
                    curr[j] = pre[j-1] + 1;
                    pre[j] = curr[j];
                    if(maxL < curr[j]){
                        maxL = curr[j];
                        x = i;
                    }
                }
            }

            if(flag){
                for (int k = 0; k < pre.length; k++) {
                    pre[k] = curr[k];
                    curr[k] = 0;
                }
            }

        }

        return maxL == 0 ? "" : str1.substring(x - maxL,x);



    }

    public String LCST (String str1, String str2) {
        //动态规划


        return "";


    }





}
