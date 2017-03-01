package com.mcxtzhang.chapter8;

/**
 * Intro: 涉及到继承的初始化顺序
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/1.
 * History:
 */
public class ExtendInitOrderTest {
    public static void main(String[] args) {
        new C();
        /**
         * Output:
         init A
         init Y
         init B
         init Z
         init C
         *
         */
    }
}

class A {
    public A() {
        System.out.println("init A");
    }
}

class B extends A {
    Y y = new Y();

    public B() {
        System.out.println("init B");
    }
}

class C extends B {
    Z z = new Z();

    public C() {
        System.out.println("init C");
    }
}

class Z {
    public Z() {
        System.out.println("init Z");
    }
}

class Y {
    public Y() {
        System.out.println("init Y");
    }
}


