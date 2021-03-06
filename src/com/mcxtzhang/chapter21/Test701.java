package com.mcxtzhang.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Intro: 测试没有阻塞，使用interrupt 无法退出线程
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/19.
 * History:
 */
class NoBlockClass implements Runnable {

    int i;

    @Override
    public void run() {
        while (true) {
            i++;
            if (i % 1000000000 == 0)
                System.out.println("我活着:Thread.interrupted():" + Thread.interrupted());
        }
        //System.out.println("我要死了");
    }
}

public class Test701 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NoBlockClass());
        thread.start();


        TimeUnit.SECONDS.sleep(2);
        System.out.println("尝试停止线程");
        thread.interrupt();
        System.out.println("已经执行了interrupt:" + thread.isInterrupted());
        System.out.println("已经执行了interrupt:" + thread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
        System.out.println("已经执行了interrupt:" + thread.isInterrupted());
    }

}

/**
 * 我活着:Thread.interrupted():false
 * 尝试停止线程
 * 已经执行了interrupt:true
 * 已经执行了interrupt:true
 * 我活着:Thread.interrupted():true
 * 我活着:Thread.interrupted():false
 * 已经执行了interrupt:false
 * 我活着:Thread.interrupted():false
 * 我活着:Thread.interrupted():false
 * 我活着:Thread.interrupted():false
 */
