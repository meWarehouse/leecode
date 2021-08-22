package com.at.leecode_1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AL_2021_1 {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(reader.readLine());

        while (t-->0){

            int n = Integer.parseInt(reader.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();

            int[] arrx = new int[n];
            int[] arry = new int[n];

            String[] x = reader.readLine().split(" ");

            String[] y = reader.readLine().split(" ");

            for (int i = 0; i < x.length; i++) {

                arrx[i] = Integer.parseInt(x[i]);
                arry[i] = Integer.parseInt(y[i]);

            }

            int N = 0;

            for (int i = 0; i < n-1; i++) {

                for (int j = i+1; j < n; j++) {
                    if(arrx[i] > arrx[j] && arry[i] > arry[j]){
                      N=N+1;
                    }else if(arrx[i] < arrx[j] && arry[i] < arry[j]){
                        N=N+1;
                    }
                }

            }

            System.out.println(N);




        }


    }

}
