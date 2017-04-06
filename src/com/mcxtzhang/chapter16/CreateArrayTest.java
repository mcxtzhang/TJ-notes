package com.mcxtzhang.chapter16;

/**
 * Intro: 初始化数组的各种方式
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/6.
 * History:
 */
public class CreateArrayTest {
    public static void main(String[] args) {
        //第一种 new，指定length
        A[] a = new A[5];
        //第二种  {}指定具体内容
        A[] b = {new A("a"), new A("ab"), new A("bc"), new A("d")};
        //第三种 new {}指定具体内容
        A[] c = new A[]{new A("a"), new A("b"), new A("c"), new A("d")};

        System.out.println(c);

    }

    private static class A {
        String name;

        public A() {
        }

        public A(String name) {
            this.name = name;
        }
    }
}
