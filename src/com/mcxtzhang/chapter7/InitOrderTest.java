package com.mcxtzhang.chapter7;

/**
 * Intro: 了解包括继承在内的初始化全过程：
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/2/17.
 * History:
 */
class Fruit {
    public Fruit() {
        System.out.println("Fruit:constructor:" + x1);
    }

    private static int x1 = printInt("Fruit:x1:init");

    static int printInt(String s) {
        System.out.println(s);
        return 47;
    }
}


public class InitOrderTest extends Fruit {
    public InitOrderTest() {
        System.out.println("InitOrderTest:constructor:" + x2);
    }

    private int x2 = printInt("InitOrderTest:x2:init");

    public static void main(String[] args) {
        System.out.println("main");
        /**
         *
         * Fruit:x1:init
         * main
         */
        //不加这局代码 也会初始化Fruit 的 staic，
        new InitOrderTest();
//        Fruit:x1:init
//                main
//        Fruit:constructor:47
//        InitOrderTest:x2:init
//        InitOrderTest:constructor:47
    }
}
