package com.mcxtzhang.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/18.
 * History:
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put(null, null);
        map.put("2", null);
        map.put("13", "13");
        map.put(null, "f");


        System.out.println(map);

        map = new Hashtable<>();
        map.put("1", "1");
        //map.put(null, null);
        //map.put("2", null);
        map.put("13", "13");
        //map.put(null, "f");


        System.out.println(map);
    }
}
