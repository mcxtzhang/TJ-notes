package com.mcxtzhang.ejchap4;

/**
 * Intro: 不可变的类的测试，修改这些类的值，是改变引用 。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/11.
 * History:
 */
public class ImmutableClassTest {
    public static void main(String[] args) {
        String s = new String("a");
        System.out.println(s.hashCode());
        s = "b";
        System.out.println(s.hashCode());

        Integer integer = new Integer(1);
        Integer integer2 = new Integer(1);
        System.out.println(integer == integer2);//false
        System.out.println(integer.equals(integer2));
        System.out.println(1 == integer);
        System.out.println(1 == integer2);
        integer = 1;
        integer2 = 1;
        System.out.println(integer == integer2);
        System.out.println(integer.equals(integer2));


        integer = 128;
        integer2 = 128;
        System.out.println(integer == integer2);//false
        System.out.println(128 == integer);
        System.out.println(integer.equals(integer2));


        integer = 127;
        integer2 = 127;
        System.out.println(integer == integer2);//true
        System.out.println(127 == integer);
        System.out.println(integer.equals(integer2));

    }
}
