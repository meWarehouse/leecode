package com.at;



/**
 * @author zero
 * @create 2021-06-10 18:47
 */
public class Main1 {


    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(new Main1().removeDuplicates(arr));

    }

    /*
        26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

        在数组基础上修改不能使用额外的内存

        去除重复的数
        找到重复的数用后面不是重复的数将其覆盖掉

     */

    public int removeDuplicates(int[] nums) {

        int pre = 0;
        int next = 1;

        while (next < nums.length) {

            if (nums[pre] != nums[next]) {
                nums[++pre] = nums[next];
            }

            next++;

        }

        return pre + 1;

    }




}
