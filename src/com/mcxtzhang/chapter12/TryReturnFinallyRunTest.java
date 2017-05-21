package com.mcxtzhang.chapter12;

/**
 * Intro: try return 了， finally 还会走
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/5/15.
 * History:
 */
public class TryReturnFinallyRunTest {

    public static void main(String[] args) {
        System.out.println(value());
        ;
    }

    public static int value() {
        try {
            return 1;
        } finally {
            System.out.println("finally 仍然会走");
            //return 2; //注释后返回1  不注释返回2
        }
    }
}
