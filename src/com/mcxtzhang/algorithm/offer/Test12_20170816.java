package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 打印1到最大的n位数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/16.
 * History:
 */
public class Test12_20170816 {
    public static void main(String[] args) {
        printNDigitNums(0);
    }

    public static void printNDigitNums(int n) {
        if (n < 1) return;

        int[] output = new int[n];
        int begin = 0;
        printPerN(output, begin);
    }

    public static void printPerN(int[] output, int begin) {
        if (output == null || begin < 0 || begin > output.length - 1) return;
        for (int i = 0; i <= 9; i++) {
            output[begin] = i;
            if (begin == output.length - 1) {
                print(output);
            } else {
                printPerN(output, begin + 1);
            }
        }
        output[begin] = 0;
    }

    public static void print(int[] output) {
        if (output == null) return;
        boolean print = false;
        for (int i = 0; i < output.length; i++) {
            if (i == output.length - 1 || output[i] != 0 || print) {
                print = true;
                System.out.print(output[i]);
            }
        }
        System.out.println();
    }
}
