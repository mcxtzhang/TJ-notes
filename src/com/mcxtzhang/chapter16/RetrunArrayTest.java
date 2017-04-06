package com.mcxtzhang.chapter16;

import java.util.Arrays;

/**
 * Intro: 函数返回数组，返回的是引用 ？
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/6.
 * History:
 */
public class RetrunArrayTest {
    static A[] array = new A[5];


    public static void main(String[] args) {
        System.out.println(array);

        A[] array1 = getArray();
        array1[0] = new A("111");
        System.out.println(array1);
        System.out.println(array);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array));
    }

    public static A[] getArray() {
        return array;
    }

    private static class A {
        String name;

        public A(String name) {
            this.name = name;
        }
    }

}
