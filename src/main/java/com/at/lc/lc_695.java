package com.at.lc;

/**
 * @create 2021-08-12
 */
public class lc_695 {

    /*
        岛屿的最大面积

        https://leetcode-cn.com/problems/max-area-of-island/submissions/
     */
    public int maxAreaOfIsland(int[][] grid) {

        if(grid == null) return 0;

        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    int process = process(grid, i, j);
                    max = Math.max(process,max);
                }
            }
        }

        return max;

    }


    public int process(int[][] grid, int r, int c) {

        if (!inArea(grid, r, c) || grid[r][c] != 1) return 0;

        grid[r][c] = 2;

        return 1 + process(grid, r-1, c)
                + process(grid, r+1, c)
                + process(grid, r, c-1)
                + process(grid, r, c+1);



    }

    public boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }


}
