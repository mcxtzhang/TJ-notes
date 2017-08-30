package com.mcxtzhang.algorithm.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Intro: 给定一个字符串，求第一个不重复的字符 abbcad -> c
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/30.
 * History:
 */
public class FindFirstUniqueChar {
    public static void main(String[] args) {
        System.out.println(findFirstUniqueChar("abbcad"));
    }

    public static char findFirstUniqueChar(String string) {
        if (null == string) return ' ';
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (null == map.get(string.charAt(i))) {
                map.put(string.charAt(i), 1);
            } else {
                map.put(string.charAt(i), -1);
            }

        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() == 1) {
                return characterIntegerEntry.getKey();
            }
        }
        return ' ';
    }
}
