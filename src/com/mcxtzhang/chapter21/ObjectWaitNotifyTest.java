package com.mcxtzhang.chapter21;

import java.util.concurrent.Semaphore;

/**
 * 测试
 */
public class ObjectWaitNotifyTest {
    //public static Object lock = new Object();
    //public static Semaphore semaphore= new Semaphore(0);

    public static void main(String[] args) {
        A.getInstance().funA();
        new B().funB();
    }
}


class A {
    static A a = new A();

    public static A getInstance() {
        return a;
    }

    public Semaphore semaphore = new Semaphore(0);

    public void release() {
        semaphore.release();
    }

    public void funA() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("funA 1");
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("funA:::::::::" + semaphore.availablePermits());
                        semaphore.acquire();
                        System.out.println("funA 2");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }
        }).start();

    }
}

class B {
    public void funB() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("funB::::::::" + A.getInstance().semaphore.availablePermits());
                System.out.println("funB 1");
                A.getInstance().release();
                System.out.println("funB 2");
                System.out.println("funB::::::::" + A.getInstance().semaphore.availablePermits());


            }
        }).start();


    }
}