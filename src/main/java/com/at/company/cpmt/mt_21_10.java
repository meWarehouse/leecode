package com.at.company.cpmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @create 2021-09-11
 */
public class mt_21_10 {

    /*
        https://www.nowcoder.com/questionTerminal/9c4a4e879b4f49939dfaebea8948f976?answerType=1&f=discussion
     */

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] params = reader.readLine().trim().split(" ");

        int n = Integer.parseInt(params[0]);
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);

        String[] strArr = reader.readLine().trim().split(" ");

        int[] score = new int[n];
        for (int i = 0; i < strArr.length; i++) {
            score[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(score);

        //淘汰与晋升人数 [x,y]
        for (int i = x-1; i < y; i++) {

            int c = n - i - 1;
            int s = i + 1;
            int m = score[i];

            if(c >= x && c <= y){
                System.out.println(m);
                return;
            }

        }

        System.out.println(-1);


    }

}
