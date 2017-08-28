package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 翻转单词顺序
 * "I am a student."->"student. a am I"
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/23.
 * History:
 */
public class Test42_201708028 {

    public static void main(String[] args) {
        String src = "I am a student.";
        String s = reverseOrderString(src);
        System.out.println(s);


    }

    public static String reverseOrderString(String src) {
        if (src == null || src.length() < 0) return null;
        char[] chars = reverseString(src.toCharArray(), 0, src.length() - 1);
        int lastI = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseString(chars, lastI, i - 1);
                lastI = i + 1;
                i++;
            } else {

            }
        }
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
