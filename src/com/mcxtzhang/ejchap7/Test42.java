package com.mcxtzhang.ejchap7;

/**
 * Intro: 慎用可变参数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/17.
 * History:
 */
public class Test42 {
    public static void main(String[] args) {
        method1();
        method2(2);
    }

    static void method1(int... ints) {
        System.out.println(ints.length);
    }


    static void method2(int first, int... ints) {
        System.out.println(first + "," + ints.length);
    }
}
