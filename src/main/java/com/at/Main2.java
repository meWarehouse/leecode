package com.at;


import sun.misc.LRUCache;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {

        int[] arr = {12, 32, 49, 68, 48, 28, 37, 18, 93, 61};

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        queue.add(12);
        queue.add(22);
        queue.add(1);

        System.out.println(queue.peek());

    }


}


