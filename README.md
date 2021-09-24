---
typora-root-url: images
---



每天复习一遍 

思想 方法



| 动态规划 |                               |
| -------- | ----------------------------- |
|          | 121、122、123、188、309、714/ |
|          |                               |
|          |                               |











[TOC]

























# 动态规划



股票问题

https://leetcode-cn.com/circle/article/qiAgHn/



### 121 [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)  (dp)

```java
/**
     * 121 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     *
     * 思路：
     *  股票只能买卖一次 T+1 操作
     *  最大利润 = 最高点 - 最低点
     *  并且 最高点只能在 最低点的后面
     *
     *
     */
//1.
public int maxProfit_1(int[] prices) {

    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
        for (int j = i+1; j < prices.length; j++) {

            if(prices[j] - prices[i] > maxProfit){
                maxProfit = prices[j] - prices[i];
            }
        }
    }

    return maxProfit;
}
//2.
public int maxProfit(int[] prices) {

    //找到一个最小值及它后面的最大值
    int maxProfit = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
        if(min > prices[i]){
            min = prices[i];
        }

        if(prices[i] - min > maxProfit){
            maxProfit = prices[i] - min;
        }

    }

    return maxProfit;

}

//3.

public int maxProfit(int[] prices) {

    if (prices == null || prices.length == 0) return 0;
    int len = prices.length;

    /*
        int[][] dp = new int[len][2];

        dp[0][0] = 0; //第一天不持有股票
        dp[0][1] = -prices[0]; //第一天持有股票

        for (int i = 1; i < len; i++) {

            //当天不持有股票 = max(前一天不持有股票,前一天持有股票今天卖出了)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            //当天持有股票 = max(前一天持有股票,前一天不持有股票今天买入了)
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);

        }
        return dp[len-1][0];
        */


    //第 i 天的最大收益只和第 i - 1 天的最大收益相关
    int p0 = 0, p1 = -prices[0];
    for (int i = 1; i < len; i++) {

        p0 = Math.max(p0, p1 + prices[i]);
        p1 = Math.max(p1, -prices[i]);

    }
    return p0;

}

```



### 122 [买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii)  

```java
/*
        122 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

        股票买卖获取最大利益(可交易多次)

        股票每天的价格曲线就是一个折线图 想要获取最大利益
        只需要在一段单调递增的最低点买入并且在最高点卖出
     */
public int maxProfit_1(int[] prices) {

    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {

        if(prices[i] - prices[i-1] > 0){
            maxProfit = maxProfit + prices[i] - prices[i-1];
        }
    }
    return maxProfit;
}

public int maxProfit(int[] prices) {

    if (prices == null || prices.length == 0) return 0;

    int len = prices.length;

    /*
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[len][0];
        */

    int p0 = 0, p1 = -prices[0];

    for (int i = 1; i < len; i++) {
        int np0 = Math.max(p0, p1 + prices[i]);
        int np1 = Math.max(p1, p0 - prices[i]);
        p0 = np0;
        p1 = np1;
    }

    return p0;
}
```



### [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)

```java

public int maxProfit(int[] prices) {


    if (prices == null || prices.length == 0) return 0;

    int len = prices.length;


    /*
        int[][][] dp = new int[len][3][2];

        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            //当天交易两次不持有股票 = max(前一天交易两次不持有股票,前一天交易两次持有一股今天卖出)
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            //当天交易两次持有一股 = max(前一天交易两次持有一股,前一天交易一次不持有股票今天买入)
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            //当前交易一次不持有 = max(前一天交易一次不持有,前一天交易一次持有一股今天卖出)
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //当天交易一次持有 = max(前一天交易一次持有,前一天不交易没有股票今天买入)
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);


        }

        return dp[len - 1][2][0];
        */


    int pT0 = 0, pT1 = -prices[0], pO0 = 0, pO1 = -prices[0];

    for (int i = 1; i < len; i++) {

        pT0 = Math.max(pT0, pT1 + prices[i]);
        pT1 = Math.max(pT1, pO0 - prices[i]);
        pO0 = Math.max(pO0, pO1 + prices[i]);
        pO1 = Math.max(pO1,  -prices[i]);

    }

    return pT0;


}


```



### [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/) 

```java
public int maxProfit(int k, int[] prices) {

    /*
            一个有收益的交易至少需要两天（在前一天买入，在后一天卖出，前提是买入价格低于卖出价格）。
            如果股票价格数组的长度为 n，则有收益的交易的数量最多为 n / 2（整数除法）。
            因此 k 的临界值是 n / 2。如果给定的 k 不小于临界值，即 k >= n / 2，则可以将 k 扩展为正无穷，此时问题等价于情况二


         */

    if (prices == null || prices.length == 0) return 0;

    int len = prices.length;

    //
    if (k >= len / 2) return maxProfit(prices);

    //
    /*
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j >0 ; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }

        return dp[len-1][k][0];
        */
    int[][] dp = new int[k+1][2];
    for (int i = 1; i <=k ; i++) {
        dp[i][0] = 0;
        dp[i][1] = -prices[0];
    }

    for (int i = 1; i < len; i++) {
        for (int j = k; j > 0 ; j--) {

            dp[j][0] = Math.max(dp[j][0],dp[j][1] + prices[i]);
            dp[j][1] = Math.max(dp[j][1],dp[j-1][0] - prices[i]);

        }
    }

    return dp[k][0];


}

public int maxProfit(int[] prices) {

    //        int max = 0;
    //
    //        for (int i = 1; i < prices.length; i++) {
    //            if (prices[i] > prices[i - 1]) {
    //                max = max + prices[i] - prices[i - 1];
    //            }
    //        }
    //
    //        return max;

    int len = prices.length;

    //        int[][] dp = new int[len][2];
    //
    //        dp[0][0] = 0;
    //        dp[0][1] = -prices[0];
    //
    //        for (int i = 1; i < len; i++) {
    //            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    //            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    //        }
    //
    //        return dp[len - 1][0];

    int p0 = 0, p1 = -prices[0];

    for (int i = 1; i < len; i++) {
        int np0 = Math.max(p0, p1 + prices[i]);
        int np1 = Math.max(p1, p0 - prices[i]);
        p0 = np0;
        p1 = np1;
    }

    return p0;
}

```

