package com.example.springbootdemo;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.*;

/**
 * Created by xielei on 2020/6/2
 */
public class Threads {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,
                                                        10,
                                                        10,
                                                        TimeUnit.SECONDS,
                                                        new LinkedBlockingDeque<>(20));

        pool.execute(new Work1());
        pool.execute(new Work2());
        pool.execute(new Work3());
        System.out.println("------------------------");
        //pool.submit(new Work());
    }

    private static class Work1 implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("work 1");
            throw new RuntimeException(Thread.currentThread().getName() + "--thread exception");
        }
    }

    private static class Work2 implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("work 2");
            //throw new RuntimeException(Thread.currentThread().getName() + "--thread exception");
        }
    }

    private static class Work3 implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("work 3");
            //throw new RuntimeException(Thread.currentThread().getName() + "--thread exception");
        }
    }
}
