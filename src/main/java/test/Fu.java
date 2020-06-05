package test;

import java.util.jar.Attributes;

/**
 * Created by xielei on 2020/5/30
 */
public class Fu {
    public String s = "fu";

    public static void main(String[] args) {
        Fu f = new Fu();
        f.test();
    }

    public void test() {
        retry:
        System.out.println("fu");
    }
}
