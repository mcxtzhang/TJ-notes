package com.mcxtzhang.algorithm.offer;

/**
 * Intro: A 第一列 AA 27咧
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/30.
 * History:
 */
public class BitwiseTest {

    public static void main(String[] args) {

        //char[] chars = new char[]{'A'};

/*        for (int aChar : chars) {
            System.out.println(aChar - 64);
        }*/

        System.out.println(getRow("A"));
    }


    public static int getRow(String input) {
        if (null == input || input.length() <= 0)
            return 0;
        char[] chars = input.toCharArray();
        int result = 0;
        for (int aChar : chars) {
            if (aChar >= 65 && aChar <= 90) {
                result = result * 26 + (aChar - 64 );
            }
        }
        return result;

    }
}
