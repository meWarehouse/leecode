package com.at.jz;

/**
 * @author zero
 * @create 2021-05-18 15:53
 */
public class JZ7 {
    public int Fibonacci(int n) {

        if(n ==0 || n==1) return n;

        return Fibonacci(n-1) + Fibonacci(n-2);


    }


    public int Fibonacci1(int n) {

        if(n <= 0 ) return 0;

        if(n == 1) return 1;

        int curr = 1;
        int pre = 0;


        n = n-2;

        while (n-- >= 0){
            curr = curr + pre;
            pre = curr - pre;
        }


        return curr;

    }



}
