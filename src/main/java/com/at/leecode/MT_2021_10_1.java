package com.at.leecode;

import java.util.Arrays;
import java.util.Scanner;

public class MT_2021_10_1 {

    /*
        某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。

        但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。

        显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。


        输入描述:
        输入第一行仅包含三个正整数n,x,y，分别表示参赛的人数和晋级淘汰人数区间。(1<=n<=50000,1<=x,y<=n)

        输入第二行包含n个整数，中间用空格隔开，表示从1号选手到n号选手的成绩。(1<=|a_i|<=1000)


        输出描述:
        输出仅包含一个整数，如果不存在这样的m，则输出-1，否则输出符合条件的最小的值。


        输入例子1:
        6 2 3
        1 2 3 4 5 6

        输出例子1:
        3
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        //人数
        int n = sc.nextInt();
        //区间
        int x = sc.nextInt();
        int y = sc.nextInt();

        //分数
        int[] cores = new int[n];

        for (int i = 0; i < cores.length; i++) {

            cores[i] = sc.nextInt();

        }


        System.out.println(test1(n, x, y, cores));


    }

    public static int test1(int n,int x,int y,int cores[]){

        int m = -1;

        if(n <= 0 || n > 50000) return m;
        if(x < 1 || y > n || x > y) return m;

        if(2 * y < n ) return m;

        //要想分数线最低就必须是晋升人数最多 淘汰人数最少
        Arrays.sort(cores);


        //晋升<=y   淘汰>=x
        int tao = 0;

        while ((tao = cores.length - y) < x){
            y--;
        }



        return cores[cores.length - y - 1];

    }



}
