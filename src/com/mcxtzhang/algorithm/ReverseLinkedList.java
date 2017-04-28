package com.mcxtzhang.algorithm;

import java.util.Iterator;

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


    private static class LinkedList<T> implements Iterable<T> {
        Node<T> head;

        public boolean isEnd() {
            if (head == null) {
                return true;
            } else {
                return false;
            }
        }

        public void push(T value) {
            Node<T> newNode = new Node<>();
            newNode.value = value;
            newNode.next = head;
            head = newNode;
        }

        public void add(T value) {

            if (head == null) {
                head = new Node<>();
                head.value = value;
                head.next = null;
            } else {
                Node<T> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new Node<>();
                temp.next.value = value;
                temp.next.next = null;
            }
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                Node<T> traveselHead;

                {
                    traveselHead = head;
                }


                public boolean isEnd() {
                    if (traveselHead == null) {
                        return true;
                    } else {
                        return false;
                    }
                }

                @Override
                public boolean hasNext() {
                    return !isEnd();
                }

                @Override
                public T next() {

                    T value = traveselHead.value;
                    traveselHead = traveselHead.next;
                    return value;
                }
            };
        }

        private class Node<T> {
            T value;
            Node<T> next;
        }


    }


}
