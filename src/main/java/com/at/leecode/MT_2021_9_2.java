package com.at.leecode;

import java.util.Arrays;
import java.util.Scanner;

public class MT_2021_9_2 {

    /*
        小团是某综艺节目的策划，他为某个游戏环节设计了一种晋级规则，已知在这个游戏环节中每个人最后都会得到一个分数score_i，显而易见的是，游戏很有可能出现同分的情况，小团计划该环节晋级人数为x人，则将所有人的分数从高到低排序，所有分数大于等于第x个人的分数且得分不为0的人都可以晋级。

        请你求出本环节的实际晋级人数。显然这个数字可能是0，如果所有人的得分都是0，则没有人满足晋级条件。


        输入描述:
        输入第一行包含两个正整数n和x，分别表示参加本环节的人数，和小团指定的x。

        输入第二行包含n个整数，每个整数表示一位选手的得分。


        输出描述:
        输出仅包含一个整数，表示实际晋级人数。

        输入例子1:
        5 4
        0 0 2 3 4

        输出例子1:
        3

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        //人数
        int n = sc.nextInt();
        //计划晋级人数 x
        int x = sc.nextInt();

        //每个人的分数
        int[] fen = new int[n];

        for (int i = 0; i < fen.length; i++) {
            fen[i] = sc.nextInt();
        }


        System.out.println(test1(n,x,fen));


    }

    public static int test1(int n,int x,int fen[]){

        Arrays.sort(fen);

        int index = fen.length - x < 0 ? 0 : fen.length - x;

        while (fen[index] <= 0 ){
            index++;
        }

        while (fen[index] == fen[index-1]){
            index--;
        }


        return fen.length - index;

    }



}
