package com.at.leecode_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MT_2021_9_3 {
    /*
        小美请小团吃回转寿司。转盘上有N盘寿司围成一圈，第1盘与第2盘相邻，第2盘与第3盘相邻，…，第N-1盘与第N盘相邻，第N盘与第1盘相邻。
        小团认为第i盘寿司的美味值为A[i]（可能是负值，如果小团讨厌这盘寿司）。
        现在，小团要在转盘上选出连续的若干盘寿司，使得这些寿司的美味值之和最大（允许不选任何寿司，此时美味值总和为0）。


        输入描述:
        第一行输入一个整数T（1<=T<=10），表示数据组数。

        每组数据占两行，第一行输入一个整数N（1<=N<=10^5）；

        第二行输入N个由空格隔开的整数，表示A[1]到A[N]（-10^4<=A[i]<=10^4）。



        输出描述:
        每组数据输出占一行，输出一个整数，表示连续若干盘寿司的美味值之和的最大值。

        示例1
        输入
        1
        4
        3 -2 4 -1
        输出
        6
        说明
        美味值之和最大连续若干盘寿司为第3盘、第4盘和第1盘。



        题目要求环形数组的连续子数组的最大和，我们先不要去管数组是环形的情况，利用动态规划求解连续子数组的最大和以及最小和。
        (1) 不考虑环形得到的最大值：题中允许寿司首尾相连的环形数组情况，因此常规求得的连续子数组的最大和就是我们排除这种情况之外的所有情况中的最大和。
        (2) 只考虑环形得到的最大值：而对于首尾相连的情况，我们可以这样考虑，如果常规求得的连续子数组的和达到了最小，那么总和减去这个最小值就等于首尾相连情况的最大值了。
        因此最大的美味值就是(1)和(2)两种情况中大的那个。
        ---------------------------------------------------------------------------------------------------------------------------
        接下来说一下动态规划如何求解连续子数组的最大和：
        状态定义：dp[i]表示以 i 结尾的连续子数组的最大和
        状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i])
        状态转移方程的意思是：如果选择了当前元素i，而dp[i-1]为负数，表明之前的和做的是负贡献，会使得整体的和变小，因此这时候选择从array[i]重新开始计算和。
        考虑到我们并不需要求得dp数组中所有的值，而是只需要最大值，所以还可以对空间复杂度进行优化。每次计算得到其中一个dp[i]时，就更新当前的最大值，而dp[i]之前的取值(dp[0],dp[1],...,dp[i-1])已经用过，所以不需要再保留了，仅用一个变量代替dp数组即可。
        求解连续子数组的最小和只要将以上的max改成min就可以了......
     */

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-- > 0){
                int n = Integer.parseInt(br.readLine().trim());
                String[] strArr = br.readLine().trim().split(" ");
                int[] arr = new int[n];
                int sum = 0;
                for(int i = 0; i < n; i++){
                    arr[i] = Integer.parseInt(strArr[i]);
                    sum += arr[i];
                }
                // 为了降低时间复杂度，可以两种情况一起求
                int max = arr[0];
                int min = arr[0];
                int dpMax = arr[0];
                int dpMin = arr[0];

                for (int i = 1; i < arr.length; i++) {

                    dpMax = Math.max(arr[i],arr[i] + dpMax);
                    dpMin = Math.min(arr[i],arr[i] +dpMin);

                    max = Math.max(max,dpMax);
                    min = Math.min(min,dpMin);

                }


                System.out.println(Math.max(sum - min,max));


            }
        }




}
