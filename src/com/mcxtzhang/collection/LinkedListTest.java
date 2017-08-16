package com.mcxtzhang.collection;

import java.util.LinkedList;
import java.util.List;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/16.
 * History:
 */
public class LinkedListTest {
    public static void main(String[] args){
        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        list1.add(2,"追加的");

        System.out.println(list1);
    }
}
