package com.example.springbootdemo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HTest {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] str1 = str.split("@");
        if (str1.length < 2 || str1[1] == null || "".equals(str1[1])) {
            System.out.println(str);
        } else {
            String[] allStr = str1[0].split(",");
            String[] usedStr = str1[1].split(",");
            LinkedHashMap<String, Integer> allMap = new LinkedHashMap<>();
            for (String s : allStr) {
                String c = s.substring(0, 1);
                int num = Integer.valueOf(s.substring(2, 3));
                allMap.put(c, num);
            }

            for (String s : usedStr) {
                String c = s.substring(0, 1);
                int num = Integer.valueOf(s.substring(2, 3));
                Integer allnum = allMap.get(c);
                if (allnum != null) {
                    allMap.put(c, (allnum - num));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> entry : allMap.entrySet()) {
                sb.append(entry.getKey() + ":" + entry.getValue() + ",");
            }
            String res = sb.substring(0, sb.length() - 1);
            System.out.println(res);
        }
    }
    public static void main(String[] args) {

    }
}
