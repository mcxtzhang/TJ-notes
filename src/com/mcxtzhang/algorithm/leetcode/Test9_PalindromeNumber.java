package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/1.
 * History:
 */
public class Test9_PalindromeNumber {

    public static void main(String[] args) {

    }

    public class Solution {
        //beats 44%
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0) return false;
            int src = x;
            StringBuilder sb = new StringBuilder();
            while (x != 0) {
                sb.append(x % 10);
                x = x / 10;
            }
            try {
                if (Integer.parseInt(sb.toString()) == src) {
                    return true;
                } else {
                    return false;
                }

            } catch (NumberFormatException e) {
                return false;
            }

        }
    }

    //beats 23%
    public class Solution2 {
        public boolean isPalindrome(int x) {
            if(x<0) return false;
            int temp = x ;
            int reverse = 0;
            while(temp!=0){
                reverse  = reverse *10 + temp%10;
                temp = temp/10;
            }
            if(reverse == x){
                return true;
            }else{
                return false;
            }


        }
    }
}
