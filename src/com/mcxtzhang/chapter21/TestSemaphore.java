package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Intro: 信号量测试
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/20.
 * History:
 */

class Productor implements Runnable {
    public static int count = 0;
    private final int i = ++count;
    Semaphore mSemaphore;

    public Productor(Semaphore semaphore) {
        mSemaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("生产者开始干活"+i);
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Productor  is interrupt"+i);
        } finally {
            System.out.println("生产者干完活了"+i);
            mSemaphore.release();
        }
        System.out.println("生产者结束：" + Thread.currentThread()+", "+i);
    }
}

class Consumer implements Runnable {
    Semaphore mSemaphore;

    public Consumer(Semaphore semaphore) {
        mSemaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("消费者准备干活");
        try {
            mSemaphore.acquire();
            System.out.println("消费者真的干活");
        } catch (InterruptedException e) {
            System.out.println("消费者被打断了");
        }
        System.out.println("消费者干完活了");
        System.out.println("消费者结束：" + Thread.currentThread());
    }
}


public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(-1, true);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Consumer(semaphore));
        executorService.execute(new Productor(semaphore));
        executorService.execute(new Productor(semaphore));
        System.out.println("主线程结束：" + Thread.currentThread());
        executorService.shutdown();
    }
}
