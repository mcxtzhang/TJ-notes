package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Intro: 测试volatile的可见性.它只有可见性 没有原子性。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/18.
 * History:
 */
public class Test682 implements Runnable {

    //加上volatile 还是会error
    private volatile int i = 0;

    //加上synchronized就没事
    public int getI() {
        return i;
    }

    public synchronized void incrementI() {
        i++;
        //Thread.yield();
        i++;
    }


    @Override
    public void run() {
        while (true) {
            incrementI();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Test682 test682 = new Test682();
        executorService.execute(test682);
        while (true) {
            int i = test682.getI();
            if ((i & 0x01) == 0x01) {
                System.out.println("error:" + i);
                System.exit(0);
            }
        }
    }
}
