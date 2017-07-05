package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 合并两个排序的链表(第一遍做错了)
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/3.
 * History:
 */
public class Test17_important {
    public static void main(String[] args) {
        Node head1 = Node.initLinkList(1, 7, 2);
        Node head2 = Node.initLinkList(2, 8, 2);
        System.out.println(head1);
        System.out.println(head2);
        System.out.println(mergeTwoOrderedLinklist(head1, head2));
        System.out.println(mergeTwoOrderedLinklist(null, head2));
        System.out.println(mergeTwoOrderedLinklist(head1, null));
        System.out.println(mergeTwoOrderedLinklist(null, null));
        head1 = Node.initLinkList(1, 1, 2);
        head2 = Node.initLinkList(2, 2, 2);
        System.out.println(head1);
        System.out.println(head2);
        System.out.println(mergeTwoOrderedLinklist(head1, head2));
    }

    public static Node mergeTwoOrderedLinklist(Node head1, Node head2) {
        if (head1 == null && head2 == null)
            return null;
        if (head1 == null && head2 != null)
            return head2;
        if (head2 == null && head1 != null)
            return head1;
        Node newHead = null;
        Node temp;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                temp = head1;
                head1 = head1.next;
                temp.next = null;
            } else {
                temp = head2;
                head2 = head2.next;
                temp.next = null;
            }
            newHead = append(newHead, temp);
        }
        if (head1 == null) {
            newHead = append(newHead, head2);
        } else {
            newHead = append(newHead, head1);
        }
        return newHead;

    }

    //在连边尾部追加一个Node(NodeList)
    public static Node append(Node head, Node tobeAppendNode) {
        if (tobeAppendNode == null) return head;
        Node temp;
        if (head == null) {
            head = tobeAppendNode;
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = tobeAppendNode;
        }
        return head;
    }

}
