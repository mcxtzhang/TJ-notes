package com.mcxtzhang.ejchap1.singleton;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/9.
 * History:
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        try {
            System.out.println("睡");
            Thread.sleep(3000);

            EnumSingleton.INSTANCE.metho1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //枚举可以实现接口
        ISomeInterface singleTon = EnumSingleton.INSTANCE;
        singleTon.someFunc();
        singleTon.someFunc2();


    }


}
