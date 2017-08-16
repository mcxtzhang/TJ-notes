package com.mcxtzhang.algorithm.offer;

/**
 * Intro:输入一个整数，输出二进制中 1 的个数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/16.
 * History:
 */
public class Test10_20170816 {
    public static void main(String[] args) {
        System.out.println(BinaryCount(9));
        System.out.println(BinaryCount2(9));
        System.out.println(BinaryCount3(9));

        System.out.println(BinaryCount(-4));
        System.out.println(BinaryCount2(-4));
        System.out.println(BinaryCount3(-4));
    }

    //和1与运算，
    // 结果是1 说明末尾为1， 不是1 说明是0.
    //依次右移，循环。
    public static int BinaryCount(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }

    //和1 与 运算，依次将1 左移，直到 1 <<32 == 0 . 可以直到每一位的1 的情况，需要循环32次。
    public static int BinaryCount2(int num) {
        int count = 0;
        int temp = 1;
        while (temp != 0) {
            if ((num & temp) == temp) {
                count++;
            }
            temp = temp << 1;
        }
        return count;
    }

    // num -1 & num  ,
    public static int BinaryCount3(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }

}
