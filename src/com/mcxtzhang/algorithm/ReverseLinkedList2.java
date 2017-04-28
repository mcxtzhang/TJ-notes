package com.mcxtzhang.algorithm;

import java.util.LinkedList;

/**
 * Intro: 用系统提供的LinkedList 反转
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/28.
 * History:
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list1.add(i);
        }
        for (Integer integer : list1) {
            System.out.print(integer);
        }
        System.out.println();


        LinkedList<Integer> list2 = new LinkedList<>();
        int size = list1.size();
        for (int i = 0; i < size; i++) {
            list2.add(list1.pollLast());
        }
        for (Integer integer : list2) {
            System.out.print(integer);
        }


    }
}
