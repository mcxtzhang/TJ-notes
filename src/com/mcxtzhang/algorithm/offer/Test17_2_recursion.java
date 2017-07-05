package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 合并两个排序的链表(递归简化代码 666)
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/3.
 * History:
 */
public class Test17_2_recursion {
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
        if (head1.value < head2.value) {
            newHead = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            head2 = head2.next;
        }
        newHead.next = mergeTwoOrderedLinklist(head1, head2);
        return newHead;

    }


}
