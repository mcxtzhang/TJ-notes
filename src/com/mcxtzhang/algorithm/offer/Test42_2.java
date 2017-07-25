package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 字符串的左旋转操作是把 字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2.得到"cdefgab"
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/25.
 * History:
 */
public class Test42_2 {
    public static void main(String[] args) {
        String src = new String("abcdefg");

        String s = leftRotate(src, 2);
        System.out.println("解雇欧式:" + s);

        s = leftRotate(src, 71);
        System.out.println("解雇欧式:" + s);

        s = leftRotate(src, src.length());
        System.out.println("解雇欧式:" + s);
    }

    public static String leftRotate(String src, int k) {
        if (src == null || k > src.length()) return null;
        String temp = reverseString(src, 0, src.length() - 1);
        System.out.println("第一次旋转：" + temp);

        String result = reverseString(temp, 0, temp.length() - k - 1) + reverseString(temp, temp.length() - k, temp.length() - 1);
        return result;


    }

    //翻转 字符串 一段区域
    public static String reverseString(String src, int begin, int end) {
        if (src == null || src.length() < 0 || begin > end || begin < 0 || end < 0) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= begin; i--) {
            sb.append(src.charAt(i));
        }
        return sb.toString();
    }

}
