package com.at;


import com.sun.org.apache.regexp.internal.RE;

import javax.management.NotificationEmitter;
import javax.xml.stream.FactoryConfigurationError;
import java.lang.annotation.Target;
import java.net.Inet4Address;
import java.security.cert.TrustAnchor;
import java.util.*;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {


//        new Main2().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});

        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);

        List<List<Integer>> r = new ArrayList<>();
        r.add(l1);
        r.add(l2);
        r.add(l3);
        r.add(l4);

//        new Main2().minimumTotal(r);

    }


    class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public int preVal = Integer.MIN_VALUE;

    public boolean isCBT(Node head) {




    }


}
