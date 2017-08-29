package com.mcxtzhang.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Intro: 测试给类和对象加Synchronized区别
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/29.
 * History:
 */
public class SynchronizedTest {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                new A().fun();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                new A().fun();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                A.staticFunc();
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                A.staticFunc();
            }
        });
    }


    static class A {
        public static synchronized void staticFunc(){
            System.out.println("staticFunc:"+Thread.currentThread());
            while (true) {

            }
        }
        public synchronized void fun() {
            System.out.println("func:"+Thread.currentThread());
            while (true) {

            }
        }

    }
}
