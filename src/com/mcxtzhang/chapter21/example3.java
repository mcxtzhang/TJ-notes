package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Intro:  用各种线程池测试线程
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/14.
 * History:
 */
public class example3 {

    public static void main(String[] args) {
        //不限制最大数量的线程池
        // ExecutorService executorService = Executors.newCachedThreadPool();
        //限制最大并发三个
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //单线程池
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Run1());

            //这段注释主要为了测试后台线程
/*            Thread thread = new Thread(new Run1());
            thread.setDaemon(true);
            thread.start();*/
        }
        executorService
                .shutdown();
        System.out.println("主线程结束了");
    }
}

