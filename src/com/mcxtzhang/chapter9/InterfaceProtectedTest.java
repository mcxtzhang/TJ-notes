package com.mcxtzhang.chapter9;

/**
 * Intro: 接口的方法必须是public的
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/2.
 * History:
 */
public class InterfaceProtectedTest implements AInterface {
    public static void main(String[] args) {
        new InterfaceProtectedTest().method1();
    }

    @Override
    public void method1() {

    }
}
