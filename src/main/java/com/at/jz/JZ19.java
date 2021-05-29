package com.at.jz;

import java.util.ArrayList;

/**
 * @author zero
 * @create 2021-05-27 21:30
 */
public class JZ19 {


    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int up = 0, left = 0, right = matrix[0].length-1, down = matrix.length-1;


        while (true){

            for (int i = left; i <=right ; i++) {
                list.add(matrix[up][i]);
            }

            if(++up > down) break;

            for (int i = up; i <= down ; i++) {
                list.add(matrix[i][right]);
            }

            if(--right < left) break;

            for (int i = right; i >= left ; i--) {
                list.add(matrix[down][i]);
            }

            if(--down < up) break;

            for (int i = down; i >= up ; i--) {
                list.add(matrix[i][left]);
            }

            if(++left > right) break;

        }

        return list;


    }

}
