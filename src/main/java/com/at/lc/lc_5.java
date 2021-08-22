package com.at.lc;

/**
 * @create 2021-08-19
 */
public class lc_5 {


//暴力匹配

//    public String longestPalindrome(String s) {
//
//        if(s == null || s.length() == 0) return "";
//
//
//        String res = s.substring(0,1);
//        if(s.length() == 1) return res;
//
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i+1; j < s.length(); j++) {
//
//                String substring = s.substring(i, j);
//                if(isPalindrome(substring) && substring.length() > res.length()){
//                    res = substring;
//                }
//
//            }
//        }
//
//        return res;
//
//
//    }
//
//    public boolean isPalindrome(String str){
//        for (int i = 0; i < str.length() / 2; i++) {
//            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
//        }
//
//        return true;
//    }

//===============================================


/*
    中心扩撒
    从当前遍历的元素开始 向两边遍历

 */
//    public String longestPalindrome(String s) {
//
//
//        if (s == null || s.length() == 0) return "";
//
//        int len = s.length();
//
//        if (len < 2) return s;
//
//        String res = s.substring(0, 1);
//
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//
//                if (j - i < res.length()) continue;
//
//                if (isPalindrome(s, i, j)) {
//                    res = s.substring(i, j + 1);
//                }
//
//            }
//        }
//
//
//        return res;
//
//
//    }
//
//    public boolean isPalindrome(String str, int s, int e) {
//
//        while (s < e) {
//            if (str.charAt(s++) != str.charAt(e--)) return false;
//        }
//        return true;
//    }


    //  优化
    public String longestPalindrome(String s) {


        if (s == null) return "";

        int len = s.length();
        if (len < 2) return s;
        boolean flag = false;

        String res = s.substring(0, 1);

        for (int i = 0; i < len; ) {


            //当剩下没有判断的字符串长度小于等于max的一半时就可以停止循环了
            if (len - i <= res.length() / 2) break;

            flag = false;

            int L = i, R = i;
            //过滤掉相同的 这里为什么不用判断r+1会不会越界？？？？（n-i <= max/2）
            while (R < len - 1 && s.charAt(i) == s.charAt(R + 1)) {
                R += 1;
                flag = true;
            }

            i = R + 1;
            //向两边寻找
            while (L > 0 && R < len - 1 && s.charAt(R + 1) == s.charAt(L - 1)) {
                R += 1;
                L -= 1;
                flag = true;
            }

            if (flag && R - L + 1 > res.length()) {
                res = s.substring(L, R + 1);
            }


        }

        return res;


    }


//===============================================

  /*  动态规划
    定义二维数组dp[length][length]，如果dp[left][right]为true，则表示字符串从left到right是回文子串，如果dp[left][right]为false，则表示字符串从left到right不是回文子串。



    如果dp[left+1][right-1]为true，我们判断s.charAt(left)和s.charAt(right)是否相等，如果相等，那么dp[left][right]肯定也是回文子串，否则dp[left][right]一定不是回文子串。



    所以我们可以找出递推公式


    dp[left][right]=s.charAt(left)==s.charAt(right)&&dp[left+1][right-1]


    有了递推公式，还要确定边界条件：

            如果s.charAt(left)！=s.charAt(right)，那么字符串从left到right是不可能构成子串的，直接跳过即可。



            如果s.charAt(left)==s.charAt(right)，字符串从left到right能不能构成回文子串还需要进一步判断

    如果left==right，也就是说只有一个字符，我们认为他是回文子串。即dp[left][right]=true（left==right）
    如果right-left<=2，类似于"aa"，或者"aba"，我们认为他是回文子串。即dp[left][right]=true（right-left<=2）
    如果right-left>2，我们只需要判断dp[left+1][right-1]是否是回文子串，才能确定dp[left][right]是否为true还是false。即dp[left][right]=dp[left+1][right-1]

*/

//    public String longestPalindrome(String s) {
//
//
//        if (s == null) return "";
//
//        int len = s.length();
//
//        if (len < 2) return s;
//        String res = s.substring(0,1);
//
//
//        boolean[][] dp = new boolean[len][len];
//
//        for (int i = 1; i < len ; i++) {
//            for (int j = 0; j < i; j++) {
//
//                // 判断 j~i 区间上是否为回文
//
//                if(s.charAt(i) != s.charAt(j)) continue;
//
//                if(i-j<=2){
//                    dp[j][i] = true;
//                }else {
//                    dp[j][i] = dp[j+1][i-1];
//                }
//
//                if(dp[j][i] && i-j+1 > res.length()){
//                    res = s.substring(j,i+1);
//                }
//
//            }
//        }
//
//        return res;
//
//    }


}
