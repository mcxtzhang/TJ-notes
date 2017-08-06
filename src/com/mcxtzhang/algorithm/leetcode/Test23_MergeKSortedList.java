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

        ListNode listNode = new Solution3().mergeKLists(new ListNode[]{node1, node2});
        System.out.println(listNode);


    }

    //分治思想
    public static class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (null == lists || lists.length < 1) return null;
            return mergeList(lists, 0, lists.length - 1);
        }

        public ListNode mergeList(ListNode[] lists, int begin, int end) {
            if (begin > end) return null;
            if (begin < end) {
                int m = (end + begin) / 2;
                return merge2List2(mergeList(lists, begin, m), mergeList(lists, m + 1, end));
            } else {
                return lists[begin];
            }

        }

        //分治进行到底
        public ListNode merge2List2(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = merge2List2(l1.next, l2);
                return l1;
            } else {
                l2.next = merge2List2(l1, l2.next);
                return l2;
            }
        }

        //普通方法的 合并两个list
        public ListNode merge2List(ListNode l1, ListNode l2) {
            ListNode result = null, tail = null;
            while (l1 != null || l2 != null) {
                if ((l1 != null && l2 != null && l1.val < l2.val) || (l1 != null && l2 == null)) {
                    if (result == null) {
                        result = l1;
                        tail = result;
                    } else {
                        tail.next = l1;
                        tail = tail.next;
                    }
                    l1 = l1.next;
                } else {
                    if (result == null) {
                        result = l2;
                        tail = result;
                    } else {
                        tail.next = l2;
                        tail = tail.next;
                    }
                    l2 = l2.next;
                }
            }
            return result;
        }
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
