package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 输入一个整数，输出二进制中 1 的个数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/30.
 * History:
 */
public class Test10 {
    public static void main(String[] args) {
        System.out.println(getBit1Count(-9));
        System.out.println(Integer.toBinaryString(-9));
        System.out.println(getBit1Count1(-9));
        System.out.println(getBit1Count2(-9));
        System.out.println(getBit1Count2(9));
    }

    public static int getBit1Count(int input) {
        int count = 0;
        while (input != 0) {
            if ((input & 1) == 0) {
                count++;
            }
            input = input >>> 1;
        }
        return count;
    }

    public static int getBit1Count1(int input) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((input & flag) == 1) {
                count++;
            }
            flag = flag << 1;
        }
        return count;

    }

    public static int getBit1Count2(int input) {
        int count = 0;
        while (input != 0) {
            count++;
            input = (input & (input - 1));
        }
        return count;
    }
}
