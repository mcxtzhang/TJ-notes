package com.mcxtzhang.ejchap4;

/**
 * Intro: 19  常量接口 是对接口的错误使用
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/13.
 * History:
 */
public class ConstantInterfaceTest19 {

    interface A {
        static final int FINAL_1 = 1;
        static final int FINAL_2 = 1;
    }

    static class B implements A {
        void method() {
            System.out.println(FINAL_1);
        }
    }

    static class C extends B {
        int FINAL_1 = 3;

        void methodInC() {
            System.out.println(FINAL_1);
        }
    }

    public static void main(String[] args) {

        C c = new C();
        c.method();
        c.methodInC();
    }


}
