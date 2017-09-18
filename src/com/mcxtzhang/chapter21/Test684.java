package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Intro: 测试Atomic的原子性
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/18.
 * History:
 */
public class Test684 implements Runnable {

    private AtomicInteger i = new AtomicInteger(0);

    //加上synchronized就没事
    public int getI() {
        return i.get();
    }

    public synchronized void incrementI() {
        i.addAndGet(2);
    }


    @Override
    public void run() {
        while (true) {
            incrementI();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Test684 test682 = new Test684();
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
