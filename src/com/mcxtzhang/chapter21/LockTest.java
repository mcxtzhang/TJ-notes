package com.mcxtzhang.chapter21;

/**
 * Intro: 让线程交替运行
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/16.
 * History:
 */
public class LockTest {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A 在等待锁");
                synchronized (lock) {
                    System.out.println("A获得了锁");
                    try {
                        System.out.println("A1");
                        System.out.println("A释放了锁");
                        lock.notify();
                        System.out.println("A等待锁");
                        lock.wait();
                        System.out.println("A得到了锁继续运行");
                        System.out.println("A2");
                        System.out.println("A释放了锁");
                        lock.notify();
                        System.out.println("A等待锁");
                        lock.wait();
                        System.out.println("A得到了锁继续运行");
                        System.out.println("A3");
                        System.out.println("A释放了锁");
                        lock.notify();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B在等待锁");
                synchronized (lock) {
                    System.out.println("B得到了锁");
                    try {
                        System.out.println("B1 ");
                        System.out.println("B释放了锁");
                        lock.notify();
                        System.out.println("B等待锁");
                        lock.wait();
                        System.out.println("B得到了锁");
                        System.out.println("B2");

                        System.out.println("B释放了锁");
                        lock.notify();
                        System.out.println("B等待锁");
                        lock.wait();
                        System.out.println("B得到了锁");
                        System.out.println("B3 ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        a.start();
        ;
        b.start();
    }
}
