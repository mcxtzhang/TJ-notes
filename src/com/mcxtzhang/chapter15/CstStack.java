package com.mcxtzhang.chapter15;

/**
 * Intro: 自定义实现一个Stack
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/4.
 * History:
 */
public class CstStack<T> {
    private static class Node<T> {
        T item;
        Node<T> next;

        public Node() {
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        //end sentinel 末端哨兵
        public boolean isEnd() {
            return item == null && next == null;
        }
    }

    private Node<T> top;

    public CstStack() {
        //初始化时Top就是末端哨兵
        top = new Node();
    }

    public void push(T item) {
        Node newNode = new Node(item, top);
        top = newNode;
    }

    public T pop() {
        T result = top.item;
        //top没到末端，则出栈一个
        if (!top.isEnd()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        CstStack<String> src = new CstStack<>();
        for (String s : "I am a hungry man now ! I wanna have dinner!".split(" ")) {
            src.push(s);
        }

        String popItem;
        while (null != (popItem = src.pop())) {
            System.out.println(popItem);
        }


    }


}
