package com.mcxtzhang.algorithm.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Intro: 第一个只出现一次的字符
 * <p>
 * 题目:在字符串中找出第一个只出现一次的字符。
 * 如输入"abaccdeff" 输出b
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/13.
 * History:
 */
public class Test35 {
    public static void main(String[] args) {
        func("abaccdeff");
        func2("abaccdeff");
    }

    public static void func(String src) {
        if (src == null || src.length() == 0) return;

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            map.put(c, (map.get(c) == null ? 0 : map.get(c)) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("找到啦：" + entry.getKey());
                break;
            }
        }
    }


    public static void func2(String src) {
        if (src == null || src.length() == 0) return;
        //自定义HashMap的结构
        int[] hashmap = new int[256];

        for (int i = 0; i < src.length(); i++) {
            hashmap[src.charAt(i)]++;
        }

        for (int i = 0; i < src.length(); i++) {
            if (hashmap[src.charAt(i)] ==1){
                System.out.println("是他 是他 是他 就是他:"+src.charAt(i));
                break;
            }
        }

    }

}
