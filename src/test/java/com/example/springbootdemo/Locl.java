package com.example.springbootdemo;

import sun.util.resources.cldr.xog.CalendarData_xog_UG;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Locl {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) throws Exception {

        Map<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i));
            map.remove("");
        }
        System.out.println(map.size());
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int i = 0;
        for (int n : inorder) {
            map.put(n, i);
            i++;
        }

        TreeNode head = new TreeNode(preorder[0]);
        create(0, preorder, head, map, 0, preorder.length - 1);

        return head;
    }

    public void create(int index, int[] preorder, TreeNode node,
                       HashMap<Integer, Integer> map, int low, int high) {
        if (map.get(preorder[index]) > low) {
            TreeNode left = new TreeNode(preorder[index + 1]);
            node.left = left;
            create(index+1, preorder, left, map, low, map.get(preorder[index]) - 1);
        }
        if (map.get(preorder[index]) < high) {
            int nextI = index + map.get(preorder[index]) - low + 1;
            TreeNode right = new TreeNode(preorder[nextI]);
            node.right = right;

            create(nextI, preorder, right, map, map.get(preorder[index]) + 1, high);
        }
    }

    public int power(int num, int i) {

        int s = 1;
        while (i > 0) {
            s = s * num;
            i--;
        }
        return s;
    }

    public void lock() throws Exception{

        synchronized (this) {
            System.out.println(1);
            this.wait(1000);
        }
    }
}
