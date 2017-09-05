package com.mcxtzhang.algorithm.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Intro:Test142_Linked_List_Cycle_II
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/5.
 * History:
 */
public class Test142_Linked_List_Cycle_II {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            //解法1 用哈希缓存List遍历过的Node，每次访问之前先从哈希表里取，取到了，说明这就是那个cyclebegin
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                } else {
                    set.add(head);
                    head = head.next;
                }
            }
            return null;
        }
    }
}

//解法2 先用两个指针一个速度2，一个速度1，走，相遇时，将一个指针移到头部，然后同时速度为1，再次相遇就是cyclebegin
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode s= head.next,f=head.next.next;
        while(f!=null && s!=null){
            if(f==s){
                //相遇 后 回退到头部
                f = head;
                break;
            }
            s= s.next;
            f = f.next;
            if(f!=null){
                f = f.next;
            }
        }
        while(f!=null && s!=null){
            if(f==s){
                return f;
            }
            f= f.next;
            s=s.next;
        }



        return null;
    }
}
