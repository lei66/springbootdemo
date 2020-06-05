package com.example.springbootdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Test<T> extends AbstractTest{

    private T data;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();


        char[] chars = str.toCharArray();
        int n = 0;
        int len = chars.length;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                break;
            }
            n++;
        }
        System.out.println(n);

        //ConcurrentHashMap

        ApplicationContext context = new ClassPathXmlApplicationContext();
    }

    private void changeStr(String str) {
        str = "change";
        System.out.println(str);


    }

    // 不属于泛型方法
    public T getT(T test) {
        return test;
    }

    public <K> K getK(K k) {
        return k;
    }

    @Override
    public void method1() {

    }
}

