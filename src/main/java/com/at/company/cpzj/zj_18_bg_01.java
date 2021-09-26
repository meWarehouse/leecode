package com.at.company.cpzj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @create 2021-09-25
 */
public class zj_18_bg_01 {

    /*

        https://www.nowcoder.com/questionTerminal/e35d8c3404194cd69a88da1667ef8081?f=discussion

        AC 0.8


     */

    static class Struct {
        int x;
        int y;

        public Struct(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        Struct[] structs = new Struct[N];

        for (int i = 0; i < N; i++) {

            String[] splits = reader.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);

            structs[i] = new Struct(x, y);

        }


        Arrays.sort(structs, new Comparator<Struct>() {
            @Override
            public int compare(Struct a, Struct b) {
                //y 递减 x 递增
                return a.y == b.y ? a.x - b.x : b.y - a.y;
            }
        });

        int maxTX = structs[0].x;
        System.out.println(structs[0].x + " " + structs[0].y);

        for (int i = 1; i < structs.length; i++) {

            int tX = structs[i].x;
            if(tX > maxTX){
                maxTX = tX;
                System.out.println(structs[i].x + " " + structs[i].y);
            }

        }




    }

    public static void main1(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String[] splits = reader.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);

            arr[i] = x;
            map.put(x, y);

        }


        Arrays.sort(arr);
        int maxY = map.get(arr[arr.length - 1]);
        Stack<Integer[][]> queue = new Stack<>();
        queue.add(new Integer[][]{{arr[arr.length - 1], maxY}});

        for (int i = arr.length - 2; i >= 0; i--) {


            Integer tY = map.get(arr[i]);
            if (tY > maxY) {
                maxY = tY;
                queue.add(new Integer[][]{{arr[i], maxY}});
            }


        }

        while (!queue.isEmpty()) {
            Integer[][] poll = queue.pop();
            System.out.println(poll[0][0] + " " + poll[0][1]);
        }


    }


}
