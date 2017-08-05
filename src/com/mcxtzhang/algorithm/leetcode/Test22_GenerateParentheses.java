package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/5.
 * History:
 */
public class Test22_GenerateParentheses {
    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }

    //stupid method, generate all  parentheses , output valid.  can not pass
    public static class Solution {
        public static final char[] SOURCE = new char[]{'(', ')'};

        public List<String> generateParenthesis(int n) {
            List<String> resutl = new ArrayList<>();
            if (n <= 0) return resutl;
            generateAllParenthesis(resutl, n * 2, new StringBuilder());
            Iterator<String> iterator = resutl.iterator();
            while (iterator.hasNext()) {
                if (!isValid(iterator.next())) {
                    iterator.remove();
                }
            }
            return resutl;
        }


        public void generateAllParenthesis(List<String> result, int n, StringBuilder sb) {
            if (n < 1) return;
            for (char c : SOURCE) {
                sb.append(c);
                if (n == 1) {
                    result.add(sb.toString());
                } else {
                    generateAllParenthesis(result, n - 1, sb);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }


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
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }


        }


    }

}
