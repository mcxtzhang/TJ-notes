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
public class Test42 {

    public static void main(String[] args) {
        String src = "I am a student.";
        String s = reverseOrderString(src);
        System.out.println(s);


    }

    public static String reverseOrderString(String src) {
        if (src == null || src.length() < 0) return null;
        String reverseString = reverseString(src, 0, src.length() - 1);
        String result = "";
        int begin = 0;
        int end = 0;
        for (int i = 0; i < reverseString.length(); i++) {
            if (reverseString.charAt(i) == ' ') {
                result = result + reverseString(reverseString, begin, end - 1) + " ";
                begin = end = i + 1;
            } else {
                end++;
            }
        }
        if (begin <= src.length() - 1) {
            result = result + reverseString(reverseString, begin, end - 1) + " ";
        }
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
