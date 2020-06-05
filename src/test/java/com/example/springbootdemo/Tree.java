package com.example.springbootdemo;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {



    public static TreeNode createTree() {
        /**
         *     1
         *   2   3
         *  4
         *    5
         *
         *    45213
         */
        TreeNode header = new TreeNode();
        header.val = 5;
        TreeNode node1 = new TreeNode();
        node1.val = 3;
        TreeNode node2 = new TreeNode();
        node2.val = 6;
        TreeNode node3 = new TreeNode();
        node3.val = 1;
        TreeNode node4 = new TreeNode();
        node4.val = 2;

        header.left = node1;
        header.right = node2;
        node1.left = node3;
        node3.right = node4;

        return header;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        TreeNode header = createTree();
        System.out.println(isValidBST(header));
    }

    // 判断二叉树是否对称
    public static boolean checkSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }
        return left.val == right.val && checkSymmetry(left.left, right.right)
                && checkSymmetry(left.right, right.left);
    }


    // 二叉树的先序遍历
    public static void beforeLoop1(TreeNode header) {
        if (header == null) {
            return;
        }
        System.out.println(header.val);
        beforeLoop1(header.left);
        beforeLoop1(header.right);
    }

    // 二叉树先序遍历（非递归）
    public static void beforeLoop2(TreeNode header) {
        Stack stack = new Stack();

        stack.push(header);
        while (!stack.empty()) {

            TreeNode node = (TreeNode) stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }

    }

    // 二叉树中序遍历
    public static void cLoop1(TreeNode header) {
        if (header == null) {
            return;
        }

        cLoop1(header.left);
        System.out.println(header.val);
        cLoop1(header.right);
    }

    // 二叉树中序遍历（非递归）
    public static List<Integer> cLoop2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.empty()) {

            TreeNode node = (TreeNode) stack.peek();
            if (pre == null && node.left != null) {
                stack.push(node.left);
            } else {
                stack.pop();
                System.out.println(node.val);
                list.add(node.val);
                pre = node;
                if (node.right != null) {
                    stack.push(node.right);
                    pre = null;
                }
            }
        }
        return list;
    }

    // 后序遍历
    public static void afterLoop(TreeNode header) {

        if (header == null)
            return;

        afterLoop(header.left);
        afterLoop(header.right);
    }

    // 后序遍历（非递归）
    public static void afterLoop1(TreeNode header) {
        Stack stack = new Stack();
        stack.push(header);

        TreeNode pre = null;
        while(!stack.isEmpty()) {

            TreeNode node = (TreeNode) stack.peek();
            if ((node.left == null && node.right == null) || (pre != null && (pre == node.left || pre == node.right))) {
                stack.pop();
                pre = node;
                System.out.println(node.val);
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }


    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(root);
        TreeNode pre = null;

        while (!stack.isEmpty()) {
            TreeNode cur = (TreeNode) stack.peek();
            if (pre == null && cur.left != null) {
                stack.push(cur.left);
            } else {
                stack.pop();
                list.add(cur.val);
                pre = cur;
                if (cur.right != null) {
                    stack.push(cur.right);
                    pre = null;
                }
            }
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
