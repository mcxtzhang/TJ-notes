package com.mcxtzhang.algorithm.other;

/**
 * Intro: 判断字符串是否是回文
 * aba abba aaabbbaaa   "" null  "a"
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class HuiWen {

    public static void main(String[] args){
        System.out.println(isPalindorme("aba"));
        System.out.println(isPalindorme("abba"));
        System.out.println(isPalindorme("aaabbbaaa"));
        System.out.println(isPalindorme(""));
        System.out.println(isPalindorme("a"));
        System.out.println(isPalindorme(null));
        System.out.println(isPalindorme("fhkdsafhjdla"));
        System.out.println(isPalindorme("ui ozblkjcvbkas"));
    }

    public static boolean isPalindorme(String string) {
        if (string == null) return false;
        if (string.length()==0) return true;
        return isPalindrome(string, 0, string.length() - 1);
    }


    public static boolean isPalindrome(String string, int begin, int end) {
        if (string == null || begin < 0 || end < 0 || begin > string.length() - 1 || end > string.length() - 1)
            return false;
        //最底层 此时没有字符 或者一个字符 ，认为是回文
        if (end - begin < 1) return true;
        if (string.charAt(begin) == string.charAt(end)) {
            return isPalindrome(string, begin + 1, end - 1);
        } else {
            return false;
        }

    }
}
