package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro: 86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/4.
 * History:
 */
public class Test86_Partition_List {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;


        ListNode partition = new Solution().partition(head, 3);
        System.out.println(partition);


    }

    /**
     * Definition for singly-linked list.
     */
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            if (null == head) return head;
            ListNode temp = head;
            ListNode tail = null;//尾节点

            ListNode notLessThan = null;//大于等于链表的 表头
            ListNode temp2 = null;

            while (temp != null) {
                if (temp.val >= x) {
                    //需要移动到另一个队列上

                    //如果这个元素和head相等，head需要后移,因head代表了小于
                    if (head == temp) {
                        head = head.next;
                    }

                    if (notLessThan == null) {
                        notLessThan = temp;

                        temp = temp.next;
                        notLessThan.next = null;
                        temp2 = notLessThan;
                    } else {
                        temp2.next = temp;
                        temp2 = temp2.next;
                        temp = temp.next;
                        temp2.next = null;//防止环形出现
                    }
                } else {
                    //这里注意 防止断链
                    if (tail != null) {
                        tail.next = temp;
                    }
                    tail = temp;
                    temp = temp.next;
                }
            }

            //拼接
            if (head != null) {
                tail.next = notLessThan;
            } else {
                head = notLessThan;
            }


            return head;

        }
    }

}
