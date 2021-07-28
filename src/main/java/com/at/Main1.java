package com.at;


import com.at.bean.ListNode;
import com.at.test.BubbleSort;
import com.at.test.SelectSort;
import sun.java2d.opengl.WGLGraphicsConfig;

import java.util.*;

/**
 * @author zero
 * @create 2021-06-10 18:47
 */
public class Main1 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 0, 9, 4, 7, -3, 10};
//        int[] arr = {1,2,3,4,5,6,8,4,9,3,3,4,1};

        int[] a1 = {1, 7, 8, 3, 8, 7, 1};
        int[] a2 = {9, 5, 7, 3, 3, 7, 5, 9};

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(8);
        ListNode n8 = new ListNode(4);
        ListNode n9 = new ListNode(5);
        ListNode n10 = new ListNode(7);
        ListNode n11 = new ListNode(2);
        ListNode n12 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        n10.next = n11;
        n11.next = n12;


        // 1 -> 1
        // 1 -> 2 -> 3 -> 2 -> 1
        // 1 -> 2 -> 3 -> 3 -> 2 -> 1
//        ListNode node1 = new ListNode(1, new ListNode(1));
//        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
//        ListNode node3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));


        Main1 m = new Main1();

//
//        System.out.println(m.PalindromeLinked(node1));
//        System.out.println(m.PalindromeLinked(node2));
//        System.out.println(m.PalindromeLinked(node3));

        System.out.println(m.PalindromeLinked(n1));

    }


    //栈
    public boolean PalindromeLinked_1(ListNode head) {

        //栈

        if (head == null || head.next == null) return true;

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;

        while (curr != null) {
            stack.add(curr);
            curr = curr.next;
        }

        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }

        return true;

    }

    //快慢指针
    public boolean PalindromeLinked_2(ListNode head) {

        if (head == null || head.next == null) return true;


        ListNode right = head.next;
        ListNode curr = head;

        //走完后 right 恰好在中点位置
        while (curr.next != null && curr.next.next != null) {
            curr = curr.next.next;
            right = right.next;
        }

        Stack<ListNode> stack = new Stack<>();

        //将后 一半 的节点放入栈中
        while (right != null) {
            stack.push(right);
            right = right.next;
        }


        while (!stack.isEmpty()) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }


        return true;


    }

    //快慢指针 不用额外空间
    public boolean PalindromeLinked(ListNode head) {

        if (head == null || head.next == null) return true;

        // 1 -> 2 -> 7 -> 5 -> 4 -> 8 -> 8 ->  4 -> 5 -> 7 -> 2 -> 1

        ListNode n1 = head;
        ListNode n2 = head;

        // 快走一步慢走两步
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        // n1 -> mid(第一个8)    n2 -> end

        // 将 mid 后的链表反转
        n2 = n1.next;
        n1.next = null;
        ListNode n3 = null;

        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        // n1 现在为最后一个 1  1 -> 2 -> 7 -> 5 -> 4 -> 8 <- 8 <-  4 <- 5 <- 7 <- 2 <- 1
        n3 = n1;
        n2 = head;

        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next; //right to mid
            n2 = n2.next; //left to mid
        }

        //此时 n1 或 n2 为空
        //再次反转后半部分
        n1 = n3.next;
        n3.next = null;

        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }


}
