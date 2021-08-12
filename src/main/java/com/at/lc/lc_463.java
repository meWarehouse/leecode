package com.at.lc;

/**
 * @create 2021-08-12
 */
public class lc_463 {

    /*

            463. 岛屿的周长

                https://leetcode-cn.com/problems/island-perimeter/submissions/

     */


    public int islandPerimeter(int[][] grid) {

        if (grid == null) return 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return process(grid, i, j);
                }
            }
        }

        return 1;

    }

    public int process(int[][] grid, int r, int c) {

        //边界 +1
        if (!inArea(grid, r, c)) return 1;

        //海洋 +1
        if (grid[r][c] == 0) return 1;

        //陆地 +0
        if (grid[r][c] == 2) return 0;

        grid[r][c] = 2;

        return process(grid, r - 1, c)
                + process(grid, r + 1, c)
                + process(grid, r, c - 1)
                + process(grid, r, c + 1);


    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }


}
