package com.mcxtzhang.algorithm.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Ugly num
 * <p>
 * Created by mcxtzhang on 2017/10/4.
 */
public class Test34 {
    public static void main(String[] args) {
        System.out.println(getNthUglyNumSlow(1));
        System.out.println(getNthUglyNumSlow(2));
        System.out.println(getNthUglyNumSlow(3));
        System.out.println(getNthUglyNumSlow(4));
        System.out.println(getNthUglyNumSlow(5));
        System.out.println(getNthUglyNumSlow(6));
        System.out.println(getNthUglyNumSlow(1500));


        System.out.println(nthUglyNum(1));
        System.out.println(nthUglyNum(2));
        System.out.println(nthUglyNum(3));
        System.out.println(nthUglyNum(4));
        System.out.println(nthUglyNum(5));
        System.out.println(nthUglyNum(6));
        System.out.println(nthUglyNum(7));
        System.out.println(nthUglyNum(1500));
    }

    public static int nthUglyNum(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        //分别缓存 *2 *3 *5以后就大于 丑数数组中最后一个数字的 对应数字的下标。
        List<Integer> list = new LinkedList<>();
        list.add(1);
        int last2 = 1;
        int last3 = 1;
        int last5 = 1;
        while (n > list.size()) {
            //然后尝试对每个下标对数*2 *3 *5 因为这几个数字都回越界，所以取最小都做为新元素
            int num2 = list.get(last2 - 1) * 2;
            int num3 = list.get(last3 - 1) * 3;
            int num5 = list.get(last5 - 1) * 5;

            int nextMin = min(num2, num3, num5);

            list.add(nextMin);
            //同时更新 缓存的下标
            if (nextMin == num2) last2++;
            if (nextMin == num3) last3++;
            if (nextMin == num5) last5++;
        }
        return list.get(n - 1);

    }

    public static int min(int a, int b, int c) {
        if (a < b) {
            return a < c ? a : c;
        } else {
            return b < c ? b : c;
        }
    }


    //最慢的方法
    public static int getNthUglyNumSlow(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        int i = 2;
        int count = 1;
        while (true) {
            if (isUgpyNum(i)) {
                count++;
            }
            if (count == n) {
                return i;
            }
            i++;
        }

    }

    public static boolean isUgpyNum(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;

    }
}
