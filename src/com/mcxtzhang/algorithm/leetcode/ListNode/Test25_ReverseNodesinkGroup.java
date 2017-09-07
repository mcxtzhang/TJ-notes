package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * <p>
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/7.
 * History:
 */
public class Test25_ReverseNodesinkGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
//测试用例
//[1,2,3,4,5] 1,   3 , ,5   6
        //beats 35%
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null || k ==1 ) return head;
            //一个结果指针，指向第一次反转的头部。  返回时判空，如果空返回head，说明一次reverse都没有。
            //一个tempHead 存放 遍历时的每个小段的头结点 用于反转
            //一个tempTail 存放 反转后的尾节点
            //newHead 存放 反转后的头指针
            //cur  遍历指针
            ListNode result = null;
            ListNode tempHead = null,tempTail =null,newHead,cur;
            int count=1;

            cur = head;
            while(cur!=null){
                if(count ==k){//需要断链 reverse
                    newHead = cur;
                    cur = cur.next;
                    newHead.next=null;//断链

                    newHead = reverse(null,tempHead);

                    if(result ==null){//如果是第一个反转的链表 设为结果
                        result = newHead;
                    }
                    //如果不是第一个，则要将上个尾部链接过来
                    if(tempTail!=null){
                        tempTail.next = newHead;
                    }
                    //用于指向下一个断链的头
                    tempTail = tempHead;
                    //先指向普通的未反转前的链表
                    tempTail.next = cur;

                    //置位
                    count=1;
                }else{
                    if(count==1){//开始新的一小段
                        tempHead = cur;
                    }else{

                    }
                    count ++;
                    cur = cur.next;

                }

            }

            if(result == null)return head;
            return result;

        }

        public ListNode reverse(ListNode left,ListNode right){
            if(right == null){
                return left;
            }else{
                ListNode temp =  reverse(right,right.next);
                right.next = left;
                return temp;
            }


        }
    }
}
