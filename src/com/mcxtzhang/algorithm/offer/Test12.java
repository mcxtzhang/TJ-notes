package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 打印1 到 最大的n位数
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/30.
 * History:
 */
public class Test12 {
    public static void main(String[] args) {
        printNum(3);
    }

    public static void printNum(int n) {
        if (n < 1) return;
        int max = 0;
        while (n-- != 0) {
            max = max * 10 + 9;
        }

        for (int i = 1; i <= max; i++) {
            System.out.println(i);
        }
    }

    public static void printNum2(int n) {
        if (n < 1) return;
        StringBuilder sbMax = new StringBuilder();
        while (n-- != 0) {
            sbMax.append("9");
        }
        String temp = "1";

        while (!sbMax.toString().equals(temp)) {
            System.out.println(temp);
            char[] chars = temp.toCharArray();
            chars[chars.length-1]
        }

        for (int i = 1; i <= max; i++) {
            System.out.println(i);
        }
    }

}
