package com.at.lc;

/**
 * @author zero
 * @create 2021-06-19 20:19
 */
public class lc_26 {

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
