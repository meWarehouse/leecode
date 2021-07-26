package lc;



import com.at.lc.ListNode;

import java.util.LinkedList;

/**
 * @author zero
 * @create 2021-06-25 16:33
 */
public class lc_24 {
     /*
        24. 两两交换链表中的节点
            https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     */

    public ListNode swapPairs_1(ListNode head) {

        //缓存

        if (head == null || head.next == null) return head;

        LinkedList<ListNode> l1 = new LinkedList<>();
        LinkedList<ListNode> l2 = new LinkedList<>();

        int i = 1;

        while (head != null) {
            if (i % 2 == 1) {
                l1.add(head);
            } else {
                l2.add(head);
            }
            i++;
            head = head.next;
        }

        ListNode h = new ListNode();
        ListNode c = h;

        while (!l1.isEmpty() && !l2.isEmpty()) {
            c.next = l2.pollFirst();
            c.next.next = l1.pollFirst();
            c = c.next.next;
        }


        c.next = i % 2 == 0 ? l1.pollFirst() : l2.pollFirst();


        return h.next;


    }

    public ListNode swapPairs_2(ListNode head) {

        //指针
        if (head == null || head.next == null) return head;

        ListNode p = head;
        ListNode n = head.next;
        ListNode c = head.next.next;

        //只有两个节点
        if (c == null) {
            n.next = p;
            p.next = c;
            return n;
        }

        //三个以上的节点
        ListNode h = head.next;

        while (n != null && c != null) {

            p.next = c.next;
            n.next = p;

            if (c.next == null) {
                c.next = n;
                p.next = c;
                c.next = null;
                break;
            }
            if (c.next.next == null) {
                p.next.next = c;
                c.next = null;
                break;
            }
            p = c;
            n = p.next;

            c = n.next;

        }

        return h;


    }


    public ListNode swapPairs(ListNode head){

        if(head == null || head.next == null) return  head;

        ListNode n = head.next;

        head.next = swapPairs(n.next);

        n.next = head;

        return head;

    }
}
