package com.at.leecode_1;

import java.util.Arrays;
import java.util.Scanner;

public class MT_2021_10_2 {

    /*
    链接：https://www.nowcoder.com/questionTerminal/0771ab500d424415af6b1aa4c13afcdd
    来源：牛客网

    我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序

    有一天小团得到了一个长度为n的任意序列，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。

    请问他最少用多少次操作可以把这个序列变成正则序列？


    输入描述:
    输入第一行仅包含一个正整数n，表示任意序列的长度。(1<=n<=20000)

    输入第二行包含n个整数，表示给出的序列，每个数的绝对值都小于10000。



    输出描述:
    输出仅包含一个整数，表示最少的操作数量。

    示例1
    输入
    5
    -1 2 3 10 100
    输出
    103
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        //人数
        int n = sc.nextInt();
        //n个整数
        int[] zheshu = new int[n];

        for (int i = 0; i < zheshu.length; i++) {

            zheshu[i] = sc.nextInt();

        }


        System.out.println(test1(n,zheshu));


    }

    public static int test1(int n,int zheshu[]){

        //先排序 再减去对应的序号
        Arrays.sort(zheshu);

        int cishu = 0;
        for (int i = 1; i <= n; i++) {
            cishu += Math.abs(i - zheshu[i-1]);
        }

        return cishu;

    }



}
