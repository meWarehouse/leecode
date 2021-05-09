package com.at.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MT_2021_8_2 {

    /*

    小美喜欢字母E，讨厌字母F。在小美生日时，小团送了小美一个仅包含字母E和F的字符串，小美想从中选出一个包含字母E数量与字母F数量之差最大的子串。

    *子串：从字符串前面连续删去若干个字符，从后面连续删去若干个字符剩下的字符串（也可以一个都不删），例如abcab是fabcab的子串，而不是abcad的子串。我们将空串看作所有字符串的子串。


    输入描述:
    第一行一个正整数n表示字符串的长度。

    第二行长度为n，且仅包含大写字母’E’,’F’的字符串（不含引号）





    输出描述:
    输出一个整数，表示最大的差值

    示例1
    输入
    5
    EFEEF
    输出
    2
    说明
    选择子串EE,此时有2个E，0个F,有最大差值2-0=2

    另外，选择子串EFEE也可以达到最大差值。

    -------------------------------------------
        把E看成1，F看成-1。
        遍历数组，遇到E就+1，遇到F就-1，如果所有的E都被F平衡完了，
        就从0开始重新计算，即从当前位置重新开启一段子数组计算E和F的个数差值。


     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        System.out.println(test(n,line));


    }

    public static int test(int n,String line){

        if(line == null || line.length() == 0) return 0;

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            //E 看成1 F看成-1
            if(line.charAt(i) == 'E') sum++;
            else if(line.charAt(i) == 'F') sum--;

            max = Math.max(max,sum);
            sum = Math.max(sum,0);

        }

        return max;

    }


}
