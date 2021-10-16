package com.at.company.cpal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @create 2021-10-08
 */
public class AL2021_10_08 {

    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] split = reader.readLine().split(" ");
        int H = Integer.parseInt(split[0]);
        int W = Integer.parseInt(split[1]);
        int T = Integer.parseInt(split[2]);


        String[][] arr  = new String[H][W];

        for (int i = 0; i < H; i++) {
            String s = reader.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.substring(j,j+1);
            }
        }

        Struct[][] resArr = new Struct[H][W];
        resArr[0][0] = new Struct(0,0);
        for (int i = 0; i < H; i++) {
            if(arr[i][0].equals("#")){
                resArr[i][0] = new Struct(resArr[i-1][0].dian,resArr[i-1][0].jing+1);
            }else {
                resArr[i][0] = new Struct(resArr[i-1][0].dian+1,resArr[i-1][0].jing);
            }
        }

        for (int i = 0; i < W; i++) {
            if(arr[0][i].equals("#")){
                resArr[0][i] = new Struct(resArr[0][i-1].dian,resArr[0][i].jing+1);
            }else {
                resArr[0][i] = new Struct(resArr[0][i-1].dian+1,resArr[0][i].jing);
            }
        }


        for (int i = 1; i < H; i++) {
            for (int j = 1; j < W; j++) {

                Struct struct = resArr[i - 1][j].jing > resArr[i][j - 1].jing ? resArr[i][j - 1] : resArr[i - 1][j];

                if(arr[i][j].equals("#")){
                    resArr[i][j] = new Struct(struct.dian+1, struct.jing);
                }else {
                    resArr[i][j] = new Struct(struct.dian, struct.jing+1);
                }

            }
        }

        Struct struct = resArr[H - 1][W - 1];

        int i = (T - struct.dian) / struct.jing;

        System.out.println(i);


    }

    static class Struct{
        int dian;
        int jing;
        public Struct(){}
        public Struct(int a,int b){
            this.dian = a;
            this.jing = b;
        }
    }
}
