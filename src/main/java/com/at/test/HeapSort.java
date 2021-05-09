package com.at.test;

import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {1, 9, 8, 3, 0, -1, 2, 4, 7};

        System.out.println(Arrays.toString(new HeapSort().heapSort(arr)));

    }

    public int[] heapSort(int[] arr) {

        //将待排序序列构造成一个大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heap(arr, i, arr.length);
        }

        int temp = 0;
        //交换 此时根节点为最大的节点 将其与末尾元素进行交换，让末尾为最大值
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;

            //继续调整
            heap(arr, 0, j);
        }

        return arr;
    }

    public void heap(int[] arr, int i, int length) {

        int temp = arr[i];

        //从树的最后一个非叶子节点(arr.length/2-1) 开始调整从下往上
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

            //如果当前节点的右节点大于左节点 则让k指向右节点
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }

            //叶子节点大于非叶子节点，叶子节点上移，成为非叶子节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }

        }

        arr[i] = temp;

    }


}