### [309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

```java
public int maxProfit(int[] prices) {

    /*
        但是在有「冷却时间」的情况下，
        如果在第 i - 1 天卖出了股票，就不能在第 i 天买入股票。因此，如果要在第 i 天买入股票，
        第二个状态转移方程中就不能使用 T[i - 1][k][0]，而应该使用 T[i - 2][k][0]

         */

    if (prices == null || prices.length == 0) return 0;

    int len = prices.length;

    /*
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //当天持有 = max(前一天持有,今天买了)
            dp[i][1] = Math.max(dp[i - 1][1], (i > 1 ? dp[i - 2][0] : 0) - prices[i]);
        }

        return dp[len - 1][0];
        */

    int preP0 = 0, p0 = 0, p1 = -prices[0];

    for (int i = 1; i < len; i++) {

        int nextP0 = Math.max(p0, p1 + prices[i]);
        int nextP1 = Math.max(p1, preP0 - prices[i]);

        preP0 = p0;
        p0 = nextP0;
        p1 = nextP1;

    }

    return p0;
}

```



### [714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

```java
public int maxProfit(int[] prices, int fee) {

    if (prices == null || prices.length == 0) return 0;

    int len = prices.length;

    /*
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[len - 1][0];
        */

    int p0 = 0, p1 = -prices[0] - fee;

    for (int i = 1; i < len; i++) {
        int np0 = Math.max(p0, p1 + prices[i]);
        int np1 = Math.max(p1, p0 - prices[i] - fee);

        p0 = np0;
        p1 = np1;

    }
    return p0;
}



```





### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring)

```java

//暴力匹配

public String longestPalindrome(String s) {

    if(s == null || s.length() == 0) return "";


    String res = s.substring(0,1);
    if(s.length() == 1) return res;


    for (int i = 0; i < s.length(); i++) {
        for (int j = i+1; j < s.length(); j++) {

            String substring = s.substring(i, j);
            if(isPalindrome(substring) && substring.length() > res.length()){
                res = substring;
            }

        }
    }

    return res;


}

public boolean isPalindrome(String str){
    for (int i = 0; i < str.length() / 2; i++) {
        if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
    }

    return true;
}

//===============================================

中心扩撒
从当前遍历的元素开始 向两边遍历
public String longestPalindrome(String s) {


        if (s == null || s.length() == 0) return "";

        int len = s.length();

        if (len < 2) return s;

        String res = s.substring(0, 1);


        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {

                if (j - i < res.length()) continue;

                if (isPalindrome(s, i, j)) {
                    res = s.substring(i, j + 1);
                }

            }
        }


        return res;


    }

    public boolean isPalindrome(String str, int s, int e) {

        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }
    

优化
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

动态规划
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



  public String longestPalindrome(String s) {


        if (s == null) return "";

        int len = s.length();

        if (len < 2) return s;
        String res = s.substring(0,1);

        
        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i < len ; i++) {
            for (int j = 0; j < i; j++) {

                // 判断 j~i 区间上是否为回文

                if(s.charAt(i) != s.charAt(j)) continue;

                if(i-j<=2){
                    dp[j][i] = true;
                }else {
                    dp[j][i] = dp[j+1][i-1];
                }

                if(dp[j][i] && i-j+1 > res.length()){
                    res = s.substring(j,i+1);
                }

            }
        }

        return res;

    }








```



### [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence)

```java

    /*

            1143. 最长公共子序列

            https://leetcode-cn.com/problems/longest-common-subsequence/
            
            https://blog.csdn.net/hrn1216/article/details/51534607

     */

    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text1.length() == 0) return 0;

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        
        StringBuffer buffer = new StringBuffer(dp[m][n]);

        while (m != 0 && n != 0){

            if(text1.charAt(m-1) == text2.charAt(n-1)){
                buffer.append(text1.charAt(m-1));
                m--;
                n--;
            }else {
                if(dp[m][n-1] > dp[m-1][n]){
                    n--;
                }else {
                    m--;
                }
            }

        }


//        if(buffer.length() == 0) return "";
//        return buffer.reverse().toString();


        return dp[m][n];

    }

```

### [最长公共子串](https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=188&&tqId=38644&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking)

```java
//滑动窗口
public String LCS (String str1, String str2) {


    if(str1 == null || str2 == null ) return "";

    StringBuffer buffer = new StringBuffer();

    int s = 0,e = 1;

    while (e < str1.length() + 1){

        String substring = str1.substring(s, e);
        if(str2.contains(substring)){
            if(e-s > buffer.length()){
                buffer.delete(0,buffer.length());
                buffer.append(str1,s,e);
            }
        }else {
            s++;
        }
        e++;
    }

    return buffer.length() == 0? "" : buffer.toString();


}

//dp
public String LCS(String str1, String str2) {

    if (str1 == null || str2 == null) return "";

    int n1 = str1.length(), n2 = str2.length();

    if (n1 == 0 || n2 == 0) return "";

    int[][] dp = new int[n1 + 1][n2 + 1];

    int maxL = 0, x = 0;


    for (int i = 1; i <= n1; i++) {
        char ch1 = str1.charAt(i - 1);
        for (int j = 1; j <= n2; j++) {
            char ch2 = str2.charAt(j - 1);
            if (ch1 == ch2) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
                if (maxL < dp[i][j]) {
                    maxL = dp[i][j];
                    x = i;
                }
            }
        }

    }


    return maxL == 0 ? "" : str1.substring(x - maxL, x);

}



```





