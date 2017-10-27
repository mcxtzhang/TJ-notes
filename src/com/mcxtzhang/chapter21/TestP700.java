package com.mcxtzhang.chapter21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Intro: 700 页，测试同一个对象先在A线程调用 ReenTrantLock.lock()锁住，
 * 1 再在A线程这个对象上使用lock() 能否通过。
 * 2 再在B线程这个对象上使用lock() 能否通过。
 * 3 再在A线程这个对象上使用lockInterruptibly() 能否通过。//通过
 * 3 再在B线程这个对象上使用lockInterruptibly() 能否通过。//通不过
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/19.
 * History:
 */

class BlockedMutex {
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        System.out.println("first lock.lock()");
        lock.lock();
    }

    public void f() {
        try {
            System.out.println("second lock.lockInterruptibly()");
            lock.lockInterruptibly();
            System.out.println("acquire lock in f()");
        } catch (InterruptedException e) {
            System.out.println("Interrupt from  lock.lockInterruptibly() in f(),");
        }
        System.out.println("second lock.lock() in f()");
/*        try {
            lock.lock();
        }finally {
            lock.unlock();
            System.out.println("finally");
        }

        System.out.println("end f()");*/
    }
}

class Blocked2 implements Runnable {

    BlockedMutex mBlockedMutex= new BlockedMutex();//3

    @Override
    public void run() {
        //4
/*        System.out.println("new BlockedMutex() from run() in Blocked2");
        mBlockedMutex = new BlockedMutex();*/
        System.out.println("begin call BlockedMutex.f()");
        mBlockedMutex.f();
        System.out.println("end call BlockedMutex.f()");
    }
}


public class TestP700 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Blocked2());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Begin interrupt t.interrupt()");
        thread.interrupt();

        //CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new Blocked2());
        //cyclicBarrier.
    }
}
