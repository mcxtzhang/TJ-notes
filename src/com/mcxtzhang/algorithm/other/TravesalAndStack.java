package com.mcxtzhang.algorithm.other;

import java.util.Stack;

/**
 * Intro:#3.如何仅用递归函数和栈操作逆序一个栈
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/29.
 * History:
 */
public class TravesalAndStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public static void reverseStack(Stack<Integer> stack) {
        if (null == stack || stack.isEmpty()) return;
        Integer bottom = getBottomElement(stack);
        reverseStack(stack);
        stack.push(bottom);

    }

    public static int getBottomElement(Stack<Integer> stack) {
        Integer pop = stack.pop();
        int result;
        if (stack.isEmpty()) {
            return pop;
        } else {
            result = getBottomElement(stack);
        }
        stack.push(pop);
        return result;
    }
}
