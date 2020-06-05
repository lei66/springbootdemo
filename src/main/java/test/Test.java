package test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xielei on 2020/5/30
 */
public class Test {

    public static void main(String[] args) {
        Fu f = new Zi();
        System.out.println(f.s);
        f.test();

        HashMap map = new HashMap();
        ConcurrentHashMap map1 = new ConcurrentHashMap();

        ReentrantLock lock = new ReentrantLock();
    }

    // 大于等于n最接近的2次幂
    public int getM(int n) {
        n = n - 1;
        n |= (n >> 1);
        n |= (n >> 2);
        n |= (n >> 4);
        n |= (n >> 8);
        n |= (n >> 16);

        return n;
    }


}
