package com.mcxtzhang.ejchap1;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/9.
 * History:
 */
public enum EnumSingleton {
    INSTANCE;


    EnumSingleton() {
        System.out.println("我被创建了");
    }

    public void metho1() {
        System.out.println("单例的方法");
    }
}
