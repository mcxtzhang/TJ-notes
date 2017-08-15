package com.mcxtzhang.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: List 的  测试
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class ListTest {
    public static void main(String[] args) {
        //1 测试删除，删除是删除它们共有的元素
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List list2 = new ArrayList();
        for (int i = 0; i < 15; i = i + 2) {
            list2.add(i);
        }

        list2.removeAll(list);
        for (Object o : list2) {
            System.out.println(o);
        }

        //2 测试包含 null
        List list3 = new ArrayList();
        System.out.println("包含null？"+list3.contains(null));
        list3.clear();
        System.out.println("list3 clear 后，包含null？"+list3.contains(null));
        for (int i = 0; i < 5; i++) {
            list3.add(i);
        }
        list3.clear();
        System.out.println("list3 ,添加了元素后，又clear 后，包含null？"+list3.contains(null));
        //因为contain是会考虑size的。


        //3

    }
}
