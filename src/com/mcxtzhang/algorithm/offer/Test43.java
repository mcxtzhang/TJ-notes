package com.mcxtzhang.algorithm.offer;

/**
 * Intro: n个骰子的点数。把n个骰子扔在地上。所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 方案一 递归 写不好 暂时放弃
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/25.
 * History:
 */
public class Test43 {

    public static void main(String[] args) {

    }

    public static int sumKCount(int n) {
        if (n == 1) {
            for (int i = 1; i <= 6; i++) {
                return i;
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                return i + sumKCount(n - 1);
            }
        }
    }


}
