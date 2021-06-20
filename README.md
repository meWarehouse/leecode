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
 		int n = prices.size();
        int dp[n][2];
        dp[0][0] = 0, dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];

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



## [66. 加一](https://leetcode-cn.com/problems/plus-one/)

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



## [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

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



## [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

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





## [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

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



















































