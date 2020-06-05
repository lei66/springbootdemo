package com.example.springbootdemo;

import java.util.*;

public class Htest2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        //System.out.println(numIslands(arr));
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 标志是否已经使用
        int[][] use = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (use[i][j] == 0) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(i, j, use, grid);
                    }
                    use[i][j] = 1;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, int[][] use, char[][] grid) {
        int m = use.length;
        int n = use[0].length;
        if (i >= 0 && i < m && j >= 0 && j < n) {
            if (use[i][j] == 0) {
                use[i][j] = 1;
                if (grid[i][j] == '1') {
                    dfs(i - 1, j, use, grid);
                    dfs(i + 1, j, use, grid);
                    dfs(i, j + 1, use, grid);
                    dfs(i, j - 1, use, grid);
                }
            }
        }
    }

}
