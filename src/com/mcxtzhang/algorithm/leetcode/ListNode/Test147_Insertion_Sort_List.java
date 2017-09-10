package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/10.
 * History:
 */
public class Test147_Insertion_Sort_List {
    public static void main(String[] args){
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


        ListNode listNode = new Solution().insertionSortList(head);
    }

    //精简了插入的部分
    class Solution2 {
        //测试用例    3 1 4 5 2
        public ListNode insertionSortList(ListNode head) {
            //插入排序，遍历整个List，每次将当前节点插入到 已经有序的List中的合适位置， 遍历完毕 sort完毕
            if(null == head) return null;

            ListNode sortListHead = new ListNode(0);
            sortListHead.next = head;
            ListNode cur = head.next;
            ListNode temp;
            head.next = null;
            while(cur!=null){
                temp = cur;
                cur = cur.next;
                temp.next = null;

                //在已经有序的List里插入
                ListNode cur2 = sortListHead;

                while(null!= cur2.next){
                    if(temp.val<=cur2.next.val){
                        //插入
                        temp.next = cur2.next;
                        cur2.next = temp;
                        break;
                    }else{
                        if(cur2.next.next==null){
                            cur2.next.next = temp;
                            break;
                        }else{
                            cur2 = cur2.next;
                        }
                    }
                }
            }

            return sortListHead.next;


        }
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //beats 19%
    static class Solution {
        //测试用例    3 1 4 5 2
        public ListNode insertionSortList(ListNode head) {
            //插入排序，遍历整个List，每次将当前节点插入到 已经有序的List中的合适位置， 遍历完毕 sort完毕
            if(null == head) return null;

            ListNode sortListHead = new ListNode(0);
            sortListHead.next = head;
            ListNode cur = head.next;
            ListNode temp;
            head.next = null;
            while(cur!=null){
                temp = cur;
                cur = cur.next;
                temp.next = null;

                //在已经有序的List里插入
                ListNode cur2 = sortListHead.next;
                ListNode pre = null;
                while(null!= cur2){
                    if(temp.val<=cur2.val){
                        //插入
                        temp.next = cur2;
                        if(pre == null){
                            sortListHead.next = temp;
                        }else{
                            pre.next = temp;
                        }
                        break;
                    }else{
                        pre = cur2;
                        if(cur2.next==null){
                            cur2.next = temp;
                            break;
                        }else{
                            cur2 = cur2.next;
                        }
                    }
                }
            }

            return sortListHead.next;


        }
    }
}
