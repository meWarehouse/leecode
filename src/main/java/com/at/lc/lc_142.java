package lc;


import com.at.lc.ListNode;

import java.util.HashSet;

/**
 * @author zero
 * @create 2021-06-25 13:57
 */
public class lc_142 {

    /*
        142. 环形链表 II
            https://leetcode-cn.com/problems/linked-list-cycle-ii/
     */
    public ListNode detectCycle_1(ListNode head) {

        //缓存

        if (head == null || head.next == null) return null;

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {

            if (set.contains(head)) return head;

            set.add(head);
            head = head.next;
        }

        return null;


    }

    public ListNode detectCycle(ListNode head) {

        //快慢指针
        if (head == null || head.next == null) return null;

        ListNode f = head.next;
        ListNode s = head;

        while (f != s) {
            if (f == null || f.next == null) return null;
            f = f.next.next;
            s = s.next;
        }

        //s == f
        f = head;
        while (f != s.next) {
            f = f.next;
            s = s.next;
        }

        return f;


    }

}
