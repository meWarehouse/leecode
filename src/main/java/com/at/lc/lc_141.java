package com.at.lc;



import java.util.HashSet;

/**
 * @author zero
 * @create 2021-06-25 13:29
 */
public class lc_141 {
     /*
        141. 环形链表
            https://leetcode-cn.com/problems/linked-list-cycle/

     */

    public boolean hasCycle_1(ListNode head) {

        //缓存
        if (head == null || head.next == null) return false;

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;

    }

    public boolean hasCycle(ListNode head) {
        //快慢指针

        if (head == null || head.next == null) return false;

        ListNode f = head.next;
        ListNode s = head;

        while (s != f) {
            if (f == null || f.next == null) return false;
            s = s.next;
            f = f.next.next;
        }


        return true;


    }
}
