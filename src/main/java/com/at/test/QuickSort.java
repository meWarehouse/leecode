package com.at.test;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {

        int[] arr = {12, 32, 49, 68, 48, 28, 37, 18, 93, 61};

        System.out.println(Arrays.toString(new QuickSort().quickSort(arr, 0, arr.length - 1)));


    }

    public int[] quickSort(int[] arr, int left, int right) {

        //左右
        int l = left, r = right;

        //中轴值
        int pivot = arr[(left + right) / 2];


        while (l < r) {
            //在左边找一个比中轴值大的
            while (arr[l] < pivot) {
                l++;
            }
            //在右边找一个比中轴值小的
            while (arr[r] > pivot) {
                r--;
            }

            //如果l>=r 说明 pivot 的左右两边的值，已经按照左边全是小于 pivot 的值，右边全是大于等于 pivot 的值
            if (l >= r) {
                break;
            }

            //交换
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;

            //如果交换后左边等于中轴值则右边减1
            //        右边           左边加1
            if (arr[l] == pivot) r--;
            if (arr[r] == pivot) l++;

        }

        //如果l==r 需要l++ r-- 否则会存现溢出
        if (l == r) {
            l++;
            r--;
        }

        //如果left小于向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //如果right大于l向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }


        return arr;


    }


}