### [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching)

```java
public boolean isMatch(String s, String p) {

    //https://leetcode-cn.com/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
    int sL = s.length();
    int pL = p.length();


    boolean[][] dp = new boolean[sL + 1][pL + 1];
    dp[0][0] = true;

    for (int i = 1; i < pL + 1; i++) {
        if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
    }


    for (int i = 1; i < sL + 1; i++) {
        for (int j = 1; j < pL + 1; j++) {

            if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (p.charAt(j - 1) == '*') {
                if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 2];
                }
            }

        }
    }

    return dp[sL][pL];

}

```





### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

```java
    /*
        62 https://leetcode-cn.com/problems/unique-paths/

        通过规律可以发现 
            每个位置上的点只可能来自上面或左边，所以到达该点的路径就为它上面的路径次数+左边的路径次数 
            因此在最顶上的边的位置只可能来自它的左边 
            最右边的位置只可能来自它的上面
        

     */

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                dp[i][j] = dp[i][j-1] + dp[i-1][j];

            }
        }

        return dp[n-1][m-1];

    }

 public int uniquePaths_1(int m, int n) {

        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            res[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[j] = res[j - 1] + res[j];
            }
        }

        return res[m - 1];
        
    }

```

### [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

```java
public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    if(obstacleGrid == null) return 0;

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    if(obstacleGrid[0][0] + obstacleGrid[m-1][n-1] != 0) return 0;


    for(int i = 0;i < m;i++){
        if(obstacleGrid[i][0] == 1) break;
        obstacleGrid[i][0] = -1;
    }

    for(int i = 0;i < n;i++){
        if(obstacleGrid[0][i] == 1) break;
        obstacleGrid[0][i] = -1;
    }

    for(int i = 1 ;i < m;i++){
        for(int j = 1;j < n;j++){

            if(obstacleGrid[i][j] != 1){
                int x = obstacleGrid[i][j-1];
                int y = obstacleGrid[i-1][j];

                obstacleGrid[i][j] = (x == 1 ? 0 : x) + (y == 1 ? 0 : y);

            }

        }
    }
    return Math.abs(obstacleGrid[m-1][n-1]);
}

public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    if (obstacleGrid == null) return 0;

    int y = obstacleGrid.length;
    int x = obstacleGrid[0].length;

    if (obstacleGrid[y - 1][x - 1] + obstacleGrid[0][0] >= 1) return 0;

    int[] dp = new int[x];
    dp[0] = 1;
    for (int i = 0; i < y; i++) {
        for (int j = 0; j < x; j++) {
            if (obstacleGrid[i][j] == 1) {
                dp[i] = 0;
            } else if (obstacleGrid[i][j] == 0 && j - 1 >= 0) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
    }
    return dp[x - 1];

}

```



### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

```java
    public int minPathSum_1(int[][] grid) {

        if (grid == null) return 0;

        int a = grid.length;
        int b = grid[0].length;

        int[][] dp = new int[a][b];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < a; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < b; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {

                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);

            }
        }

        return dp[a - 1][b - 1];


    }

    public int minPathSum(int[][] grid) {

        if (grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;

         int[] dp = new int[n];

        dp[0] = grid[0][0];
        for(int i = 1;i < n;i++){
            dp[i] = dp[i-1] + grid[0][i];
        }

        for(int i = 1;i < m;i++){
            dp[0] = grid[i][0] + dp[0];
            for(int j = 1;j < n;j++){
                dp[j] = grid[i][j] + Math.min(dp[j],dp[j-1]);
            }
        }

        return dp[n-1];


    }
```





### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)

```java
    /*
        72 https://leetcode-cn.com/problems/edit-distance/

     */

    public int minDistance(String word1, String word2) {

        int a = word1.length();
        int b = word2.length();

        int[][] dp = new int[a+1][b+1];
        dp[0][0] = 0;

        //空串变成 world1 最少需要变化的次数
        for (int i = 1; i <= a; i++) {
            dp[i][0] = i;
        }

        //空串变成 world2 最少需要变化的次数
        for (int i = 1; i <= b; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {

                char w1 = word1.charAt(i-1);
                char w2 = word2.charAt(j-1);

                //如果当前两个字符相同 
                if(w2 == w1){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
                }

            }
        }

        return dp[a][b];


    }
```



### [面试题 01.05. 一次编辑](https://leetcode-cn.com/problems/one-away-lcci/)

```java
  public boolean oneEditAway_1(String first, String second) {

        int f = first.length();
        int s = second.length();

        if (Math.abs(f - s) > 1) return false;


        int[][] dp = new int[f + 1][s + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= f; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= s; j++) {
                char w1 = first.charAt(i - 1);
                char w2 = second.charAt(j - 1);
                if (w2 == w1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                }
            }
        }

        return dp[f][s] < 2 ? true : false;

    }

    public boolean oneEditAway(String first, String second) {
        int f = first.length();
        int s = second.length();

        if (Math.abs(f - s) > 1) return false;

        int i = 0, j = 0;
        boolean flag = false;
        while (i < f && j < s) {

            char w1 = first.charAt(i);
            char w2 = second.charAt(j);

            if (w2 == w1) {
                i++;
                j++;
            } else {

                if (!flag) {
                    if (f == s) {
                        i++;
                        j++;
                    } else if (f > s) {
                        i++;
                    } else {
                        j++;
                    }
                    flag = true;
                } else return false;
            }

        }

        return true;

    }

```





### [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses)

