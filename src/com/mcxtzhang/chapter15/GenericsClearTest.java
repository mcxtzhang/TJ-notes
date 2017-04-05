package com.mcxtzhang.chapter15;

import java.lang.reflect.Array;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/5.
 * History:
 */
public class GenericsClearTest<TYPE> {
    Class<TYPE> holder;
    //运行时使用 会出错
    TYPE[] arrays;
    //运行时使用 不会出错
    TYPE[] arrays2;

    public GenericsClearTest(Class<TYPE> holder) {
        this.holder = holder;

        //new TYPE();
        //new TYPE[5];
        int[] ints = new int[5];

        //运行时使用 会出错
        arrays = (TYPE[]) new Object[5];
        //运行时使用 不会出错
        arrays2 = (TYPE[]) Array.newInstance(String.class, 5);

        TYPE a = (TYPE) "aaa";

    }

    public static void main(String[] args) {
        GenericsClearTest<String> class1 = new GenericsClearTest<>(String.class);
        System.out.println(class1.holder);
        System.out.println((class1.holder == String.class) + "");
        //System.out.println((class1.holder == Object.class) + "");

        System.out.println(class1.holder.isInstance("aa"));
        System.out.println(class1.holder.isInstance(new Object()));

        //运行时使用 会出错
        //class1.arrays[0] = "s";
        //运行时使用 不会出错
        class1.arrays2[0] = "s";
        System.out.println(class1.arrays2[0]);

        GenericsClearTest<Object> class2 = new GenericsClearTest<>(Object.class);
        System.out.println(class2.holder);
        //System.out.println((class2.holder == String.class) + "");
        System.out.println((class2.holder == Object.class) + "");

        System.out.println(class2.holder.isInstance("aa"));
        System.out.println(class2.holder.isInstance(new Object()));
    }
}
