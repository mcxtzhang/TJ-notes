package com.mcxtzhang.chapter21;

/**
 * Intro: 斐波那契数列
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/27.
 * History:
 */
public class exp2 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(feibonaqieshuolie(i));
        }

    }

    public static int feibonaqieshuolie(int n) {
        if (n == 1 || n == 2) {
            //System.out.println("n:"+n+",value :"+1);
            return 1;
        }
        int result = feibonaqieshuolie(n - 1) + feibonaqieshuolie(n - 2);
        //System.out.println("n:"+n+",value :"+feibonaqieshuolie(n - 1) + feibonaqieshuolie(n - 2));
        return result;
    }


}
