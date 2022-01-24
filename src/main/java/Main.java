import com.at.bean.ListNode;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @create 2022/1/17 8:54
 */
public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        queue.add(3);
        queue.add(0);
        queue.add(50);
        queue.add(-1);
        queue.add(9);

        System.out.println(queue.poll());


    }


    public void nextPermutation(int[] nums) {
        /**
         * 下一个排列
         *    1.从头到尾，找到第一个相邻的顺序对， i i+1 a[i]<a[i+1]
         *      - 如果不存在这样的顺序对。则这个串是递减的，这个串是最大的串，没有下一个排列，reverse 这个串
         *    2.从头到尾，找到下一个下标j 满足 i<j 且 a[i]<a[j], j 至少存在一个（i+1）
         *    3.交换 a[i],a[j]
         *    4.将 a[i+1] 到末尾的这段 reverse 一下
         *
         */

        if(nums == null || nums.length == 0) return;

        int n = nums.length;

        int i = n - 2; // a[i] < a[i+1]
        while (i >= 0 && nums[i] < nums[i+1]) i--;

        if(i == -1){
            //没有下一个排列
            reverse(nums,0);
            return;
        }

        int j = n-1;
        while (nums[j] <= nums[i]) j--;

        swap(nums,nums[j],nums[i]);

        reverse(nums,0 + i + 1);

    }

    public void reverse(int[] arr,int start){
        int l = start,r = arr.length - 1;
        while (l < r){
            swap(arr,l++,r--);
        }
    }

    public  void  swap(int[] arr,int i,int j){
        if(i != j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }




}
