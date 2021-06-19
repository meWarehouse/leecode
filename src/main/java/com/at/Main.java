package com.at;


import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.net.SocketImpl;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

//        int[] ints = {3, 5, 7, 1, 0, 9, 4, 2, 6, 8};
//
//
//        System.out.println(new Main().PrintMinNumber(new int[]{3,32,321}));


        System.out.println(new Main().majorityElement(new int[]{2,2,1,1,1,1,2,2}));


    }

    public int majorityElement(int[] nums) {

       int mode = nums[0];
       int vote = 0;

        for (int num : nums) {
            if(vote == 0){
                mode = num;
            }

            if(mode == num){
                vote++;
            }else {
                vote--;
            }
        }

        return mode;
    }

    public String PrintMinNumber(int [] numbers) {

        if(numbers == null || numbers.length < 1) return "";

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                Integer a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                Integer b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if(a > b){
                    int t = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = t;
                }
            }
        }



        StringBuilder res = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            res.append(numbers[i]);
        }

        return res.toString();

    }


    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public  void quickSort(int[] arr, int left, int right){

        int l = left,r = right;
        int mid = arr[(l + r) / 2];

        while (l < r){

            while (arr[l] < mid){
                l++;
            }

            while (arr[r] > mid){
                r--;
            }

            if(l >= r) break;

            swap(arr,l,r);

            if(arr[l] == mid){
                r--;
            }

            if(arr[r] == mid){
                l++;
            }

        }

        if(l == r){
            l++;
            r--;
        }

        if(l < right){
            quickSort(arr,l,right);
        }

        if(left < r){
            quickSort(arr,left,r);
        }

    }

    public void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }

    }

    public void insertSort(int arr[]){

        for (int i = 1; i < arr.length; i++) {

            int pre = i;
            while (pre >= 1 && arr[pre] < arr[pre-1]){
                swap(arr,pre,pre-1);
                pre--;
            }

        }

    }





    public void swap(int arr[], int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main1(String[] args) {

        int testTime = 5000;
        int maxSize = 100;
        int maxValue = 100;

        boolean success = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxSize);
            int[] arr2 = copyArray(arr1);



        }


    }

    private static int[] copyArray(int[] arr1) {
        return new int[0];
    }

    private static int[] generateRandomArray(int maxSize, int maxSize1) {
        return new int[0];
    }




}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
