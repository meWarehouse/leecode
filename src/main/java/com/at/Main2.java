package com.at;


import com.at.bean.ListNode;
import com.at.test.HeapSort;
import javafx.scene.input.Mnemonic;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {


        new Main2().addTwoNumbers(new ListNode(9,new ListNode(9)),new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int num = 0,t=0;
        ListNode head = l1;

        while (l1 != null || l2 != null){

            if(l1 == null){
                t = num + l2.val;
                l1 = new ListNode(t%10);
                num = t /10;
                l2 = l2.next;
            }else if(l2 ==null){
                t = num + l1.val;
                l1.val = t%10;
                num = t /10;
            }else {
                t = num + l1.val + l2.val;
                l1.val = t%10;
                num = t/10;
                l2 = l2.next;

            }

            l1 = l1.next;

        }

        if(num != 0) l1.next = new ListNode(num);

        return head;

    }




}


