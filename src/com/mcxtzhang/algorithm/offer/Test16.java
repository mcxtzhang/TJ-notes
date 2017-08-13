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
        //System.out.println(reverseLinkedList(head));
        //System.out.println(reverseLinkedList(null));
        //offer书上的方法
        System.out.println(new Solution().reverseList(head));
        System.out.println(new Solution().reverseList(null));

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
/*        System.out.println(head);
        System.out.println(reverseLinkedList(head));*/

        //offer书上的方法
        System.out.println(new Solution().reverseList(head));
        System.out.println(new Solution().reverseList(null));

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



    public static class Solution {
        //一个指针保存前一个，一个指针保存现在。 另外的指针做临时的下一个，以及结果
        public Node reverseList(Node head) {
            if (head == null || head.next == null) return head;
            Node pre = head;
            Node now = head.next;
            pre.next = null;
            Node result = null;

            while (now != null) {
                result = now.next;
                now.next = pre;
                pre = now;
                if (result != null) {
                    now = result;
                } else {
                    result = now;
                    now = null;
                }
            }
            return result;
        }
    }
}
