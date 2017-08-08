package com.mcxtzhang.algorithm;

/**
 * Intro:ReverseSentence
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/8.
 * History:
 */
public class ReverseSentence {
    public static void main(String[] args) {
        String src = "Today is lucky day";
        char[] chars = reverseSentence(src.toCharArray());
        System.out.println(chars);
    }

    static char[] reverseSentence(char[] sentence) {
        if (sentence == null || sentence.length < 1) return sentence;
        reverse(sentence, 0, sentence.length - 1);
        int begin = -1;
        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == ' ') {
                reverse(sentence, begin, i - 1);
                begin = -1;
            } else {
                if (begin == -1) {
                    begin = i;
                }
            }
        }
        if (begin != -1) {
            reverse(sentence, begin, sentence.length-1);
            begin=-1;
        }
        return sentence;
    }

    static char[] reverse(char[] sentence, int begin, int end) {
        if (sentence == null || sentence.length < 1 || begin > end || begin >= sentence.length || end >= sentence.length)
            return sentence;
        int i = begin;
        int j = end;
        char temp;
        while (i < j) {
            temp = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = temp;
            i++;
            j--;
        }
        return sentence;
    }


}
