package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 字符串地址测试
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/27.
 * History:
 */
public class StringAddressTest {
    public static void main(String[] args) {
        //看内部实现是用 System.arrayCopy 做的，所以地址是新的
        char[] str1 = "hello world".toCharArray();
        char[] str2 = "hello world".toCharArray();

        String str3 = "hello world";
        String str4 = "hello world";


        if (str1 == str2) {
            System.out.println("(str1==str2");
        } else {
            System.out.println("(str1!=str2");
        }



        if (str3 == str4) {
            System.out.println("(str3==str4");
        } else {
            System.out.println("(str3!=str4");
        }
    }
}
