package com.mcxtzhang.chapter14;

import java.lang.reflect.Proxy;

/**
 * Intro: 冬天代理 生成 带继承的interface的实例
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/1.
 * History:
 */
public class MulInterfacesDynamicProxyTest {
    public static void main(String[] args) {

        Erzi zhenErzi = new Erzi() {
            @Override
            public void erzi() {
                System.out.println("I am zhen erzi.");
            }

            @Override
            public void baba() {
                System.out.println("I am zhen erzi de baba");
            }
        };

        Erzi erzi = (Erzi) Proxy.newProxyInstance(Erzi.class.getClassLoader(), new Class[]{Erzi.class}, (proxy, method, args1) -> {
            System.out.println(proxy.getClass() + ",  me:" + method + ",   args:" + args1);
            return method.invoke(zhenErzi, args1);
        });

        erzi.erzi();
        erzi.baba();

    }


    interface Baba {
        void baba();
    }

    interface Erzi extends Baba {
        void erzi();
    }
}
