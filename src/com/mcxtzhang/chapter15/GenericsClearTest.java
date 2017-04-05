package com.mcxtzhang.chapter15;

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

    public GenericsClearTest(Class<TYPE> holder) {
        this.holder = holder;

        //new TYPE();
        //new TYPE[5];
        int[] ints = new int[5];
        TYPE[] arrays = (TYPE[]) new Object[5];

        TYPE a = (TYPE) "aaa";

    }

    public static void main(String[] args) {
        GenericsClearTest<String> class1 = new GenericsClearTest<>(String.class);
        System.out.println(class1.holder);
        System.out.println((class1.holder == String.class) + "");
        //System.out.println((class1.holder == Object.class) + "");

        System.out.println(class1.holder.isInstance("aa"));
        System.out.println(class1.holder.isInstance(new Object()));

        GenericsClearTest<Object> class2 = new GenericsClearTest<>(Object.class);
        System.out.println(class2.holder);
        //System.out.println((class2.holder == String.class) + "");
        System.out.println((class2.holder == Object.class) + "");

        System.out.println(class2.holder.isInstance("aa"));
        System.out.println(class2.holder.isInstance(new Object()));
    }
}
