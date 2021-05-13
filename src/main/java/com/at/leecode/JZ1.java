package com.at.leecode;

/**
 * @author zero
 * @create 2021-05-13 16:16
 */
public class JZ1 {

    public boolean Find(int target, int[][] array) {

        if (array == null || array.length == 0) return false;

        System.out.println(array[array.length - 1][array[array.length - 1].length - 1]);

        int x = 0;
        int y = array[0].length - 1;

        while (x < array.length && y >= 0) {

            if (target == array[x][y]) {
                return true;
            }

            if (target > array[x][y]) {
                //向下
                x += 1;
            } else if (target < array[x][y]) {
                //向左
                y -= 1;
            }

        }

        return false;


    }

    public boolean Find1(int target, int[][] array) {

        if (array == null || array.length == 0) return false;


//        if(target < array[0][0] || target > array[array.length-1][array[array.length-1].length-1]) return false;


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                if(target == array[i][j]) return true;

            }
        }

        return false;


    }

}
