package com.mcxtzhang.chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Intro: 填充List测试
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/7.
 * History:
 */
public class FillListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Collections.nCopies(5, new String("dd")));
        System.out.println(list);
        Collections.addAll(list, new String(""));
        System.out.println(list);


        List<String> list2 = new ArrayList<>();
        Collections.fill(list2, new String("aaa"));
        System.out.println(list2);


        Set<String> set1 = new HashSet<>(list);
        System.out.println(set1);

        List<String> list3 = new ArrayList<>(set1);
        System.out.println(list3);
    }
}
