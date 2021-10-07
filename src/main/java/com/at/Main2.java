package com.at;


import com.at.bean.TreeNode;
import javafx.scene.chart.AxisBuilder;
import sun.reflect.generics.tree.Tree;

import javax.swing.plaf.ViewportUI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @author zero
 * @create 2021-07-04
 */
public class Main2 {

    public static void main(String[] args) {

        Deque<Integer> queue = new LinkedList<>();

        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);

        System.out.println(queue.getFirst());
        System.out.println(queue.getFirst());


    }


    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0) return 0;

        int min = prices[0];
        int maxP = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {

            if(min > prices[i]){
                min = prices[i];
            }

            if(prices[i] -  min > maxP){
                maxP = prices[i] - min;
            }


        }

        return maxP;

    }









}


