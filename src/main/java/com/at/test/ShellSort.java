package com.at.test;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        System.out.println(Arrays.toString(new ShellSort().shellSort(arr)));

    }


    public int[] shellSort(int arr[]){

        for (int i = arr.length/2; i >0 ; i=i/2) {
            //步长及分组 i/2
            for (int j = i; j < arr.length; j++) {

                int insertVal = arr[j];
                int insertIndex = j-1;

                while (insertIndex >= 0 && arr[insertIndex] > insertVal){
                    arr[insertIndex+1] = arr[insertIndex];
                    insertIndex--;
                }

                if(insertIndex != j-1){
                    arr[insertIndex+1] = insertVal;
                }

            }
        }


        return arr;

    }


}
