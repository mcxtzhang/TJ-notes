package com.mcxtzhang.algorithm.offer;

/**
 * 链表中，倒数第K个结点
 * Created by pc on 2017/7/2.
 */
public class Test15 {

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


    public static Node lastNNode(Node head, int k) {
        if (head == null || k <= 0)
            return null;

        Node temp = head;
        Node targetK = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
            if (count >= k + 1) {
                targetK = targetK.next;
            }
        }
        if (count < k) {
            return null;
        }


        return targetK;
    }

    public static void main(String[] ar) {
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


        Node node = lastNNode(head, 3);
        System.out.println(node);

        node = lastNNode(head, 6);
        System.out.println(node);

        node = lastNNode(head, 1);
        System.out.println(node);

        node = lastNNode(head, 10);
        System.out.println(node);
    }


}
