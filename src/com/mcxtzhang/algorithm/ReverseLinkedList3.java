package com.mcxtzhang.algorithm;


/**
 * Intro: 记录住第一个节点,每次将第一个节点的后一个节点移动到第一位
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/28.
 * History:
 */
public class ReverseLinkedList3 {
    public static void main(String[] args) {
        // init datas
        Node head = null;
        for (int i = 1; i < 10; i++) {
            if (head == null) {
                head = new Node();
                head.next = null;
                head.value = i;
            } else {
                Node newNode = new Node();
                newNode.value = i;
                newNode.next = head;
                head = newNode;
            }
        }
        for (Node tempHead = head; tempHead != null; tempHead = tempHead.next) {
            System.out.print(tempHead.value);
        }

        //reverse
        //reverseLinkedList(head);
        Node originHead = head;
        while (originHead.next != null) {
            Node next = originHead.next;
            originHead.next = next.next;
            next.next = head;
            head = next;
        }
        

        System.out.println();
        for (Node tempHead = head; tempHead != null; tempHead = tempHead.next) {
            System.out.print(tempHead.value);
        }
    }

    public static void reverseLinkedList(Node head) {

    }

    private static class Node {
        int value;
        Node next;
    }

}
