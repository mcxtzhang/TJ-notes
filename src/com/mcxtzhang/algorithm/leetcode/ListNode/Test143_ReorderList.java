package com.mcxtzhang.algorithm.leetcode.ListNode;

/**
 * Intro:
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/6.
 * History:
 */
public class Test143_ReorderList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new Solution().reorderList(head);

    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
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
    static class Solution {
        public void reorderList(ListNode head) {
            if(head == null) return ;

            //1 先将链表前后分为两半。
            //利用快慢指针
            ListNode f=head,s=head;
            while(f!=null){
                f= f.next;
                if(f!=null){
                    f = f.next;
                }

                if(f==null){
                    ListNode temp = s;
                    s = s.next;
                    temp.next=null;//断开两半
                }else{
                    s= s.next;
                }
            }
            //举例  1234  ,此时  s是3.
            //     12345 ,此时  s是4. 所以一定指向后半段

            //2翻转后半段链表
            ListNode head2 = reverse(s);

            //3 两个链表从头一起遍历，将后半段链表依次插入前半段链表中
            f = head;
            ListNode temp = null;
            while(head2!=null){
                temp = f.next;
                f.next= head2;
                head2 = head2.next;
                f.next.next = temp;
                f= f.next.next;
            }
            //return head;

        }


        public ListNode reverse(ListNode head){
            if(head == null) return head;
            ListNode temp = head,cur = head.next;
            temp.next = null;
            ListNode p = null;
            while(cur !=null){
                p = cur.next;
                cur.next = temp;
                temp = cur;
                cur = p;
            }
            return temp;

        }
    }
}
