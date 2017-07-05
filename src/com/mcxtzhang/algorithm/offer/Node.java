package com.mcxtzhang.algorithm.offer;

public class Node {
    int value;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public static Node initLinkList(int begin,int num, int gap) {
        Node head = null;
        for (int i = begin; i <= num; i = i+gap) {
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
        return head;
    }
}