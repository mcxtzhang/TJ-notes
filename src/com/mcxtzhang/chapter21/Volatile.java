package com.mcxtzhang.chapter21;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Intro: 测试Volatile + Atomic 是否线程安全 ,答案 是。
 * synchronized 一样
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/1.
 * History:
 */
public class Volatile {
    public static int normalI = 0;
    public static volatile int i = 0;
    public static volatile AtomicInteger sAtomicInteger = new AtomicInteger(0);

    public static void increment() {
        i++;
        sAtomicInteger.addAndGet(1);
    }

    public synchronized static void syncIncrement() {
        normalI++;
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i1 = 1; i1 <= 1000000; i1++) {
                    increment();
                    if (i1 == 1000000) {
                        System.out.println("------------i:" + i);
                        System.out.println("------------sAtomicInteger:" + sAtomicInteger.get());
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i1 = 1; i1 <= 1000000; i1++) {
                    increment();
                    if (i1 == 1000000) {
                        System.out.println("=======i:" + i);
                        System.out.println("==========sAtomicInteger:" + sAtomicInteger.get());
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i1 = 1; i1 <= 1000000; i1++) {
                    syncIncrement();
                    if (i1 == 1000000) {
                        System.out.println("3333333333 i:" + i);
                        System.out.println("3333333333 sAtomicInteger:" + sAtomicInteger.get());
                        System.out.println("3333333333 normalI:" + normalI);
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i1 = 1; i1 <= 1000000; i1++) {
                    syncIncrement();
                    if (i1 == 1000000) {
                        System.out.println("444444444444 i:" + i);
                        System.out.println("444444444444 sAtomicInteger:" + sAtomicInteger.get());
                        System.out.println("444444444444 normalI:" + normalI);
                    }
                }

            }
        }).start();
    }
}
