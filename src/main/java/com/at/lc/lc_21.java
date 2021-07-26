package lc;


import com.at.lc.ListNode;

/**
 * @author zero
 * @create 2021-06-25 14:28
 */
public class lc_21 {
     /*
        21. 合并两个有序链表
            https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */

    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;

        if (l1 == null && l2 != null) return l2;

        if (l1 != null && l2 == null) return l1;


        ListNode head = new ListNode();
        ListNode curr = head;

        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;

        }

        while (l1 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
        }

        while (l2 != null) {
            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }


        return head.next;


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if (l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val > l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }


    }

}
