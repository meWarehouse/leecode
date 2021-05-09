package com.at.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        String[] params = line.split(" ");

        int a =Integer.parseInt(params[0]);
        int b =Integer.parseInt(params[1]);
        int c =Integer.parseInt(params[2]);

        int d =Integer.parseInt(params[3]);

        int e =Integer.parseInt(params[4]);
        int f =Integer.parseInt(params[5]);
        int g =Integer.parseInt(params[6]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //安efg价格降序
                return o2[1] - o1[1];
            }
        });

        queue.add(new int[]{a,e});
        queue.add(new int[]{b,f});
        queue.add(new int[]{c,g});

        long money = 0;
        while (!queue.isEmpty() && d > 0){
            int[] poll = queue.poll();

            money+=(long)Math.min(poll[0],d)*poll[1];

            d-=poll[0];

        }

        System.out.println(money);



    }
}
