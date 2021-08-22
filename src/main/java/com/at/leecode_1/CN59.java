package com.at.leecode_1;

public class CN59 {

    /*

   https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tab=answerKey

    给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
    示例1
    输入
    复制
    [[1,3,5,9],[8,1,3,4],[5,0,6,1],[8,8,4,0]]
    返回值
    复制
    12
    备注:
    1 \leq n,m \leq 20001≤n,m≤2000
    1 \leq arr_{i,j} \leq 1001≤arr
    i,j
    ​
    ≤100
     */

    public static void main(String[] args) {


    }

    public int minPathSum(int[][] matrix) {

        if (matrix == null && matrix.length == 0) return 0;

        //动态规划

        //1.当节点在第一行时 那么该节点只可能时从其左边过来的
        //2.当节点在第一列时 那么该节点只可能时其上边来的
        //3.节点 matrix[i][j] 可能是左边来的也可能是上边来的

        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];


    }


}
