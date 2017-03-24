package com.mcxtzhang.chapter10;

/**
 * Intro: 接口内部的类自动是 public static
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/23.
 * History:
 */
public interface NestClassInInterfaceTest {
    void method();

    class Impl implements NestClassInInterfaceTest {

        @Override
        public void method() {
            System.out.println("hahahah");
        }

        public static void main(String[] args) {
            NestClassInInterfaceTest nestClassInInterfaceTest = new Impl();
            nestClassInInterfaceTest.method();
        }
    }

}
