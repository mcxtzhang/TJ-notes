package com.mcxtzhang.chapter21;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/14.
 * History:
 */
public class example1 {

    public static void main(String[] args) {


        for (int i = 0; i < 30; i++) {
            new Thread(new Run1()).start();
        }

    }
}

class Run1 implements Runnable {

    private static int count = 0;
    private final int id = count++;

    public Run1() {
        System.out.println("Child Run constructor..,id:" + id);
    }

    @Override
    public void run() {
        //这段注释主要为了测试后台线程
/*        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int i = 0; i < 3; i++) {
            System.out.println("run ...:" + i+","+"id:" + id);
            Thread.yield();
        }
        System.out.println("Child run exit,id:" + id);
    }
}
