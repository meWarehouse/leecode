package com.at.jz;



/**
 * @author zero
 * @create 2021-05-23 23:05
 */
public class JZ16 {

    public ListNode Merge(ListNode list1,ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val){
            list1.next = Merge(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }


    }

    public ListNode Merge1(ListNode list1,ListNode list2) {

        ListNode head = new ListNode(-1);

        ListNode h3 = head;


        while (list1 != null && list2 != null){

            if(list1.val > list2.val){
                h3.next = list2;
                list2 = list2.next;
            }else {
                h3.next = list1;
                list1 = list1.next;
            }

            h3 = h3.next;

        }

        while (list1 != null){
            h3.next = list1;
            list1 = list1.next;
            h3 = h3.next;
        }

        while (list2 != null){
            h3.next = list2;
            list2 = list2.next;
            h3 = h3.next;
        }



        return head.next;
    }

}