```java

//https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
public int longestValidParentheses(String s) {

    if (s == null || s.length() == 0) return 0;

    int len = s.length();
    int max = 0;
    int[] dp = new int[len];

    for (int i = 1; i < len; i++) {

        if (s.charAt(i) == ')') {

            // ....()
            if (s.charAt(i - 1) == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {

                // (....)) i-dp[i-1]<=0
                // ...(...)) i-dp[i-1]>0
                // ...((...)) i-dp[i-1]>0 s.charAt(i-dp[i-1]-1)=='('

                dp[i] = dp[i-1] + ((i-dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;

            }

            max = Math.max(max,dp[i]);

        }


    }

    return max;


}

//=====================================

public int longestValidParentheses(String s) {

    if (s == null || s.length() == 0) return 0;

    int max = 0;

    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    for (int i = 0; i < s.length(); i++) {

        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {

            stack.pop();
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                max = Math.max(max, i - stack.peek());
            }
        }
    }


    return max;

}


```

### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber)

```
 /**
     * 198. 打家劫舍
     * <p>
     * https://leetcode-cn.com/problems/house-robber/
     */

    public static void main(String[] args) {

    }


    /**
     * 不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
     * dp[i] = max(nums[i]+dp[i-2],dp[i-1])
     */


//    public int rob(int[] nums) {
//
//        if (nums == null || nums.length < 1) return 0;
//
//        int len = nums.length;
//
//        if(len == 1) return nums[0];
//
//        int[] dp = new int[len];
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0],nums[1]);
//
//        for (int i = 2; i < len; i++) {
//            //max(偷当前房间,不偷当前房间)
//            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
//
//        }
//
//        return dp[len-1];
//
//    }


    public int rob(int[] nums) {

        if (nums == null || nums.length < 1) return 0;

        // 不偷       偷
        int p1 = 0, p2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(nums[i] + p2, p1);
            p2 = p1;
            p1 = curr;
        }

        return p1;

    }
```

### [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii)

```java
/*

            213. 打家劫舍 II
                https://leetcode-cn.com/problems/house-robber-ii/submissions/

     */



public int rob(int[] nums) {

    if (nums == null || nums.length == 0) return 0;

    int len = nums.length;

    if(len == 1) return nums[0];


    return Math.max(process(nums,0,len-1),process(nums,1,len));

}


public int process(int[] arr,int s,int e){

    int p0 = 0,p1 = 0;

    for (int i = s; i < e; i++) {

        int curr = Math.max(p1,p0 + arr[i]);

        p0 = p1;
        p1 = curr;

    }

    return p1;
}

```





### [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)

```java
/*
        91 https://leetcode-cn.com/problems/decode-ways/
        https://leetcode-cn.com/problems/decode-ways/solution/san-chong-jie-fa-xiang-xi-tu-jie-91-jie-6vh2k/

     */



Map<Integer,Integer> cache = new HashMap<>();

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
}
=========================================================================
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

```



### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

```java
/*
    120 https://leetcode-cn.com/problems/triangle/
     */

public int minimumTotal(List<List<Integer>> triangle) {


    if (triangle == null || triangle.size() == 0) return 0;

    int m = triangle.size();
    int n = triangle.get(m - 1).size();

    //        int[][] dp = new int[m][n];
    //        dp[0][0] = triangle.get(0).get(0);
    //
    //
    //        for (int i = 1; i < m; i++) {
    //            List<Integer> tar = triangle.get(i);
    //            int size = tar.size();
    //            dp[i][0] = tar.get(0) + dp[i - 1][0];
    //            for (int j = 1; j < size; j++) {
    //
    //                if (j == size - 1) {
    //                    dp[i][j] = tar.get(j) + dp[i - 1][j - 1];
    //                } else {
    //                    dp[i][j] = tar.get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
    //                }
    //
    //            }
    //        }
    //
    //        Arrays.sort(dp[m - 1]);
    //
    //        return dp[m - 1][0];

    int[] dp = new int[n];
    dp[0] = triangle.get(0).get(0);

    for (int i = 1; i < m; i++) {

        List<Integer> tar = triangle.get(i);
        int size = tar.size();

        //从后往前避免覆盖前面的元素
        //            dp[0] = dp[0] + tar.get(0);

        for (int j = size - 1; j > 0; j--) {

            if (j == size - 1) {
                dp[j] = dp[j - 1] + tar.get(j);
            } else {
                dp[j] = tar.get(j) + Math.min(dp[j], dp[j - 1]);
            }
        }

        dp[0] = dp[0] + tar.get(0);
    }

    Arrays.sort(dp);

    return dp[0];

}

```

[96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees)



# 滑动窗口&双指针&中心扩散



### [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) （window）

![Snipaste_2021-09-16_14-26-52](/Snipaste_2021-09-16_14-26-52.jpg)



```java
public String minWindow(String s, String t) {

    int sLen = s.length();
    int tLen = t.length();

    Map<Character, Integer> need = new HashMap<>();
    int needCnt = tLen;

    for (int i = 0; i < tLen; i++) {
        char c = t.charAt(i);
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int I = 0, J = sLen + 1;


    int L = 0, R = 0;

    while (R < sLen) {
        char cR = s.charAt(R);
        if (need.getOrDefault(cR, 0) > 0) {
            needCnt--;
        }
        need.put(cR, need.getOrDefault(cR, 0) - 1);

        if (needCnt == 0) {

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
            L += 1;
        }
        R++;

    }

    return J - I > sLen ? "" : s.substring(I, J + 1);


}



```





### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)(double index)

