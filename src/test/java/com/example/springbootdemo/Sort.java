package com.example.springbootdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sort {

    public static void main(String[] args) {

    }

    public static void merger(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int mid = (len1 + len2 + 1) / 2;

        int mid1 = len1 / 2 - 1;
        int mid2 = mid - mid1 - 2;

        Lock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();


    }
}
