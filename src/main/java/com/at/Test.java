package com.at;

/**
 * @author zero
 * @create 2021-06-21 23:20
 */
public class Test {

    public static void main(String[] args) {


        int[] arr = {1,2,3,4,5,5,1,2,4,0};

        new Test().test2(arr);

    }


    /*
        给定一个数组 其中只有一个数出现了奇数次 其他的都出现了偶数次
     */
    public int test1(int[] arr){

        int tmp = 0;

        for (int i : arr) {
            tmp = tmp ^ i;
        }

        return tmp;

    }

    /*
        给定一个数组 其中只有两个不同的数出现了奇数次 其他的都出现了偶数次
     */
    public void test2(int[] arr){

        int tmp = 0;

        for (int i : arr) {
            tmp = tmp ^ i;
        }

        //tmp = a ^ b 并且 ab 不相等
        int rightOne = tmp & (~tmp + 1);

        int onlyOne = 0;

        for (int i : arr) {
            if((i&rightOne) == 0){
                onlyOne^=i;
            }
        }

        System.out.println(onlyOne + " " + ( onlyOne^tmp));




    }




}
