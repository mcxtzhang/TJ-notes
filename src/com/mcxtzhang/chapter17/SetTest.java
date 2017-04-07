package com.mcxtzhang.chapter17;

import java.util.HashSet;
import java.util.Set;

/**
 * Intro: Set 没有get，只能通过for和迭代器遍历。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/7.
 * History:
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("a");
        set.add("ab");
        set.add("aa");
        set.add("as");
        set.add("ad");
        set.add("ad");
        set.add("aa");
        set.add("ac");

        set.remove("a");

/*        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }*/
        for (String temp : set) {
            System.out.println(temp);
        }



    }
}
