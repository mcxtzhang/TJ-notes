package com.mcxtzhang.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Intro: 栈的压入、弹出序列
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/5.
 * History:
 */
public class Test22 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(3);
        list2.add(2);
        list2.add(1);

        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(3);
        list3.add(5);
        list3.add(1);
        list3.add(2);


        System.out.println(isPopOrder(list1, list2));//true
        System.out.println(isPopOrder(list1, list3));//false

        list1 = new ArrayList<>();
        list1.add(1);
        list2 = new ArrayList<>();
        list2.add(4);
        System.out.println(isPopOrder(list1, list2));//false
        list1 = new ArrayList<>();
        list1.add(1);
        list2 = new ArrayList<>();
        list2.add(1);
        System.out.println(isPopOrder(list1, list2));//true
        System.out.println(isPopOrder(null, null));//false
    }


    public static <T> boolean isPopOrder(List<T> list1, List<T> list2) {
        if (list1 == null || list2 == null || list1.size() != list2.size())
            return false;

        //用一份辅助栈
        Stack<T> temp = new Stack<>();
        //顺序遍历出站序列
        for (T t : list2) {
            //如果辅助栈是空的，或者栈顶元素（出站元素）不等于  出站序列下一个元素
            if (temp.isEmpty() || !temp.peek().equals(t)) {
                //则去 入栈序列里寻找 ，
                int index = list1.indexOf(t);
                //如果没找到 说明 这两个序列不匹配 false
                if (index == -1) {
                    return false;
                } else {//如果找到了，将其和之前的元素都入栈
                    while (index-- >= 0) {
                        temp.push(list1.remove(0));
                    }
                    //并弹出 下一个出站的元素
                    temp.pop();
                }
                //如果等于 直接出站
            } else if (temp.peek().equals(t)) {
                temp.pop();
            }
        }
        //循环完毕 出站序列满足
        return true;
    }
}
