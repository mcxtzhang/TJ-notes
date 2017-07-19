package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Intro: 线程里抛异常，另外一个线程catch不到
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/19.
 * History:
 */
public class Test672 {
    public static void main(String[] args) {
/*        try {
            //ExecutorService executorService = Executors.newFixedThreadPool(5);

            //为线程池附着 一个 异常处理器
            ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                        @Override
                        public void uncaughtException(Thread t, Throwable e) {
                            System.out.println("被 异常处理器抓住啦：" + e);
                        }
                    });
                    return thread;
                }
            });

            executorService.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("被我捕获");
        }*/

//方法二 全局为所有Thread创建一个异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("我是全局的异常处理器");
            }
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new ExceptionThread());
    }

    public static class ExceptionThread implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
