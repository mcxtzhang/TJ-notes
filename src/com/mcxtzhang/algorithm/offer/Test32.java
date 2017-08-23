package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 求1到n整数中，1出现的次数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/23.
 * History:
 */
public class Test32 {
    public static void main(String[] args) {
        System.out.println(get1Counts(1));
        System.out.println(get1Counts(0));
        System.out.println(get1Counts(-1));
        System.out.println(get1Counts(11));
        System.out.println(get1Counts(121));
        System.out.println(get1Counts(134));


        System.out.println(get1CountsFrom1ToN(12));
    }

    public static int get1CountsFrom1ToN(long n) {
        int result = 0;
        for (long i = 1; i <= n; i++) {
            result += get1Counts(i);
        }
        return result;
    }

    //输出数字num里 1  出现的个数 递归方式
/*    public static int get1Counts(long num) {
        if (num <= 0) return 0;
        if (num < 10) return num == 1 ? 1 : 0;
        return get1Counts(num % 10) + get1Counts(num / 10);
    }*/
    //for循环实现
    public static int get1Counts(long num) {
        if (num < 10) {
            return num == 1 ? 1 : 0;
        }
        int result = 0;
        while (num != 0) {
            if (num % 10 == 1) result++;
            num = num / 10;
        }

        return result;
    }
}