```java
    /*
        11 https://leetcode-cn.com/problems/container-with-most-water/

        一个容器能盛多少水取决于最短的边及两条边的距离（最短的木板*距离）
     */


    public int maxArea_1(int[] height) {
        int maxArea = 0;
        //固定最左边 移动右边
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {

                int area = Math.min(height[i], height[j]) * (j - i);

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1;
        int maxArea = 0;

        //固定长边 移动短边
        while (l < r) {
            int area = 0;
            if (height[r] > height[l]) {
                area = height[l] * (r - l);
                l++;
            } else {
                area = height[r] * (r - l);
                r--;
            }
            maxArea = maxArea > area ? maxArea : area;
        }
        return maxArea;
    }

```

### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)（快慢指针）

### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring)

```
动态规划
```





# bfs&dfs

### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses)（dfs）

```java
 /*
        https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/

        当前左右括号都有大于 00 个可以使用的时候，才产生分支；
        产生左分支的时候，只看当前是否还有左括号可以使用；
        产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
        在左边和右边剩余的括号数都等于 00 的时候结算。



     */

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        if (n < 1) return res;

        dfs("",n,n);

        return res;

    }

    public void dfs(String currStr, int left, int right) {

        if (left == 0 && right == 0) {
            res.add(currStr);
            return;
        }

        // 左 （ 剩余的数量 一定是严格意义上大于 ） 剩余数量
        if (left > right) return;

        if (left > 0) dfs(currStr + "(", left - 1, right);

        if (right > 0) dfs(currStr + ")", left, right - 1);


    }


```



### [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)

~~~~
动态规划
~~~~





### 《岛屿问题（dfs）》

### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands)

```java
题解
https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/


public int numIslands(char[][] grid) {

        if (grid == null) return 0;

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    process(grid, i, j);
                }
            }
        }

        return res;

    }

    public void process(char[][] grid, int r, int c) {

        //判断点是否在网格内
        if (!inArea(grid, r, c)) return;

        //判断是否是 陆地
        if (grid[r][c] != '1') return;

        //标记遍历过的 点
        grid[r][c] = '2';

        //上 -> 右 -> 下 -> 左
        process(grid, r - 1, c);

        process(grid, r, c + 1);

        process(grid, r + 1, c);

        process(grid, r, c - 1);


    }


    public boolean inArea(char[][] grid, int r, int c) {

        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;

    }

```





### [463. 岛屿的周长](https://leetcode-cn.com/problems/island-perimeter/) 

```java
public int islandPerimeter(int[][] grid) {

    if (grid == null) return 0;


    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 1) {
                return process(grid, i, j);
            }
        }
    }

    return 1;

}

public int process(int[][] grid, int r, int c) {

    //边界 +1
    if (!inArea(grid, r, c)) return 1;

    //海洋 +1
    if (grid[r][c] == 0) return 1;

    //陆地 +0
    if (grid[r][c] == 2) return 0;

    grid[r][c] = 2;

    return process(grid, r - 1, c)
        + process(grid, r + 1, c)
        + process(grid, r, c - 1)
        + process(grid, r, c + 1);


}

public boolean inArea(int[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
}

```



### [695. 岛屿最大面积](https://leetcode-cn.com/problems/max-area-of-island/) 

```java
 public int maxAreaOfIsland(int[][] grid) {

        if(grid == null) return 0;

        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    int process = process(grid, i, j);
                    max = Math.max(process,max);
                }
            }
        }

        return max;

    }


    public int process(int[][] grid, int r, int c) {

        if (!inArea(grid, r, c) || grid[r][c] != 1) return 0;

        grid[r][c] = 2;

        return 1 + process(grid, r-1, c)
                + process(grid, r+1, c)
                + process(grid, r, c-1)
                + process(grid, r, c+1);



    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

```



### [827. 最大人工岛](https://leetcode-cn.com/problems/making-a-large-island/) x







# 斐波那契数列

### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)（斐波那契数列）

[剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

```java
/*
        70 https://leetcode-cn.com/problems/climbing-stairs/

     */
    public int climbStairs_1(int n) {

        if(n < 3) return n;
        int[] step = new int[n + 1];

        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];

        }

        return step[n];

    }

    public int climbStairs(int n) {
        if(n < 3) return n;

        int prr = 1;
        int pr = 2;

        for (int i = 2; i < n; i++) {
            pr = prr + pr;
            prr = pr - prr;
        }
        return pr;
    }

```



### [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

```java

public int fib(int n) {

    // 0 1 2 ... i=(i-1)+(i-2) ... n

    final int MOD = 1000000007;

    if(n == 0) return 0;

    if(n == 1 || n == 2) return 1;

    int prePre = 1,pre = 1;

    for (int i = 3; i <= n; i++) {
        int curr = pre + prePre;
        prePre = pre;
        pre = curr%MOD;
    }
    return pre;

}
```

### [面试题 08.01. 三步问题](https://leetcode-cn.com/problems/three-steps-problem-lcci/)

```java
public int waysToStep(int n) {

    final int MOD = 1000000007;

    if(n == 1) return 1;
    if(n == 2) return 2;
    if(n == 3) return 4;

    int p1 = 1,p2 = 2,p3 = 4;

    for (int i = 4; i <= n ; i++) {
        int curr = ((p1 + p2)  % MOD  + p3 ) % MOD;
        p1 = p2 ;
        p2 = p3 ;
        p3 = curr ;
    }

    return p3  ;
}
```

### [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)

```java
public int fib(int n) {

    if(n == 0) return 0;
    if(n == 1) return 1;

    int prePre = 0,pre = 1;

    for (int i = 2; i < n ; i++) {
        int curr = pre + prePre;
        prePre = pre;
        pre = curr;
    }

    return pre;


}

```



### [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)

```java
public int minCostClimbingStairs(int[] cost) {

    if(cost == null || cost.length == 0) return 0;

    int len = cost.length;

    int[] dp = new int[len + 1];

    dp[0] = dp[1] = 0;

    for (int i = 2; i <= len ; i++) {
        dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
    }

    return dp[len];

}
```

### [1137. 第 N 个泰波那契数](https://leetcode-cn.com/problems/n-th-tribonacci-number/) （斐波那契数列）





# 链表

### [817. 链表组件](https://leetcode-cn.com/problems/linked-list-components)



```java
 public int numComponents(com.at.bean.ListNode head, int[] nums) {

        int res = 0;

        if(head == null || nums == null || nums.length ==0) return res;

        HashSet<Integer> set = new HashSet<>();

        for (int elem : nums) {
            set.add(elem);
        }

        ListNode curr = head;

//        while (curr != null){
//
//            if(set.contains(curr.val)){
//                res +=1;
//                curr = curr.next;
//                while (curr != null && set.contains(curr.val)){
//                    curr = curr.next;
//                }
//
//            }else {
//                curr = curr.next;
//            }
//
//
//        }

        while (curr != null){
            if(set.contains(curr.val) && (curr.next == null || set.contains(curr.next.val))){
                res+=1;
            }
            curr = curr.next;
        }

        return res;


    }

```





### [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

```java
试用递归

public ListNode reverseList_1(ListNode head) {

    if (head == null || head.next == null) return head;

    Stack<ListNode> stack = new Stack<>();

    while (head != null) {
        stack.push(head);
        head = head.next;
    }

    head = stack.pop();
    ListNode curr = head;

    while (!stack.isEmpty()) {
        curr.next = stack.pop();
        curr = curr.next;
    }

    curr.next = null;

    return head;

}

==================
 public ListNode reverseList(ListNode head) {


        ListNode curr = head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        while (curr.next != null && curr.next != null){

            ListNode tmp  = curr.next;

            curr.next = tmp.next;
            tmp.next = newHead.next;
            newHead.next = tmp;


        }


        return newHead.next;
    }
```

### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

```java
public boolean hasCycle_1(ListNode head) {

    //缓存
    if (head == null || head.next == null) return false;

    HashSet<ListNode> set = new HashSet<>();

    while (head != null) {
        if (set.contains(head)) {
            return true;
        }
        set.add(head);
        head = head.next;
    }

    return false;

}

public boolean hasCycle(ListNode head) {
    //快慢指针

    if (head == null || head.next == null) return false;

    ListNode f = head.next;
    ListNode s = head;

    while (s != f) {
        if (f == null || f.next == null) return false;
        s = s.next;
        f = f.next.next;
    }


    return true;


}
```





### [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

  ```java

/*
        142. 环形链表 II
            https://leetcode-cn.com/problems/linked-list-cycle-ii/
     */
public ListNode detectCycle_1(ListNode head) {

    //缓存

    if (head == null || head.next == null) return null;

    HashSet<ListNode> set = new HashSet<>();

    while (head != null) {

        if (set.contains(head)) return head;

        set.add(head);
        head = head.next;
    }

    return null;
}

public ListNode detectCycle(ListNode head) {

    //快慢指针
    if (head == null || head.next == null) return null;

    ListNode f = head.next;
    ListNode s = head;

    while (f != s) {
        if (f == null || f.next == null) return null;
        f = f.next.next;
        s = s.next;
    }

    //s == f
    f = head;
    while (f != s.next) {
        f = f.next;
        s = s.next;
    }

    return f;
}
  ```

### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

```java
/*
        21. 合并两个有序链表
            https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */

public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {

    if (l1 == null && l2 == null) return null;

    if (l1 == null && l2 != null) return l2;

    if (l1 != null && l2 == null) return l1;


    ListNode head = new ListNode();
    ListNode curr = head;

    while (l1 != null && l2 != null) {

        if (l1.val > l2.val) {
            curr.next = l2;
            l2 = l2.next;
        } else {
            curr.next = l1;
            l1 = l1.next;
        }
        curr = curr.next;

    }

    while (l1 != null) {
        curr.next = l1;
        l1 = l1.next;
        curr = curr.next;
    }

    while (l2 != null) {
        curr.next = l2;
        l2 = l2.next;
        curr = curr.next;
    }


    return head.next;


}

public ListNode mergeTwoLists(ListNode l1, ListNode l2){

    if (l1 == null){
        return l2;
    }else if(l2 == null){
        return l1;
    }else if(l1.val > l2.val){
        l1.next = mergeTwoLists(l1.next,l2);
        return l1;
    }else {
        l2.next = mergeTwoLists(l1,l2.next);
        return l2;
    }


}

```



### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

```java
/*
        24. 两两交换链表中的节点
            https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     */

public ListNode swapPairs_1(ListNode head) {

    //缓存

    if (head == null || head.next == null) return head;

    LinkedList<ListNode> l1 = new LinkedList<>();
    LinkedList<ListNode> l2 = new LinkedList<>();

    int i = 1;

    while (head != null) {
        if (i % 2 == 1) {
            l1.add(head);
        } else {
            l2.add(head);
        }
        i++;
        head = head.next;
    }

    ListNode h = new ListNode();
    ListNode c = h;

    while (!l1.isEmpty() && !l2.isEmpty()) {
        c.next = l2.pollFirst();
        c.next.next = l1.pollFirst();
        c = c.next.next;
    }


    c.next = i % 2 == 0 ? l1.pollFirst() : l2.pollFirst();


    return h.next;


}

public ListNode swapPairs_2(ListNode head) {

    //指针
    if (head == null || head.next == null) return head;

    ListNode p = head;
    ListNode n = head.next;
    ListNode c = head.next.next;

    //只有两个节点
    if (c == null) {
        n.next = p;
        p.next = c;
        return n;
    }

    //三个以上的节点
    ListNode h = head.next;

    while (n != null && c != null) {

        p.next = c.next;
        n.next = p;

        if (c.next == null) {
            c.next = n;
            p.next = c;
            c.next = null;
            break;
        }
        if (c.next.next == null) {
            p.next.next = c;
            c.next = null;
            break;
        }
        p = c;
        n = p.next;

        c = n.next;

    }

    return h;


}


public ListNode swapPairs(ListNode head){

    if(head == null || head.next == null) return  head;

    ListNode n = head.next;

    head.next = swapPairs(n.next);

    n.next = head;

    return head;

}

//===============================================
public ListNode swapPairs(ListNode head) {

    if(head == null || head.next == null) return head;


    ListNode tmpH = new ListNode();
    ListNode curr = tmpH;

    curr.next = head;

    while (curr.next == null || curr.next.next == null){

        ListNode node1 = curr.next;
        ListNode node2 = curr.next.next;

        curr.next = node1;
        node1.next = node2.next;
        node2.next = node1;

        curr = node1;

    }

    return tmpH.next;

}
```



# 树

### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree)

```java


//存储父节点
    HashMap<TreeNode, TreeNode> conn = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        conn.put(root,root);
        process(root);

        HashSet<TreeNode> setConn = new HashSet<>();
        TreeNode curr = p;
        while (curr != conn.get(curr)){
            setConn.add(curr);
            curr = conn.get(curr);
        }
        setConn.add(curr);

        curr = q;
        while (!setConn.contains(curr)){
            curr = conn.get(curr);
        }

        return curr;


    }

    public void process(TreeNode head){

        if(head == null) return;

        conn.put(head.left,head);
        conn.put(head.right,head);

        process(head.left);
        process(head.right);

    }


//递归
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){

        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;

    }

```



### [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes)

```java

class ReturnData{
    public int nodes;
    public ReturnData(int n){
        this.nodes = n;
    }
}

public int countNodes(TreeNode root) {

    return process(root).nodes;

}


public ReturnData  process(TreeNode head){

    if(head == null) return new ReturnData(0);

    ReturnData leftData = process(head.left);
    ReturnData rightData = process(head.right);

    return new ReturnData(leftData.nodes + rightData.nodes + 1);


}

//==============
public int countNodes(TreeNode root) {

    return process(root);

}


public int  process(TreeNode head){

    if(head == null) return 0;

    int leftData = process(head.left);
    int rightData = process(head.right);

    return leftData + rightData + 1;


}
```



### [96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees)

```java

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

```



### [95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii)  

```java
public List<TreeNode> generateTrees(int n) {

    if (n == 0) return new LinkedList<>();

    return generateTrees(1,n);
}

public List<TreeNode> generateTrees(int start, int end) {

    List<TreeNode> allTree = new LinkedList<>();
    if (start > end) {
        allTree.add(null);
        return allTree;
    }

    for (int i = start; i <= end; i++) {

        List<TreeNode> leftTrees = generateTrees(start, i - 1);
        List<TreeNode> rightTrees = generateTrees(i + 1, end);

        for (TreeNode leftTree : leftTrees) {
            for (TreeNode rightTree : rightTrees) {
                TreeNode currTree = new TreeNode(i);
                currTree.left = leftTree;
                currTree.right = rightTree;
                allTree.add(currTree);
            }
        }

    }

    return allTree;


}

```







### [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)

```java
class ReturnData{
        public int maxDep;
        public ReturnData(int deep){
            this.maxDep = deep;
        }
    }


    public ReturnData process(TreeNode root){

        if(root == null) return new ReturnData(0);

        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);

        int maxDep = Math.max(leftData.maxDep, rightData.maxDep) + 1;

        return new ReturnData(maxDep);
    }

    public int process1(TreeNode root){

        if(root == null) return 0;

        int lD = process1(root.left);
        int rD = process1(root.right);

        int max = Math.max(lD,rD) + 1;

        return max;

    }

    public int maxDepth(TreeNode root) {
        return process1(root);
    }
```





### [102. 二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)

```java
public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> list = new ArrayList<>();

    if (root == null) return list;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {

        int size = queue.size();

        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            TreeNode curr = queue.poll();

            level.add(curr.val);

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        list.add(level);

    }

    return list;

}

```



### [103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal) 

```java
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    List<List<Integer>> list = new ArrayList<>();
    if(root == null) return list;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    //true 从 -> 出 ，false 从 <- 出
    boolean getOrder = true;

    while (!queue.isEmpty()){

        int size = queue.size();
        Deque<Integer> levelDeque = new LinkedList<>();

        for (int i = 0; i < size; i++) {

            TreeNode pollNode = queue.poll();
            if(getOrder){
                levelDeque.addLast(pollNode.val);
            }else {
                levelDeque.addFirst(pollNode.val);
            }

            if(pollNode.left != null){
                queue.add(pollNode.left);
            }
            if(pollNode.right != null){
                queue.add(pollNode.right);
            }

        }

        list.add(new LinkedList<>(levelDeque));
        getOrder = !getOrder;

    }

    return list;

}

```







### [105. 从前序与中序遍历序列构造二叉](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)

```java
Map<Integer, Integer> map = new HashMap<>(); // k:value v:index

public TreeNode buildTree(int[] preorder, int[] inorder) {

    int preLen = preorder.length;
    int inLen = inorder.length;

    if(preLen != inLen){
        return null;
    }

    for (int i = 0; i < inLen; i++) {
        map.put(inorder[i],i);
    }


    return builds(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
}

public TreeNode builds(int[] preOrder, int preLeft, int preRight,
                       int[] inOrder, int inLeft, int inRight) {

    if(preLeft > preRight || inLeft > inRight){
        return null;
    }


    int rootVal = preOrder[preLeft];
    TreeNode root = new TreeNode(rootVal);

    Integer pivot = map.get(rootVal);


    root.left = builds(preOrder,preLeft+1,pivot-inLeft + preLeft,inOrder,inLeft,pivot-1);

    root.right = builds(preOrder,pivot-inLeft+preLeft+1,preRight,inOrder,pivot+1,inRight);

    return root;


}
```



### [100. 相同的树](https://leetcode-cn.com/problems/same-tree)

```java
 public boolean isSameTree1(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;


        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);


    }




    public boolean isSameTree(TreeNode p, TreeNode q) {


        if (p == null && q == null) return true;

        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val) return false;


        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {

            TreeNode currP = queueP.poll();
            TreeNode currQ = queueQ.poll();

            if (currP.val != currQ.val) {
                return false;
            }

            if ((currP.left != null && currQ.left != null) || (currP.left == null && currQ.left == null)) {
                if (currP.left != null) {
                    queueP.add(currP.left);
                    queueQ.add(currQ.left);
                }
            } else {
                return false;
            }

            if ((currP.right != null && currQ.right != null) || (currP.right == null && currQ.right == null)) {
                if (currP.right != null) {
                    queueP.add(currP.right);
                    queueQ.add(currQ.right);
                }
            } else {
                return false;
            }


        }

        return true;


    }
```



### [99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree)

```java
//中序遍历过程中，记录错误两个错误排序节点，最后进行交换

TreeNode t1, t2, pre;

public void inOrder(TreeNode root) {

    if (root == null) return;

    inOrder(root.left);

    if (pre != null && pre.val > root.val) {
        if (t1 == null) t1 = pre;
        t2 = root;
    }

    pre = root;

    inOrder(root.right);

}


public void recoverTree(TreeNode root) {

    if (root == null) return;

    inOrder(root);

    TreeNode tmp = t1;
    t1 = t2;
    t2 = tmp;

}
```







# other

### [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable)

```java
class NumArray {

    int[] res;

    public NumArray(int[] nums) {
        res = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            res[i] = res[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {

        return res[right+1] - res[left];

    }
}

```

### [26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

```java
    /*
        26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

        在数组基础上修改不能使用额外的内存

        去除重复的数
        找到重复的数用后面不是重复的数将其覆盖掉

     */
    public int removeDuplicates(int[] nums) {
        int pre = 0;
        int next = 1;

        while (next < nums.length) {

            if (nums[pre] != nums[next]) {
                nums[++pre] = nums[next];
            }

            next++;
        }

        return pre + 1;
    }
```

### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

```
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

```







### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

```java
	/*
        88 https://leetcode-cn.com/problems/merge-sorted-array/

        归并
        逆向归避免覆盖num1中的数据

     */

    public void merge_1(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0 && n == 0 || n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] sort = new int[n + m];

        int p1 = 0, p2 = 0, k = 0;

        while (p1 < m || p2 < n) {

            if (p1 == m) {
                sort[k] = nums2[p2++];
            } else if (p2 == n) {
                sort[k] = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                sort[k] = nums1[p1++];
            } else {
                sort[k] = nums2[p2++];
            }

            k++;
        }

        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0 || n == 0) return;

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int p1 = m - 1, p2 = n - 1, k = nums1.length - 1;

        while (p1 >= 0  || p2 >= 0){

            if(p1 < 0){
                nums1[k] = nums2[p2--];
            }else if(p2 < 0){
                nums1[k] = nums1[p1--];
            }else if(nums1[p1] <= nums2[p2]){
                nums1[k] = nums2[p2--];
            }else {
                nums1[k] = nums1[p1--];
            }

            k--;
        }
    }
```





### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

```java
 /*

    189 https://leetcode-cn.com/problems/rotate-array/

     */

    public void rotate_1(int[] nums, int k) {

        //将后面的k个元素先放入一个新的数组中，再将原来的数组中的 nums.length-k 个数组后移k位
        //最后将后面的k个元素添加到 nums 数组中

        int len = nums.length;

        if(nums == null || len < 2) return;

        if(k >= len) k = k % len;

        if(k == 0) return;

        int[] tail = new int[k];
        int j = 0;
        for (int i = len-k; i < len ; i++) {
            tail[j++] = nums[i];
        }

        for (int i = len - k - 1; i  >= 0 ; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = tail[i];
        }


    }

    public void rotate_2(int[] nums, int k) {

        int len = nums.length;

        if(nums == null || len < 2) return;

        if(k >= len) k = k % len;

        if(k == 0) return;

       while (k-- > 0){

           int t = nums[len-1];
           for (int i = len-2; i >=0 ; i--) {
               nums[i+1] = nums[i];
           }
           nums[0] = t;

       }

    }

    public void rotate(int[] nums, int k) {

        //数组反转  
        int len = nums.length;

        if(nums == null || len < 2 || k % len == 0) return;

        if(k >= len) k = k % len;


        revorse(nums,0,len-1);
        revorse(nums,0,k-1);
        revorse(nums,k,len-1);

    }

    public void revorse(int[] arr,int start,int end){
        while (start < end){
            arr[start] = arr[start] ^ arr[end];
            arr[end] = arr[start] ^ arr[end];
            arr[start] = arr[start] ^ arr[end];

            start++;
            end--;
        }

    }
```





### [152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)

```java
/*
         152  https://leetcode-cn.com/problems/maximum-product-subarray/
     */
public int maxProduct(int[] nums) {

    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    int m = nums.length;


    int max = Integer.MIN_VALUE;
    int imax = 1,imin  = 1;

    for (int i = 0; i < nums.length; i++) {

        if(nums[i] < 0){
            imax = imin ^ imax;
            imin = imin ^ imax;
            imax = imin ^ imax;
        }

        imax = Math.max(nums[i],nums[i]*imax);
        imin = Math.min(nums[i],nums[i]*imin);

        max = Math.max(max,imax);

    }



    return max;


}

```







### [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) x                                                                                                       

















