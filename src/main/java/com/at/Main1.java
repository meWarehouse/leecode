package com.at;


import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.FpUtils;

import javax.jnlp.IntegrationService;
import javax.xml.stream.FactoryConfigurationError;
import java.beans.EventHandler;
import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zero
 * @create 2021-06-10 18:47
 */
public class Main1 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 0, 9, 4, 7, 1, -3, 10};


        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(0, 2);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0, 3);
        l2.add(1, 4);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0, 6);
        l3.add(1, 5);
        l3.add(2, 7);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(0, 4);
        l4.add(1, 1);
        l4.add(2, 8);
        l4.add(3, 3);

        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);



        new Main1().maxProduct(new int[]{-5,6,2,7,-1});


    }





}
