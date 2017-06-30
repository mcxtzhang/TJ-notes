package com.mcxtzhang.algorithm.offer;

/**
 * Intro:数值的整数次方
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/30.
 * History:
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(Power(2, 2));
        System.out.println(Power(2, -2));

        System.out.println(Power(1, 0));
        System.out.println(Power(1, -0));

        System.out.println(Power(0, 2));
        System.out.println(Power(0, -2));
    }

    public static double Power(double base, int exponent) {
        double resutl = 1;
        if (exponent >= 0) {
            while (exponent != 0) {
                resutl = resutl * base;
                exponent--;
            }
            return resutl;
        } else {
            if (base == 0)
                throw new RuntimeException("base不能为负");
            exponent = -exponent;
            while (exponent != 0) {
                resutl = resutl * base;
                exponent--;
            }
            return 1 / resutl;
        }
    }
}
