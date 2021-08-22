//package com.at.leecode;
//
//import com.at.Main;
//
//public class CN17 {
//
//    public static void main(String[] args) {
//
//
//        System.out.println(new com.at.Main().getLongestPalindrome("abc1234321ab", 12));
//        System.out.println(new Main().getLongestPalindrome("baabccc", 7));
//
//    }
//
//    public int getLongestPalindrome(String A, int n) {
//
//        if (A == null || n == 0) return 0;
//
//        if (n < 2) return n;
//
//        int max = 0;
//
//        boolean[][] dp = new boolean[n][n];
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//
//                //截取j~i这段出来判断是否为回文
//
//                //如果 i处的字符 与 j处的字符 不相同 那么 j~i这段字符串肯定不是回文
//                if (A.charAt(i) != A.charAt(j)) continue;
//
//                //下面则是判断 i处的字符 与 j处的字符 相同的情况
//                //单个字符 及 aba 情况
//                if (i - j <= 2) {
//                    dp[j][i] = true;
//                } else {
//                    dp[j][i] = dp[j + 1][i - 1];
//                }
//
//                if (dp[j][i] && i - j + 1 > max) {
//                    max = i - j + 1;
//                }
//
//
//            }
//        }
//
//
//        return max;
//
//
//    }
//
//
//    public int getLongestPalindrome3(String A, int n) {
//        if (A == null || n == 0) return 0;
//
//        //以当前遍历的字符串为中心 向两边扩散
//
//        //边界值
//        if (n < 2) return n;
//
//        int max = 0;
//
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i; j < n; j++) {
//
//                if (j - i < max) continue;
//
//                if (isPalindrome(A, i, j)) {
//                    max = Math.max(max, j - i + 1);
//                }
//
//            }
//        }
//
//
//        return max;
//
//
//    }
//
//    public boolean isPalindrome(String str, int s, int e) {
//
//        while (s < e) {
//            if (str.charAt(s++) != str.charAt(e--)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public int getLongestPalindrome2(String A, int n) {
//
//        if (A == null || n == 0) return 0;
//
//        //以当前遍历的字符串为中心 向两边扩散
//
//        //边界值
//        if (n < 2) return n;
//        int max = 0;
//
//        for (int i = 0; i < n; ) {
//
//            //当剩下没有判断的字符串长度小于等于max的一半时就可以停止循环了
//            if (n - i <= max / 2) break;
//
//            int le = i, ri = i;
//            //过滤掉相同的 这里为什么不用判断r+1会不会越界？？？？（n-i <= max/2）
//            while (ri < n - 1 && A.charAt(i) == A.charAt(ri + 1)) {
//                ri += 1;
//            }
//
//            i = ri + 1;
//
//            //向两边寻找
//            while (ri < n - 1 && le > 0 && A.charAt(ri + 1) == A.charAt(le - 1)) {
//                ri += 1;
//                le -= 1;
//            }
//
//            max = Math.max(max, ri - le + 1);
//
//
//        }
//
//        return max;
//
//
//    }
//
//
//    public int getLongestPalindrome1(String A, int n) {
//        // write code here
//
//
//        if (A == null || n == 0) return 0;
//
//        int index = 0;
//        int max = 0;
//
//        while (index < n) {
//            int comIndex = A.indexOf(A.charAt(index), index + 1);
//            if (comIndex == -1) {
//                index++;
//            } else {
//
//                max = Math.max(test(index, comIndex, max, A), max);
//
//
//                index++;
//            }
//        }
//
//        return max;
//
//
//    }
//
//    public int test(int index, int comIndex, int max, String A) {
//        int i = index + 1;
//        int t = comIndex - 1;
//
//        while (i < t) {
//            if (A.charAt(i) == A.charAt(t)) {
//                i += 1;
//                if (i == t) break;
//                t -= 1;
//            } else {
//                comIndex = A.indexOf(A.charAt(index), comIndex + 1);
//                if (comIndex != -1) {
//                    test(index, comIndex, max, A);
//                } else {
//                    break;
//                }
//            }
//        }
//
//        if (i == t) {
//            return max = Math.max(max, comIndex - index + 1);
//        } else {
//            return 0;
//        }
//    }
//
//
//}
