package com.mcxtzhang.algorithm;

import com.mcxtzhang.LinkedList;

/**
 * Intro:题目：反转单链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/28.
 * History:
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        // init datas
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            linkedList.add(i);
        }

        for (Integer integer : linkedList) {
            System.out.print(integer);
        }
        for (Integer integer : linkedList) {
            System.out.print(integer);
        }
        System.out.println("begin reverse");

        //reverse
        LinkedList<Integer> reverseList = new LinkedList<>();

        for (Integer integer : linkedList) {
            reverseList.push(integer);
        }

        for (Integer integer : reverseList) {
            System.out.println(integer);
        }
    }





}
