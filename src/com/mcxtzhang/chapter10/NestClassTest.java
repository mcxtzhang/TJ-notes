package com.mcxtzhang.chapter10;

/**
 * Intro:嵌套类
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/23.
 * History:
 */
public class NestClassTest {
    public static void main(String[] args) {

    }

    class NestClass {
        //普通内部类不能有 static变量、方法 也不能包含嵌套类
        //static int i = 1;

        public NestClass() {
            System.out.println("constructor NestClass");
        }
    }
}
