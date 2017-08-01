package com.mcxtzhang.algorithm.leetcode;

import java.util.Stack;

/**
 * Intro:
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/1.
 * History:
 */
public class Test20_ValidParentheses {
    public static class Solution {
        public boolean isValid(String s) {
            if (s == null) return false;
            Stack<Character> stack = new Stack<>();
            int length = s.length();
            char temp;
            for (int i = 0; i < length; i++) {
                temp = s.charAt(i);
                if (temp == '(' || temp == '{' || temp == '[') {
                    stack.push(temp);
                } else if (temp == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop != '(') {
                        return false;
                    }
                } else if (temp == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop != '{') {
                        return false;
                    }
                } else if (temp == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop = stack.pop();
                    if (pop != '[') {
                        return false;
                    }

                }

            }
            if (stack.isEmpty()){
                return true;
            }else {
                return false;
            }


        }
    }
}
