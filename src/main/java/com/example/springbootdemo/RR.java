package com.example.springbootdemo;


import java.util.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        char[] chars = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.get(c) == null) {
                map.put((int)c, 1);
            } else {
                int a = map.get((int)c);
                map.put((int)c, ++a);
            }
        }
        int i = 0;
        for (int k : map.keySet()) {
            int v = map.get(k);
            if (v % 2 == 1) {
                i++;
            }
        }
        if (i == 0) {
            i = i + 1;
        }
        System.out.println(i);
    }

    public void dfs(int[][] grid, int x, int y, int sum, int[] max) {
        int l1 = grid.length;
        int l2 = grid[0].length;
        if (x < 0 || x >= l1)
            return;
        if (y < 0 || y >= l2)
            return;

        sum = sum + grid[x][y];
        if (x == l1 - 1 && y == l2 - 1) {
             if (sum > max[0])
                 max[0] = sum;
             return;
        }
        dfs(grid, x + 1, y, sum, max);
        dfs(grid, x, y + 1, sum, max);
    }

    public static boolean isDou(String str) {
        int len = str.length() - 1;
        if (len % 2 == 0) {
            return false;
        }
        int mid = len / 2 + 1;
        String str1 = str.substring(0, mid);
        String str2 = str.substring(mid, len + 1);
        return str1.equals(str2);

    }

    public int nthUglyNumber(int n) {

        int x = 1;
        int y = 1;
        int z = 1;

        double s = 0;
        int i = 1;
        while (i < n) {
            s = Math.min(Math.pow(2, x), (Math.min(Math.pow(3, y), Math.pow(5, z))));
            if (s == Math.pow(2, x)) {
                x++;
            } else if (s == Math.pow(3, y)) {
                y++;
            } else if (s == Math.pow(5, z)) {
                z++;
            }
            i++;
        }
        return (int) s;
    }


    public HashSet<String> permutation(HashSet<String> ss, char ch) {
        HashSet<String> res = new HashSet<>();
        int i = 0;
        for (String s : ss) {
            for (int n = 0; n <= s.length(); n++) {
                String ns = s.substring(0, n) + ch + s.substring(n, s.length());
                res.add(ns);
            }
        }
        return res;
    }


    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        List<Node> list = new ArrayList<>();
        List<Node> oldList = new ArrayList<>();
        Map<Node, Integer> map = new HashMap<>();
        int i = 0;
        while (node != null) {
            Node newNode = new Node(node.val);
            list.add(newNode);
            oldList.add(node);
            map.put(node, i);
            i++;
            node = node.next;

        }

        for (int n = 0; n < list.size(); n++) {
            if (n != list.size() - 1) {
                list.get(n).next = list.get(n + 1);
            }
            if (oldList.get(n).random == null) {
                list.get(n).random = null;
            } else {
                list.get(n).random = list.get(map.get(oldList.get(n).random));
            }

        }
        return list.get(0);
    }
}
