package com.at.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));


        StringBuffer str = new StringBuffer(sc.readLine().toLowerCase());

        int q = Integer.parseInt(sc.readLine());

        while (q-- != 0){
            String[] split = sc.readLine().split(" ");

            int l = Integer.parseInt(split[0]);
            int r = Integer.parseInt(split[1]);
            int k = Integer.parseInt(split[2]);


            for (int i = l-1; i < r-1; i++) {

                char c = ' ';
                if(str.charAt(i) >= 102){
                   c =  (char) (97 + k-1);
                }else{
                    c =(char) (str.charAt(i) + k);
                }

                str.setCharAt(i,c);
            }


        }

        System.out.println(str.toString());


    }
}

    /*
     Scanner sc1 = new Scanner(System.in);

        int num = Integer.parseInt(sc.readLine());

        while (num-- != 0){
            int n = sc1.nextInt();
                    //Integer.parseInt(sc.readLine());


            String[] split = sc.readLine().split(" ");
            int[] arr = new int[n+1];
            arr[0] = 0;
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(split[i-1]);
            }

            int x = 0;
            int sum = 0;
            int[] a = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                a[i] = arr[i] - i;
                sum+=a[i];
                if(a[i] == 0){
                    x++;
                }
            }

            if(sum != 0){
                System.out.println(-1);
                continue;
            }
            if(x == arr.length){
                System.out.println(0);
                continue;
            }

            int[] res = new int[3];


            int max = 0;
            for (int i = 0; i < a.length; i++) {

                if(Math.abs(a[i]) > max ){
                    max = Math.abs(a[i]);
                }

                if(a[i] != 0){
                    if(res[0] == 0){
                        res[0] = i;
                    }
                    res[1] = i;
                }

            }

            res[2] = max;

            for (int i = 0; i < res.length; i++) {
                if(i ==res.length-1){
                    System.out.printf("%d" , res[i]);
                }else{

                    System.out.printf("%d " , res[i]);
                }
            }


     */

//5
//5
//1 3 4 2 5
//5
//1 4 2 3 5
//5
//2 3 4 5 1
//5
//5 1 3 2 4
//5
//1 2 3 4 5
//



/*
int n = sc.nextInt();
        int c = sc.nextInt();

        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        if(n<0 || n> 26) System.out.println(" ");
        if(c < 1 || c > 10000) System.out.println(" ");

        while (n != 0){
            int num = sc.nextInt();
            int da = num / c;
            int p = num % c;
            if(p == 0){
                char c1 = chars[da-1];
                System.out.println(c1+" "+c);
            }else{
                char c1 = chars[da];
                System.out.println(c1+" "+p);
            }

        }

 */
