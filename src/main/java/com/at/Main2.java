package com.at;


import sun.misc.LRUCache;

import java.util.*;

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
                return o2 - o1;
            }
        });

        queue.add(12);
        queue.add(22);
        queue.add(1);

        System.out.println(queue.peek());

    }


    public boolean isNumber(String s) {

        if(s == null | s.length() == 0) return false;

        char[] charArray = s.toCharArray();

        boolean num = false,dot = false,e = false;

        for (int i = 0; i < charArray.length; i++) {

            if(charArray[i] >= '0' && charArray[i] <= '9'){
                num = true;
            }else if(charArray[i] == '.'){

                if(dot || e) return false;

                dot = true;

            }else if(charArray[i] == 'e' || charArray[i] == 'E'){

                if(e || !num) return false;

                e = true;

                num = false;

            }else if(charArray[i] == '-' || charArray[i] == '+'){

                if(i != 0 && charArray[i-1] != 'e' && charArray[i-1] != 'E' ) return false;

            }else {
                return false;
            }

        }

        return num;

    }


}


