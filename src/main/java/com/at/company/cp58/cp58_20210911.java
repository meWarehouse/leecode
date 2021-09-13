package com.at.company.cp58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @create 2021-09-11
 */
public class cp58_20210911 {

    /*
          58 笔试
          20210911
     */

    public int[] threeSumClosest(int[] A, int T) {
        // write code here

        //找出 A 中的一个三元数组 其和 最接近 T

        Arrays.sort(A);


        return null;


    }


    //AQ
    public int[] find (int[] arg) {
        // write code here

        if(arg.length == 1) return arg;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arg) {
            hashMap.put(i,hashMap.getOrDefault(i, 0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arg.length; i++) {
            if(hashMap.get(arg[i]) == 1){
                list.add(arg[i]);
            }
        }

        int[] tmp = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i);
        }

        return tmp;

    }



    //AQ
    public int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
        // write code here

        if(Array == null || arrayLen == 0 || subArrayLen < 1) return new int[]{0,0};

        if(subArrayLen >= arrayLen){
            int max = 0;
            for (int i : Array) {
                max+=i;
            }
            return new int[]{0,max};
        }


        // ==================================


        int max = 0;
        for (int i = 0; i < subArrayLen; i++) {
            max+=Array[i];
        }

        int s = 0, e = subArrayLen - 1;
        int tmp = max;
        int index = 0;
        boolean flag = true;
        while (e+1 < arrayLen){

            tmp = tmp+Array[e+1] - Array[e+1-subArrayLen];

            if(tmp > max){
                max = tmp;
                index = e + 1 - subArrayLen+1;
            }

            e+=1;

        }


        return new int[]{index,max};

    }



}
