package com.at.test;

public class Kmp {


    public static void main(String[] args) {


        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";//ABCDABD

        System.out.println(violenceMatch(str1, str2));


        System.out.println(kmp(str1, str2));

    }

    public static int kmp(String str1, String str2) {

        if(str2.length() > str1.length()) return -1;

        int[] next = kmpNext(str2);

        for (int i = 0,j=0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
//                j = next[j - 1];
//                j = j - 1;
                 i = i - next[j - 1];
                 j = 0;
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }

            if(j == str2.length()){
                return i - j + 1;
            }

        }

        return -1;
    }


    public static int[] kmpNext(String dest) {

        int next[] = new int[dest.length()];
        next[0] = 0;

        for (int i = 1,j = 0; i < dest.length(); i++) {

            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
//                j = next[j - 1];
                j = j - 1;
            }

            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }

            next[i] = j;

        }


        return next;
    }


    /**
     * 暴力匹配算法
     * 如果用暴力匹配的思路，并假设现在str1匹配到 i 位置，子串str2匹配到 j 位置，则有:
     * 如果当前字符匹配成功（即str1[i] == str2[j]），则i++，j++，继续匹配下一个字符
     * 如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。
     * 用暴力方法解决的话就会有大量的回溯，每次只移动一位，若是不匹配，移动到下一位接着判断，浪费了大量的时间。(不可行!)
     */
    public static int violenceMatch(String s1,String s2) {

        if(s2.length() > s1.length()) return -1;

        int i = 0;
        int j = 0;

      while (i < s1.length() && j < s2.length()){
          if(s1.charAt(i) == s2.charAt(j)){
              i++;
              j++;
          }else{
              i= i - j + 1;
              j=0;
          }
      }

      if(j == s2.length() ){
          return i-j;
      }else{
          return -1;
      }

    }

}
