
# 剑指 Offer

//D:\workspace\workspace2021\leecode\images

## 09. 用两个栈实现队列

![](../images/966aebd484002e620d88676847273a061ab9ab6d863ab5079ab347a643461e24-09.gif)

```java

class CQueue {

    //可以使用 双端队列
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }

    }

    public int deleteHead() {

        if(stack1.isEmpty()){
            return -1;
        }else {
            return stack1.pop();
        }
    }
}


```

## 30. 包含min函数的栈

![](../images/850feccffa1077aaa92db035f41687509a3ddc570b22e9f8176d954e122edea7-Picture6.png)

```java

class MinStack {

    Stack<Integer> dataStack;
    Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        dataStack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }

    }

    public void pop() {

        Integer popValue = dataStack.pop();
        // Integer是对象不能  minStack.peek() == popValue 这样
        if(minStack.peek().equals(popValue)){
            minStack.pop();
        }

    }

    public int top() {
        if (dataStack.isEmpty()){
            return -1;
        }
        return dataStack.peek();
    }

    public int min() {
        if(minStack.isEmpty()){
            return -1;
        }
        return minStack.peek();
    }
}

```

##  10- I. 斐波那契数列

```java
https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
```


##  03. 数组中重复的数字

```java

public int findRepeatNumber(int[] nums) {

    int[] arr = new int[100001];

    int len = nums.length;

    for (int i = 0; i < len; i++) {
        int count = arr[nums[i]];
        if (count >= 1) {
            return nums[i];
        }
        arr[nums[i]] = count + 1;

    }

    return Integer.MIN_VALUE;

}
```

## 04. 二维数组中的查找

```java
public boolean findNumberIn2DArray(int[][] matrix, int target) {


    /*
        二分 右上到左下
            大 向下
            小 向左
     */
    if (matrix == null || matrix.length == 0) return false;

    int row = matrix.length;
    int column = matrix[0].length;

    int x = 0, y = column - 1;

    while (x < row && y >= 0) {

        if (target > matrix[x][y]) {
            x += 1;
        } else if (target < matrix[x][y]) {
            y -= 1;
        } else {
            return true;
        }

    }

    return false;
}

```

## 11. 旋转数组的最小数字

```java
public int minArray(int[] numbers) {

    /*
        1.数组是有序的
        2.发生了旋转
        3. i -> j 上
            如果 arr[i] < arr[j] 则 i->j 上必然是递增的
            ** 只能判断从 左 到 右 这部分
            只能判断 mid -> R 是 递增的并不能确定 mid 处是不是最小值
     */
    if (numbers == null || numbers.length == 0) return Integer.MIN_VALUE;

    int len = numbers.length;

    int L = 0, R = len-1;

    while (L < R){

        int mid = L + ((R-L)/2);

        if(numbers[mid] < numbers[R]){
            R = mid;
        }else if(numbers[mid] > numbers[R]){
            L = mid + 1;
        }else {
            R--;
        }

    }

    return numbers[L];
}

```

##  12. 矩阵中的路径

```java

    //https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if(board[i][j] == word.charAt(0) && process(board,word,i,j,0)){
                    return true;
                }

            }
        }

        return false;

    }


    public boolean process(char[][] arr,String world,int x,int y,int k){

        if(!inArea(arr,x,y)) return false;
        if(arr[x][y] != world.charAt(k)) return false;
        if(k == world.length()-1) return true;

        arr[x][y] = ' ';

        boolean res = process(arr,world,x-1,y,k+1)
                || process(arr, world, x+1, y, k+1)
                || process(arr, world, x, y-1, k+1)
                || process(arr, world, x, y+1, k+1);

        arr[x][y] = world.charAt(k);

        return res;



    }

    public boolean inArea(char[][] arr,int x,int y){
        return x>=0 && x < arr.length && y >=0 && y < arr[0].length;
    }


```

### 05. 替换空格
```java
//https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
public String replaceSpace(String s) {

    int len = s.length();
    char[] arr = new char[3 * len];
    int size = 0;

    for (int i = 0; i < len; i++) {

        if(s.charAt(i) == ' '){
            arr[size++] = '%';
            arr[size++] = '2';
            arr[size++] = '0';
        }else{
            arr[size++] = s.charAt(i);
        }

    }

    return new String(arr,0,size);

}
```

###  53 - I. 在排序数组中查找数字 I

```java
//https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
//二分

public int search(int[] nums, int target) {

    if(nums == null || nums.length == 0) return -1;
    int len = nums.length;
    if(nums[0] > target || nums[len-1] < target) return -1;


    int L = 0,R = len -1;
    int count = 0;
    while (L <= R){

        int mid = L + ((R-L) >> 1);

        if(nums[mid] > target){
            R = mid - 1;
        }else if(nums[mid] < target){
            L = mid + 1;
        }else {
            int i = mid-1;
            while (mid <= R && nums[mid] == target){
                count+=1;
                mid++;
            }
            while (i >= L && nums[i] == target ){
                count+=1;
                i--;
            }
            break;
        }


    }


    return count;

}
```

###  53 - II. 0～n-1中缺失的数字

```java
//https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
public int missingNumber(int[] nums) {

    int L = 0,R = nums.length-1;

    while (L <= R){
        int mid = L + ((R - L) >> 1);
        if(nums[mid] == mid){
            L = mid + 1;
        }else {
            R = mid -1;
        }
    }

    return L;


}
```

### 26. 树的子结构

```java
//https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
//https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/yi-pian-wen-zhang-dai-ni-chi-tou-dui-che-uhgs/
public boolean isSubStructure(TreeNode A, TreeNode B) {


    if(A == null || B == null) return false;

    return isSub(A, B) || isSubStructure(A.left,B) || isSubStructure(A.right, B);


}

public boolean isSub(TreeNode A,TreeNode B){

    if(B == null) return true;

    if(A == null || A.val != B.val) return false;


    return isSub(A.left,B.left) && isSub(A.right,B.right);

}

```

### 27. 二叉树的镜像
```java
//https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
    public TreeNode mirrorTree(TreeNode root) {

        preOrder(root);

        return root;

    }


    public void preOrder(TreeNode root){

        if(root == null) return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if(root.left != null) preOrder(root.left);

        if(root.right != null) preOrder(root.right);



    }

```

###  28. 对称的二叉树

```java
//https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
public boolean isSymmetric(TreeNode root) {

    if(root == null) return true;

    return isSym(root.left,root.right);

}

public boolean isSym(TreeNode L,TreeNode R){

    if(L == null && R == null) return true;

    if(L == null || R == null || L.val != R.val) return false;

    return isSym(L.left, R.right) && isSym(L.right, R.left);

}


```

























































