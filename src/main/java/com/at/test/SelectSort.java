package com.at.test;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, -1, 35, 4, 119, 1};


        System.out.println(Arrays.toString(new SelectSort().selectSort(arr)));

    }


    public int[] selectSort(int[] arr) {

        /*
         *
         * 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
         * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
         * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
         * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
         * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，总共通过n-1次，
         * 得到一个按排序码从小到大排列的有序序列
         */


        //选择排序的时间复杂度  O(n^2)

//		int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            int minVal = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
//				count++;
                if (minVal < arr[j]) {// > 从小到大    < 从大到小
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minVal;
            }

//			System.out.println("第"+(i +1)+"轮循环的结果："+Arrays.toString(arr));

        }
        return arr;

    }


}
