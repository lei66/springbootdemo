package io;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Object {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.remove(list.size() - 1);

        HashMap map = new HashMap();
        ReentrantLock lock = new ReentrantLock();
    }


    public static boolean isTrue(int[] arr, int x, int y) {
        if (x >= y) {
            return true;
        }
        int base = arr[y];
        int m = y;
        while (m >= 0 && arr[m] >= base) {
            m--;
        }
        int s = x;
        while (s < m) {
            if (arr[s] > base) {
                return false;
            }
            s++;
        }
        return isTrue(arr, x, m) && isTrue(arr, m + 1, y - 1);
    }
}
