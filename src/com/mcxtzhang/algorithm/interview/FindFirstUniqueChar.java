package com.mcxtzhang.algorithm.interview;

import java.util.HashMap;
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
        System.out.println(findFirstUniqueChar2("abbcad"));
    }

    //自定义一个哈希表
    public static char findFirstUniqueChar2(String string) {
        if (null == string) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Integer integer = map.get(string.charAt(i));
            if (integer==null){
                map.put(string.charAt(i), 1);
            }else {
                map.put(string.charAt(i), integer+1);
            }
        }

        for (int i = 0; i < string.length(); i++) {
            if (1==map.get(string.charAt(i))){
                return string.charAt(i);
            }
        }
        return ' ';
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
