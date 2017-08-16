package com.mcxtzhang.chapter21;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/16.
 * History:
 */
public class JoinThreadTest {
    public static void main(String[] args){
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }


        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(e);
                }

                printNumber("B");
            }
        });

        B.start();
        A.start();

    }

    private static void printNumber(String a) {
        System.out.println(a);
    }
}
