package com.at.lc;

import com.at.bean.ListNode;

import java.util.HashSet;

public class lc_817 {

    /*
        817. 链表组件
            https://leetcode-cn.com/problems/linked-list-components/
     */

    public int numComponents(com.at.bean.ListNode head, int[] nums) {

        int res = 0;

        if(head == null || nums == null || nums.length ==0) return res;

        HashSet<Integer> set = new HashSet<>();

        for (int elem : nums) {
            set.add(elem);
        }

        ListNode curr = head;

//        while (curr != null){
//
//            if(set.contains(curr.val)){
//                res +=1;
//                curr = curr.next;
//                while (curr != null && set.contains(curr.val)){
//                    curr = curr.next;
//                }
//
//            }else {
//                curr = curr.next;
//            }
//
//
//        }

        while (curr != null){
            if(set.contains(curr.val) && (curr.next == null || set.contains(curr.next.val))){
                res+=1;
            }
            curr = curr.next;
        }

        return res;


    }


}
