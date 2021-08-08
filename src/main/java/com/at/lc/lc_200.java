package com.at.lc;

/**
 * @create 2021-08-08
 */
public class lc_200 {

    /*
        200. 岛屿数量

        https://leetcode-cn.com/problems/number-of-islands/

        题解 https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/


     */

    public int numIslands(char[][] grid) {

        if (grid == null) return 0;

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    process(grid, i, j);
                }
            }
        }

        return res;

    }

    public void process(char[][] grid, int r, int c) {

        //判断点是否在网格内
        if (!inArea(grid, r, c)) return;

        //判断是否是 陆地
        if (grid[r][c] != '1') return;

        //标记遍历过的 点
        grid[r][c] = '2';

        //上 -> 右 -> 下 -> 左
        process(grid, r - 1, c);

        process(grid, r, c + 1);

        process(grid, r + 1, c);

        process(grid, r, c - 1);


    }


    public boolean inArea(char[][] grid, int r, int c) {

        return r >= 0 && r < grid.length
                && c >= 0 && c < grid[0].length;

    }


}
