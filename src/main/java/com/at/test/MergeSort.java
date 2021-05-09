package com.at.test;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2,0,9,34,-29};
//
//        int[] temp = new int[arr.length];
//
//        new MergeSort().mergeSort(arr,0,arr.length-1,temp);


        int arr1[] = {1,3,5,6,9};
        int arr2[] = {2,4,6,8,10};

        new MergeSort().doubleMerge(arr1,arr2);


    }

    public void doubleMerge(int[] arr1,int[] arr2){

        int[] temp = new int[arr1.length + arr2.length];

        int a = 0,b=0,t=0;

        while (a < arr1.length && b < arr2.length){
            if(arr1[a] > arr2[b]){
                temp[t] = arr2[b];
                t++;
                b++;
            }else {
                temp[t] = arr1[a];
                a++;
                t++;
            }
        }

        while (a < arr1.length){
            temp[t] = arr1[a];
            t++;
            a++;
        }

        while (b < arr2.length){
            temp[t] = arr2[b];
            t++;
            b++;
        }

        System.out.println(Arrays.toString(temp));

    }


    public void mergeSort(int[] arr,int left,int right,int[] temp) {

        //分
        if(left < right){
            int mid = (left + right) / 2;

            mergeSort(arr,left,mid,temp);

            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);

        }


    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;//初始化 i 左边有序序列的初始索引
        int j = mid + 1;//初始化 j 右边有序序列的初始索引
        int t = 0;//指向 temp 数组的当前索引

        //第一步
        //先将左右两边(有序)的数据按照规则填充到 temp 数组  直到左右两边的有序序列有一边处理完毕
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                //左边小于右边的，将左边的填充到 temp 数组中 t,i 分别后移
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                //反之 左边大于右边的，将右边的填充到 temp 数组中 t,j 分别后移
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        //第二步
        //将剩余数据的一边的数据依次全部填充到temp中
        while(i <= mid) {//左边有剩余
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right) {//右边有剩余
            temp[t] = arr[j];
            t++;
            j++;
        }

        //第三步
        //将temp数组的元素拷贝到 arr 数组中     注意:并不是每次都拷贝所有

        t = 0;
        int tempLeft = left;

        /*
         * 第一次合并：tempLeft = 0,right = 1
         * 第二次合并：tempLeft = 2,right = 3
         * 第三次合并：tempLeft = 0,right = 3
         *
         * 第四次合并：tempLeft = 4,right = 5
         * 第四次合并：tempLeft = 6,right = 7
         * 第四次合并：tempLeft = 4,right = 7
         *
         * 第四次合并：tempLeft = 0,right = 7
         *
         */

        while(tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

        System.out.println(Arrays.toString(arr));
    }

}
