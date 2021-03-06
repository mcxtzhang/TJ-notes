package com.mcxtzhang.algorithm.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 字符串的排列
 * 输入 abc ，打印出adb acb  bac bca cab cba
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/11.
 * History:
 */
public class Test28 {
    public static void main(String[] args) {
        String src = "abc";
        List<Character> output = new ArrayList<>();
        //permutation(src, output);

        permutation_20170819(src);
    }


    public static void permutation_20170819(String src) {
        if (null == src || src.length() < 1) return;
        permutationHelper(src.toCharArray(), 0);

    }

    public static void permutationHelper(char[] src, int begin) {
        if (src == null || begin < 0 || begin > src.length - 1) return;
        for (int i = begin; i < src.length; i++) {
            if (begin == src.length - 1) {
                System.out.println(src);
            } else {
                swap(src, begin, i);
                permutationHelper(src, begin + 1);
                swap(src, i, begin);
            }
        }
    }

    public static void swap(char[] src, int l, int r) {
        //src[l] = src[l] ^ src[r];

        char temp = src[l];
        src[l] = src[r];
        src[r] = temp;
    }


    public static void permutation(String src, List<Character> tobeOutput) {
        if (src == null || src.length() == 0) return;

        int len = src.length();
        Character c;

        for (int i = 0; i < len; i++) {
            c = src.charAt(i);
            tobeOutput.add(c);

            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (j != i) {
                    temp.append(src.charAt(j));
                }
            }
            permutation(temp.toString(), tobeOutput);


            if (len == 1) {
                for (Character character : tobeOutput) {
                    System.out.print(character);
                }
                System.out.println();
            }
            tobeOutput.remove(c);

        }


    }
}
