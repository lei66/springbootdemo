package com.example.springbootdemo;

import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));

    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        byte[][] useFlag;

        char[] words = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == words[0]) {
                    useFlag = new byte[m][n];
                    boolean b = dfs(i, j, board, useFlag, words, 0);
                    if (b) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(int x, int y, char[][] board, byte[][] useFlag, char[] words, int wordIndex) {
        int m = board.length;
        int n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        // 走过的路径设置直接返回false
        if (useFlag[x][y] == 1) {
            return false;
        }
        if (board[x][y] == words[wordIndex]) {
            useFlag[x][y] = 1;
            if (wordIndex == (words.length - 1)) {
                return true;
            }
            boolean bb = dfs(x + 1, y, board, useFlag, words, wordIndex + 1) ||
                    dfs(x - 1, y, board, useFlag, words, wordIndex + 1) ||
                    dfs(x, y + 1, board, useFlag, words, wordIndex + 1) ||
                    dfs(x, y - 1, board, useFlag, words, wordIndex + 1);
            useFlag[x][y] = 0;
            return bb;
        }
        
        return false;
    }
}
