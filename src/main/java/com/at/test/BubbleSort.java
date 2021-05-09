package com.at.test;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = { 3, 9, -1, 10, -2 };

        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(arr)));
    }


    public int[] bubbleSort(int[] arr){

        if(arr == null || arr.length == 0) return null;

        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    flag=true;
                    int t = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }

            }
            if(!flag) break;
        }


        return arr;
    }


}
