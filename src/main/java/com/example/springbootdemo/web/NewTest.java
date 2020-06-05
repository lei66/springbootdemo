package com.example.springbootdemo.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NewTest {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        HashMap mapp = new HashMap();
        ReentrantLock lock = new ReentrantLock();
        Condition con = lock.newCondition();

        ApplicationContext context = new FileSystemXmlApplicationContext("");
        lock.lock();

        int[] nums = {3,30,34,5,9};
        System.out.println(minNumber(nums));
        //con.await();
    }

    public int[] singleNumbers(int[] nums) {
        int c = 0;
        for (int val : nums) {
            c = c ^ val;
        }
        int q = 1;
        while ((c & q) != q) {
            q <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int val : nums) {
            if ((val & q) == q)
                a = a ^ val;
            else
                b = b ^ val;
        }
        int[] arr = new int[2];
        arr[0] = a; arr[1] = b;
        return arr;
    }

    public static String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    // 数组中的逆序对
    public int reversePairs(int[] nums) {

        return 0;
    }



    public static void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int base = nums[end];
        int x = begin;
        int y = end;
        while (x < y) {
            while (x < y && !compareBig(base, nums[x])) {
                x++;
            }
            nums[y] = nums[x];
            while (x < y && compareBig(base, nums[y])) {
                y--;
            }
            nums[x] = nums[y];
        }
        nums[x] = base;
        quickSort(nums, begin, x - 1);
        quickSort(nums, x + 1, end);
    }

    public static boolean compareBig(int base, int y) {
        char[] chars1 = ("" + base + y).toCharArray();
        char[] chars2 = ("" + y + base).toCharArray();
        int i = 0;
        while (i < chars1.length) {
            if (chars2[i] > chars1[i])
                return true;
            if (chars2[i] < chars1[i])
                return false;

            i++;
        }
        return true;
    }
}
