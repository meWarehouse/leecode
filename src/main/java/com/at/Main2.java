package com.at;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {

        Node n1 = new Node(-1);
//        Node n2 = new Node(2);
//        n1.next = n2;
//        n1.random = n2;
//        n2.random = n2;
//        n2.next = null;
        n1.random = null;

        new Main2().copyRandomList(n1);


    }

    public Node copyRandomList(Node head) {

        if(head == null)  return  null;

        Node curr = head;
        while (curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        while (curr != null){
            Node node = curr.next;
            node.random = curr.random == null ? null : curr.random.next;
            curr = curr.next.next;
        }


        curr = head.next;
        Node pre = head,res = head.next;

        while (curr.next != null){
            pre.next = pre.next.next;
            curr.next = curr.next.next;
            pre = pre.next;
            curr = curr.next;
        }
        pre.next = null;

        return res;


    }




        public Node copyRandomList1(Node head) {

        Node curr = head;

        while (curr != null){

            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;

            curr = curr.next.next;

        }

        curr = head;

        while (curr != null && curr.next != null){

            curr.next.random = curr.random == null ? null : curr.random.next;

            curr = curr.next.next;

        }


        curr = head.next;
        Node copyHead = curr;

        while (curr != null && curr.next != null){
            curr.next = curr.next.next;
            curr = curr.next;
        }


        return copyHead;



    }



}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}




