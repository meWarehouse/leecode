package com.at.jz;

/**
 * @author zero
 * @create 2021-05-23 22:37
 */
public class JZ14 {
    public ListNode FindKthToTail (ListNode pHead, int k) {

        if (pHead == null || k <= 0) return null;

        ListNode i = pHead, j = pHead;

        while (i != null) {

            if (k != 0) {
                k--;
            } else {
                j = j.next;
            }
            i = i.next;
        }

        return k == 0 ? j : null;
    }


    public ListNode FindKthToTail1(ListNode pHead, int k) {
        // write code here
        if(pHead == null || k <=0 ) return null;

        int size = 0;
        ListNode h = pHead;
        while (h!=null){
            size++;
            h=h.next;
        }

        if(k > size) return null;

        ListNode res = pHead;

        for (int i = 0; i < size-k; i++) {

            res = res.next;

        }

        return res;
    }


}

//class ListNode {
//    int val;
//    ListNode next = null;
//
//    public ListNode(int val) {
//        this.val = val;
//    }
//}
