package com.mcxtzhang.impotant;

/**
 * Intro: 判断一个数 是不是 猫扑 素数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/23.
 * History:
 */
public class MopPrimeNumTest {
    public static void main(String[] args) {
        for (long i = 0; i < 10000000000000l; i++) {
            if (isMop(i) && PrimeNumberTest.isPrimeNum(i)) System.out.println(i);
        }
    }

    public static boolean isMop(long num) {
        if (num < 10) return num == 2;
        return (num % 10 == 3) && isMop(num / 10);
    }
}
