package com.example.springbootdemo.web;

/**
 * Created by xielei on 2020/5/26
 */
public class Neww {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        obj.wait();
    }

    public static void heapSort(int[] arr) {
        int index = arr.length / 2 - 1;

        for (int i = index; i >= 0; i--) {
            sort(arr, i, arr.length - 1);
        }

        swap(arr, 0, arr.length - 1);
        for (int e = arr.length - 2; e > 0; e--) {
            sort(arr, 0, e);
            swap(arr, 0, e);
        }
    }
    public static void sort(int[] arr, int index, int end) {
        int left = index * 2 + 1;
        int maxInd = left;
        if (left > end)
            return;
        if (left < end && arr[left + 1] > arr[left])
            maxInd = left + 1;

        if (arr[index] >= arr[maxInd]) {
            return;
        } else {
            swap(arr, index, maxInd);
            sort(arr, maxInd, end);
        }
    }
    private static void swap(int[] arr, int j1, int j2) {
        int a = arr[j1];
        arr[j1] = arr[j2];
        arr[j2] = a;
    }
}
