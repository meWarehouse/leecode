package com.at.leecode_1;

public class NC78 {

    /*
        题目描述
            输入一个链表，反转链表后，输出新链表的表头。
            示例1
            输入
            复制
            {1,2,3}
            返回值
            复制
            {3,2,1}
     */
    public static void main(String[] args) {

    }

    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode h = new ListNode(0);

        h.next = head;

        while (head.next != null) {
            ListNode t = head.next;
            head.next = head.next.next;
            t.next = h.next;
            h.next = t;
        }


        return h.next;

    }







}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
