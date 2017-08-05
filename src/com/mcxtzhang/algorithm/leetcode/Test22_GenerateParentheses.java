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
        //new Solution2().generateParenthesis(1);
        //new Solution2().generateParenthesis(2);
        new Solution3().generateParenthesis(3);
    }


    //这种思路是  根据 左右需要add的括号数量。 左括号三个，右括号三个。
    //且每一次add， 相应数量-1.
    //但是 左边不能大于右边，否则就是错误的，
    public static class Solution3 {

        public List<String> generateParenthesis(int n) {
            List<String> resutl = new ArrayList<>();
            if (n <= 0) return resutl;
            generatePair(2, 3, new StringBuilder().append('('), resutl);
            return resutl;
        }

        public void generatePair(int leftToBeAdd, int rightToBeAdd, StringBuilder sb, List<String> result) {
            if (leftToBeAdd > rightToBeAdd || leftToBeAdd < 0 || rightToBeAdd < 0) return;
            if (leftToBeAdd == 0 && rightToBeAdd == 0) {
                result.add(sb.toString());
                return;
            }
            generatePair(leftToBeAdd - 1, rightToBeAdd, sb.append('('), result);
            sb.deleteCharAt(sb.length() - 1);
            generatePair(leftToBeAdd, rightToBeAdd - 1, sb.append(')'), result);
            sb.deleteCharAt(sb.length() - 1);
        }


    }


    //思路 第 1 ,2n 位 一定是 (  )
    //初始，maxPairCount = n ,toPairCount = 0
    //掏出左边的时候， 判断 toPairCount 不能大于 maxPairCount ， 才append ，同时 toPairCount+1，
    //掏出右边的时候，判断 toPairCount 不能小于1，才append，同时toPairCount-1,
    //每组成一对(成功的掏出右边)，maxPairCount--.   toPaireCount--
    public static class Solution2 {
        public static final char[] SOURCE = new char[]{'(', ')'};

        public List<String> generateParenthesis(int n) {
            List<String> resutl = new ArrayList<>();
            if (n <= 0) return resutl;
            int maxPairCount = n;//
            int toPairCount = 0;
            generateString(resutl, new StringBuilder(), n * 2, 1, maxPairCount, toPairCount);
            return resutl;
        }

        public void generateString(List<String> result, StringBuilder sb, int max, int n, int maxPairCount, int toPairCount) {
            if (n > max) {
                result.add(sb.toString());
                return;
            }
            for (char c : SOURCE) {
                if (c == '(') {
                    if (toPairCount < maxPairCount || n == 1) {
                        sb.append(c);
                        toPairCount++;
                        generateString(result, sb, max, n + 1, maxPairCount, toPairCount);
                        sb.deleteCharAt(sb.length() - 1);
                        toPairCount--;
                    } else {

                    }
                } else {
                    if ((toPairCount > 0 && n != 1) || n == max) {
                        sb.append(c);
                        toPairCount--;
                        maxPairCount--;
                        generateString(result, sb, max, n + 1, maxPairCount, toPairCount);
                        sb.deleteCharAt(sb.length() - 1);
                        toPairCount++;
                    } else {

                    }
                }
            }


        }
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
