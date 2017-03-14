package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Intro: 练习6 创建一个任务，它将睡眠1-10s随机，然后显示它睡眠的时间，并退出。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/14.
 * History:
 */
public class example6 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            executorService.execute(new Run6());
        }
        executorService.shutdown();

    }
}

class Run6 implements Runnable {
    private static int index = 0;
    private final int id = index++;

    @Override
    public void run() {
        System.out.println("开始子线程:" + id);
        int time = (int) (Math.random() * 10);

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("睡了多久:" + time + ",id:" + id);
        }
    }
}
