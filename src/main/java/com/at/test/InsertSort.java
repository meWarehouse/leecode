package com.at.test;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, -1, 35, 4, 119, 1};

        System.out.println(Arrays.toString(new InsertSort().insertSort(arr)));

    }


    public int[] insertSort(int[] arr) {

        /*
         * 插入排序（Insertion Sorting）的基本思想是：
         * 把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
         * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较， 将它插入到有序表中的适当位置，使之成为新的有序表。
         */

        for (int i = 1; i < arr.length; i++) {

            // 需要插入的数据 或 需要排序的数
            int insertVal = arr[i];
            // 插入的数据的前一个数的索引 即要插入的元素与前面要比较的元素的索引
            int insertIndex = i - 1;

            /*
             * 1.insertIndex >= 0 保证在查找插入位置过程中下标不越界 2.insertVal < arr[insertIndex]
             * 待插入的位置的数大于要插入的数
             */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) { // < 从小到大 > 从大到小
                // 3.将待插入位置的数后移
                arr[insertIndex + 1] = arr[insertIndex];
                // 4.将索引向前移动 继续寻在
                insertIndex--;
            }

            // 当循环结束即 insertIndex 的后一个位置就为要插入的位置
            if (insertIndex != i - 1) {
                arr[++insertIndex] = insertVal;
            }

        }
        return arr;

    }
}
