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
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
```



## [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/) x

```java
public int maxProfit(int k, int[] prices) {

    if(prices == null || k < 1) return 0;

    int len = prices.length;
    if(len == 1) return 0;

    int[] max = new int[len];
    int m = 0;

    for (int i = 0; i < len; i++) {
        m = 0;
        for (int j = i+1; j < len; j++) {

            int p = prices[j] - prices[i];
            m = Math.max(m,p);

        }
        max[i] = m;
    }

    Arrays.sort(max);

    int p = len-1;
    m = 0;
    while (k-- > 0){
        m+=max[p--];
    }

    return m;

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







## [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/) x                                                                                                       







## [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

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

## [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

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



## [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

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





## [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)

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



## [面试题 01.05. 一次编辑](https://leetcode-cn.com/problems/one-away-lcci/)

```
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



## [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/) x



## [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)

```java
/*
        91 https://leetcode-cn.com/problems/decode-ways/

     */

public int dfs(String s, int index) {

    if (cache.containsKey(index)) return cache.get(index);

    if (index >= s.length()) return 1;

    int one = 0;
    int two = 0;

    if (s.charAt(index) != '0') {
        one = dfs(s, index + 1);
    }

    if (index + 1 < s.length() && s.charAt(index) != '0' && isValidNum(s, index)) {
        two = dfs(s, index + 2);
    }

    cache.put(index, one + two);
    return cache.get(index);

}

public boolean isValidNum(String s, int index) {

    int a = s.charAt(index) - 48;
    int b = s.charAt(index + 1) - 48;

    int res = a * 10 + b;

    return res >= 10 && res <= 26;

}

//=============================


public int numDecodings_2(String s) {


    if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

    int len = s.length();

    if (len == 1) return 1;

    int[] dp = new int[len];
    dp[0] = 1;

    //第二个数为 '0'
    if (s.charAt(1) != '0') {
        dp[1] = 1;
    }

    //第二个数可以与前一个数组合
    if (isValid(s, 1)) {
        dp[1] = dp[1] + dp[0];
    }

    for (int i = 2; i < len; i++) {

        if (s.charAt(i) != '0') {
            dp[i] = dp[i - 1];
        }

        if (isValid(s, i)) {
            dp[i] = dp[i] + dp[i - 2];
        }

    }

    return dp[len - 1];


}

public int numDecodings(String s) {

    if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

    int len = s.length();

    if (len == 1) return 1;

    int pre = 1;
    int curr = 0;

    if (s.charAt(1) != '0') {
        curr = 1;
    }

    if (isValid(s, 1)) {
        curr = curr + pre;
    }

    for (int i = 2; i < len; i++) {
        int temp = 0;
        if (s.charAt(i) != '0') {
            temp = curr;
        }
        if (isValid(s, i)) {
            temp += pre;
        }
        pre = curr;
        curr = temp;
    }

    return curr;

}


public boolean isValid(String str, int index) {


    int a = str.charAt(index - 1) - 48;
    int b = str.charAt(index) - 48;
    int t = a * 10 + b;
    return t >= 10 && t <= 26;
}

```



## [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

```java
/*
    120 https://leetcode-cn.com/problems/triangle/
     */
    
    public int minimumTotal_1(ArrayList<ArrayList<Integer>> triangle) {

        int m = triangle.size();

        int[][] dp = new int[m][m];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {

            List<Integer> tar = triangle.get(i);

            dp[i][0] = tar.get(0) + dp[i - 1][0];

            for (int j = 1; j < tar.size(); j++) {


                if (j == tar.size() - 1) {
                    dp[i][j] = tar.get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = tar.get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }

            }
        }

        int min = dp[m - 1][0];
        for (int i = 1; i < dp[m - 1].length; i++) {
            min = Math.min(dp[m - 1][i], min);
        }


        return min;


    }


    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        int m = triangle.size();

        int[][] dp = new int[m+1][m+1];

        for (int i = m-1; i >= 0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1] + triangle.get(i).get(j));
            }
        }

        return dp[0][0];

    }
```





## [152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)

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





## [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

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
```

## [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

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





## [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

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

## [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

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



## [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

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
```



## [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree)

```java

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



## [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes)

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






























































































