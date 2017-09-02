package com.mcxtzhang.algorithm.leetcode;

import java.util.Stack;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/9/2.
 * History:
 */
public class Test445_AddTwoNumbersII {
         public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    /**
     * Definition for singly-linked list.

     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(null == l1 || null == l2)return null;
            //用两个栈保存数字 依次出站运算
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            while(l1!=null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            while(l2!=null){
                s2.push(l2.val);
                l2 = l2.next;
            }

            ListNode result=null ;
            int jinwei = 0;

            while(!s1.isEmpty() || !s2.isEmpty() || jinwei>0){
                int a =0;
                if(!s1.isEmpty()){
                    a = s1.pop();
                }
                int b = 0;
                if(!s2.isEmpty()){
                    b = s2.pop();
                }
                //考虑进位
                int res = a+b +jinwei;
                if(res>=10){
                    res = res -10;
                    jinwei = 1;
                }else{
                    jinwei = 0;
                }
                if(result ==null){
                    result = new ListNode(res);
                }else{
                    ListNode temp = new ListNode(res);
                    temp.next = result;
                    result = temp;
                }
            }



            return result;


        }
    }
}
