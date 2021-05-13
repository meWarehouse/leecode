---
typora-root-url: images
---





# leecode



## 动态规划

```
动态规划算法介绍
        动态规划(Dynamic Programming)算法的核心思想是：将大问题划分为小问题进行解决，从而一步步获取最优解的处理算法
        动态规划算法与分治算法类似，其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解。
        与分治法不同的是，适合于用动态规划求解的问题，经分解得到子问题往往不是互相独立的。 ( 即下一个子阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解 )
        
        动态规划可以通过填表的方式来逐步推进，得到最优解.
```

### 01背包

https://www.nowcoder.com/practice/2820ea076d144b30806e72de5e5d4bbf

```

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
                    dp[i][j] = Math.max(dp[i - 1][j], 
                    				dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
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

```



### 子数组的最大累加和

https://www.nowcoder.com/practice/554aa508dd5d4fefbf0f86e5fe953abd?tab=answerKey

```

```

### 最长回文子串

https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af

```
中心扩散法
	每遍历一个字符就以该字符为中心向两边扩散，查找最长回文子串
1.一个字符认为是一个回文
2.


    public int getLongestPalindrome(String A, int n) {
    	if(n<2) return n;
    	int max = 0;
    	for(int i=0;i<n){
    		if(n-i<max/2) break;
    		
    		int left = i,right=i;
    		
    		while(right<n-1 && A.charAt()){}
    		
    	
    	}
    
    }
 



```



### 股票买卖

https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec

```
股票利润：卖出的价格-买入的价格
思路：找到最大值及最大值前面的最小值
1.暴力匹配
    public int maxProfit1(int[] prices) {
        // write code here
        if (prices == null || prices.length < 2) return 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
2.双指针 动态规划
	 public int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length < 2) return 0;
        int buy = prices[0],max = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy,prices[i]);
            max = Math.max(prices[i] - buy,max);
        }
        return max;
    }
3.最大字序列
    假设数组的值是[a,b,c,d,e,f]，我们用数组的前一个值减去后一个值，得到的新数组如下
    [b-a,c-b,d-c,e-d,f-e]
    我们在新数组中随便找几个连续的数字相加就会发现一个规律，就是中间的数字都可以约掉，
    比如新数组中第1个到第4个数字的和是
    b-a+c-b+d-c+e-d=e-a
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int curr = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            curr = Math.max(curr, 0) + prices[i] - prices[i - 1];
            max = Math.max(max, curr);
        }
        return max;
    }

```





### 最长公共子串

https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac

### 最长公共字序列

https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11





## 数组

### JZ1

https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e

```

暴力求解无需多言

```

![Snipaste_2021-05-13_16-07-49](/Snipaste_2021-05-13_16-07-49.jpg)

```
由数组的特性可知 从左至右依次递增 从上至下依次递增
所以从右上角开始遍历
如果val=tar 则返回true
如果tar>val 向下
如果tar<val 向左

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0) return false;
        System.out.println(array[array.length - 1][array[array.length - 1].length - 1]);
        int x = 0;
        int y = array[0].length - 1;
        while (x < array.length && y >= 0) {
            if (target == array[x][y]) {
            return true;
            }
            if (target > array[x][y]) {
                //向下
                x += 1;
            } else if (target < array[x][y]) {
                //向左
                y -= 1;
            }
        }
        return false;
    }
```





















## 字符串















































































































































































































