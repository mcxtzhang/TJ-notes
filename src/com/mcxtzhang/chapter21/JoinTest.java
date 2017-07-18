package com.mcxtzhang.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Intro: 测试 join() 和 interrupted()
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/18.
 * History:
 */
public class JoinTest {

    public static void main(String[] args) {
        System.out.println("begin main");

        Sleeper sleeper = new Sleeper("沉睡者1", 1000);
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("主线程interrupt join的睡眠线程：sleeper.isInterrupted():" + sleeper.isInterrupted());
        }
        //主线程卡住 所以下面这句话无效
        sleeper.interrupt();
        System.out.println("end main");


        Sleeper sleeper2 = new Sleeper("猪2", 2000);
        new Thread(() -> {
            System.out.println("子线程begin");

            try {
                sleeper2.join();
            } catch (InterruptedException e) {
                System.out.println("子线程的 join的睡眠线程 interrupt 了：sleeper.isInterrupted():" + sleeper.isInterrupted());
            }
            System.out.println("子线程end");
        }).start();
        System.out.println("主线程将 第二个猪 interrupt ");
        sleeper2.interrupt();

    }

    private static class Sleeper extends Thread {
        private int duration;

        public Sleeper(String name, int duration) {
            super(name);
            this.duration = duration;
            start();
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(duration);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted. isInterrupted():" + isInterrupted());
            }
            System.out.println(getName() + "has awakened.");
        }
    }
}
