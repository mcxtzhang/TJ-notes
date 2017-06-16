package com.mcxtzhang.ejchap1.singleton;

/**
 * Intro: 枚举单例
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/9.
 * History:
 */
public enum EnumSingleton implements ISomeInterface {
    INSTANCE {
        @Override
        public void someFunc2() {
            System.out.println("枚举实现接口， 方法二");
        }
    };


    EnumSingleton() {
        System.out.println("我被创建了");
    }

    public void metho1() {
        System.out.println("单例的方法");
    }

    @Override
    public void someFunc() {
        System.out.println("枚举也是可以实现接口的");
    }
}
