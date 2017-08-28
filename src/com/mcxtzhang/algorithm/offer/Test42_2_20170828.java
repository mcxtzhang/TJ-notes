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
public class Test42_2_20170828 {
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
        char[] chars = reverseString(src.toCharArray(), 0, src.length() - 1);
        reverseString(chars, 0, chars.length - 1 - k);
        reverseString(chars, chars.length - 1 - k+1, chars.length - 1);
        return new String(chars);

    }

    //翻转 字符串 一段区域
    public static char[] reverseString(char[] chars, int begin, int end) {
        if (chars == null || begin < 0 || end > chars.length - 1) return chars;
        int l = begin, r = end;

        while (l < r) {
            swap(chars, l, r);
            l++;
            r--;
        }
        return chars;
    }

    public static void swap(char[] chars, int left, int right) {
        if (left == right || chars == null) return;
        chars[left] ^= chars[right];
        chars[right] ^= chars[left];
        chars[left] ^= chars[right];
    }

}
