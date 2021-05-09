package com.at.leecode;

public class CN19 {

    public static void main(String[] args) {

        new CN19().maxsumofSubarray(new int[]{1,2,-99,5,-5});

    }

    public int maxsumofSubarray (int[] arr) {

        if(arr == null || arr.length == 0) return 0;

        int max = arr[0];
        int dpMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dpMax = Math.max(dpMax,dpMax + arr[i]);
            max = Math.max(dpMax,max);
            if(arr[i] + dpMax  <= 0 ){
                dpMax = 0;
            }

        }

        return max;

    }
    public int maxsumofSubarray1 (int[] arr) {

        if(arr == null || arr.length == 0) return 0;


        int m = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i],arr[i] + arr[i-1]);
            m = Math.max(m,arr[i]);
        }

        return m;

    }

}
