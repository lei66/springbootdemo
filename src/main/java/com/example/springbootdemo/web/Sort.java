package com.example.springbootdemo.web;

import java.util.concurrent.ConcurrentHashMap;

public class Sort {

    //非比较排序：计数排序，基数排序，桶排序
    //比较排序：

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();

        int[] arr = {1,2,2,5,9,6,4,1,0};
        quickSort(arr, 0 ,arr.length - 1);

        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    // 快速排序
    public static void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int base = nums[end];
        int i = begin;
        int j = end;
        while (i < j) {
            while (i < j && nums[i] < base) {
                i++;
            }
            nums[j] = nums[i];
            while (i < j && nums[j] >= base) {
                j--;
            }
            nums[i] = nums[j];
        }
        nums[i] = base;
        quickSort(nums, begin, i - 1);
        quickSort(nums, i + 1, end);
    }

    // 归并排序
    public static void mergerSort(int[] nums, int begin, int end, int count) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergerSort(nums, begin, mid, count);
        mergerSort(nums, mid + 1, end, count);
        merger(nums, begin, end, count);
    }
    public static void merger(int[] nums, int left, int right,int count) {
        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;
        int[] arr = new int[right - left + 1];
        for (int k = 0; k <= (right - left); k++) {
            if (i <= mid && j <= right) {
                if (nums[j] < nums[i]) {
                    j++;
                    count = count + (mid - i + 1);
                } else {
                    i++;
                }

            } else if (i > mid && j <= right) {
                arr[k] = nums[j];
                j++;
            } else if (i <= mid && j > right) {
                arr[k] = nums[i];
                i++;
            }
        }
        for (int k = 0; k <= (right - left); k++) {
            nums[k + left] = arr[k];
        }
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        int index = arr.length / 2 - 1;

        for (int i = index; i >= 0; i--) {
            hsort(arr, i, arr.length - 1);
        }

        swap(arr, 0, arr.length - 1);
        for (int e = arr.length - 2; e > 0; e--) {
            hsort(arr, 0, e);
            swap(arr, 0, e);
        }
    }
    public static void hsort(int[] arr, int index, int end) {
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
            hsort(arr, maxInd, end);
        }
    }
    private static void swap(int[] arr, int j1, int j2) {
        int a = arr[j1];
        arr[j1] = arr[j2];
        arr[j2] = a;
    }

    // 插入排序
    public static void insertSort() {

    }
    // 希尔排序(分组间隔插入排序)
    public static void shellSort() {

    }

}
