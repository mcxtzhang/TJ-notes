package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Intro: 自定义线程池的 线程工厂
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/29.
 * History:
 */
public class CustomThreadFactoryTest {
    private static class DaemonThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("zhangxutong" + Math.random());
            thread.setDaemon(true);
            return thread;
        }
    }

    public static class DaemonRunnable implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread() + "  ______" + this);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("innnnnnnnterrupteddddddddddddd...........");
            }
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("子线程");

        //ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        ExecutorService executorService = Executors.newFixedThreadPool(3, new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonRunnable());
        }
        System.out.println("All daemon started..");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
