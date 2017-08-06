package com.mcxtzhang.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * Intro: Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/5.
 * History:
 */
public class Test23_MergeKSortedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node2.next = node4;

        ListNode listNode = new Solution2().mergeKLists(new ListNode[]{node1, node2});
        System.out.println(listNode);


    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            //掏出最小堆来存，然后~ 先将所有根节点入堆，每次从堆里取出一个元素。即为当前最小元素，加入结果后， 继续取出当前元素的下一个节点（如果有）入堆。
            if (null == lists || lists.length < 1) return null;
            PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> {
                return o1.val - o2.val;
            });
            for (ListNode list : lists) {
                if (list != null) {
                    heap.offer(list);
                }
            }
            ListNode result = null, tail = null;
            while (!heap.isEmpty()) {
                ListNode poll = heap.poll();
                if (result == null) {
                    result = poll;
                    tail = result;
                } else {
                    tail.next = poll;
                    tail = tail.next;
                }
                if (poll.next != null) {
                    heap.offer(poll.next);
                }
            }
            return result;

        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (null == lists || lists.length < 1) return null;
            ListNode head = new ListNode(0);
            ListNode temp = head;
            boolean flag = false;
            int minIndex = -1;
            while (true) {
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null) {
                        flag = true;
                        if (temp.next == null || lists[i].val < temp.next.val) {
                            temp.next = lists[i];
                            minIndex = i;
                        }
                    }
                }
                if (flag) {
                    lists[minIndex] = lists[minIndex].next;
                    temp.next.next = null;
                    temp = temp.next;
                    flag = false;
                } else {
                    break;
                }
            }
            return head.next;
        }
    }
}
