package com.mcxtzhang.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class LinkedHashMapTest {
    public static void main(String[] args){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

         map = new LinkedHashMap<String,String> (10,0.75f,true);
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.get("2");
        map.get("4");
        map.put("3","e");

        iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
