package com.mcxtzhang.algorithm.offer;

import java.util.Stack;

/**
 * Intro: 输入一个链表的头结点，从尾到头反过来打印每个节点的值
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/28.
 * History:
 */
public class ReverseLinkedList {

    private static class Node {
        int value;
        Node next;

        public Node() {
        }
    }

    public static void main(String[] args) {
        Node head = new Node();
        for (int i = 0; i < 10; i++) {
            insertNode(head, i);
        }
        reverseLinkedList(head);
    }

    public static void insertNode(Node head, int value) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node();
        node.value = value;
        temp.next = node;
    }


    public static void reverseLinkedList(Node head) {
        if (head == null || head.next == null)
            return;
        Stack stack = new Stack();
        Node temp = head;
        while ((temp = temp.next) != null) {
            stack.push(temp.value);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
