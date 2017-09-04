package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/2.
 * History:
 */
public class Test160_IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;

            //遍历两个链表 找出长度差值
            int gap = 0;
            ListNode tempA = headA;
            ListNode tempB = headB;
            while(tempA!=null){
                gap++;
                tempA = tempA.next;
            }
            while(tempB!=null){
                gap--;
                tempB = tempB.next;
            }
            tempA = headA;
            tempB = headB;
            if(gap>0){
                //A更长 A先走
                while(gap!=0){
                    gap--;
                    tempA = tempA.next;
                }
            }else{//B可能更长 B先走
                while(gap!=0){
                    gap++;
                    tempB = tempB.next;
                }
            }
            //现在他们在同一起跑线
            while(tempA!=null && tempB!=null){
                if(tempA==tempB){
                    return tempA;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
            return null;

        }
    }
}
