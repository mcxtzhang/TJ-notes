package com.mcxtzhang.ejchap1;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/9.
 * History:
 */
public class AutoBoxingTest {
    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }


}
