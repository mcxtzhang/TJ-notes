package com.mcxtzhang.impotant;

/**
 * Intro: 判断一个数是不是素数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/23.
 * History:
 */
public class PrimeNumberTest {
    public static void main(String[] args) {
        for (int i = 0; i <=100; i++) {
            if (isPrimeNum(i)) {
                System.out.println(i);
            }
        }
    }

    //除了 2 以外，所有可能的质因数都是奇数。所以先尝试 2，然后再尝试从 3 开始一直到 根号N 的所有奇数。
    public static boolean isPrimeNum(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        long max = (long) Math.sqrt(num);
        for (long i = 3; i <= max; i = i + 2) {
            if (num % i == 0) return false;
        }
        return true;

    }
}
