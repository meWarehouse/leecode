---
typora-root-url: images
---



每天复习一遍 

思想 方法



## 121 [买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock)  

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

```



## 122 [买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii)  

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

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 0; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[0]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }

        return dp[n-1][0];

    }
```



## [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

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



## [26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

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



































































