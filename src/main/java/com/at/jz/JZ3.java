package com.at.jz;

import com.at.Main;

import java.util.ArrayList;

/**
 * @author zero
 * @create 2021-05-13 18:40
 */
public class JZ3 {
//    https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035

    public static void main(String[] args) {

        ListNode listNode = new ListNode(67, new ListNode(0, new ListNode(24, new ListNode(58, null))));


    }


    /**
     *    public class ListNode {
     *        int val;
     *        ListNode next = null;
     *
     *        ListNode(int val) {
     *            this.val = val;
     *        }
     *    }
     *
     */


    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if(listNode != null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }

        return list;

    }



    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {


        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp = listNode;

        while (temp != null){
            list.add(0,temp.val);
            temp = temp.next;
        }

        return list;

    }


}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
