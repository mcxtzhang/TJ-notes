package com.mcxtzhang.algorithm.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Intro:两个链表的第一个公共结点
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/19.
 * History:
 */
public class Test37 {

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        Node node3 = new Node();
        node3.value = 3;
        Node node4 = new Node();
        node4.value = 4;
        Node node5 = new Node();
        node5.value = 5;
        Node node6 = new Node();
        node6.value = 6;
        Node node7 = new Node();
        node7.value = 7;

        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;

        node4.next = node5;
        node5.next = node6;

        Node bothParent = findBothParent(node1, node4);
        System.out.println("共同的爸爸：" + bothParent);
        System.out.println("共同的爸爸：" + findBothParent(node1, null));
        System.out.println("共同的爸爸：" + findBothParent(null, node4));

        System.out.println("方法二:");
        System.out.println("共同的爸爸：" + findBothParent(node1, node4));
        System.out.println("共同的爸爸：" + findBothParent(node1, null));
        System.out.println("共同的爸爸：" + findBothParent(null, node4));

        System.out.println("方法三:");
        System.out.println("共同的爸爸：" + findBothParent(node1, node4));
        System.out.println("共同的爸爸：" + findBothParent(node4, node1));
        System.out.println("共同的爸爸：" + findBothParent(node1, null));
        System.out.println("共同的爸爸：" + findBothParent(null, node4));
    }


    //方法一 用两个栈当做辅助空间
    public static Node findBothParent(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Stack<Node> stack1 = new Stack();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }

        Stack<Node> stack2 = new Stack();
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        Node lastEqual = null;
        while (!stack2.isEmpty() && !stack1.isEmpty()) {
            Node pop = stack2.pop();
            if (pop.equals(stack1.pop())) {
                lastEqual = pop;
            } else if (null != lastEqual) {
                return lastEqual;
            } else {

            }
        }
        return null;

    }

    //方法二 用哈希当辅助空间
    public static Node findBothParent2(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        Map<Node, Boolean> map = new HashMap<>();
        while (head1 != null) {
            map.put(head1, true);
            head1 = head1.next;
        }

        while (head2 != null) {
            Boolean aBoolean = map.get(head2);
            if (aBoolean) {
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }


    //方法三 不需要额外的空间
    public static Node findBothParent3(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        int len1 = 0;
        while (head1 != null) {
            len1++;
            head1 = head1.next;
        }
        int len2 = 0;
        while (head2 != null) {
            len2++;
            head2 = head2.next;
        }

        if (len1 > len2) {
            //先将长的链表 指针向后移动gap次
            int gap = len1 - len2;
            while (head1 != null && gap > 0) {
                gap--;
                head1 = head1.next;
            }

        } else {
            //先将长的链表 指针向后移动gap次
            int gap = len2 - len1;
            while (head2 != null && gap > 0) {
                gap--;
                head2 = head2.next;
            }
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

}
