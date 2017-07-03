package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 反转链表
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/3.
 * History:
 */
public class Test16 {
    private static class Node {
        int value;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node head = null;
        for (int i = 1; i <= 6; i++) {
            Node node = new Node();
            node.value = i;
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
        }

        System.out.println(head);
        System.out.println(reverseLinkedList(head));
        System.out.println(reverseLinkedList(null));

        head = null;
        for (int i = 1; i <= 1; i++) {
            Node node = new Node();
            node.value = i;
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
        }
        System.out.println(head);
        System.out.println(reverseLinkedList(head));
    }


    public static Node reverseLinkedList(Node head) {
        if (head == null) return null;
        Node one = head;
        Node next;
        while (one.next != null) {
            next = one.next;
            one.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}
