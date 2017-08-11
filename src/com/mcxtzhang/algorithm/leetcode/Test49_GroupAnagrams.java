package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Intro:
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/11.
 * History:
 */
public class Test49_GroupAnagrams {
    public static void main(String[] args) {
        String[] src = new String[]{"ray", "cod", "abe", "ned", "arc", "jar", "owl", "pop", "paw", "sky", "yup", "fed", "jul", "woo", "ado", "why", "ben", "mys", "den", "dem", "fat", "you", "eon", "sui", "oct", "asp", "ago", "lea", "sow", "hus", "fee", "yup", "eve", "red", "flo", "ids", "tic", "pup", "hag", "ito", "zoo"};
        //src = new String[]{"owl", "woo"};
        new Solution().groupAnagrams(src);
    }


    public static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            if (strs == null || strs.length == 0) return result;
            Map<String, List<String>> map = new HashMap<>();
            char[] chars;
            String key;
            List<String> value;
            for (String str : strs) {
                chars = str.toCharArray();
                Arrays.sort(chars);
                key = new String(chars);
                value = map.get(key);
                if (value == null) {
                    value = new ArrayList<>();
                    value.add(str);
                    map.put(key, value);
                } else {
                    value.add(str);
                }
            }
            for (String s : map.keySet()) {
                result.add(map.get(s));
            }
            return result;
        }
    }
}
