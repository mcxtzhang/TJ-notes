package com.mcxtzhang.algorithm.offer;

import java.util.Stack;

/**
 * Intro: 用两个栈实现队列
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/28.
 * History:
 */
public class Test7 {
    public static void main(String[] args) {
/*        MyQueue<Integer> integerMyQueue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            integerMyQueue.appendTail(i);
        }

        Integer i = null;
        while ((i = integerMyQueue.deleteHead()) != null && i != 5) {
            System.out.println(i);
        }

        for (int j = 10; j < 20; j++) {
            integerMyQueue.appendTail(j);
        }

        i = null;
        while ((i = integerMyQueue.deleteHead()) != null && i != 5) {
            System.out.println(i);
        }*/


        MyQueue2<Integer> integerMyQueue = new MyQueue2<>();
        for (int i = 0; i < 10; i++) {
            integerMyQueue.appendTail(i);
        }

        Integer i = null;
        while ((i = integerMyQueue.deleteHead()) != null && i != 5) {
            System.out.println(i);
        }

        for (int j = 10; j < 20; j++) {
            integerMyQueue.appendTail(j);
        }

        i = null;
        while ((i = integerMyQueue.deleteHead()) != null && i != 5) {
            System.out.println(i);
        }
    }

    private static class MyQueue<T> {
        private Stack<T> stack1;//专门存
        private Stack<T> stack2;//专门取

        public MyQueue() {
            stack1 = new Stack<T>();
            stack2 = new Stack<T>();
        }

        void appendTail(T t) {
            if (stack2.isEmpty()) {
                stack1.push(t);
            } else {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                stack1.push(t);
            }
        }

        T deleteHead() {
            if (stack2.isEmpty() && stack1.isEmpty())
                return null;

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else {
                return stack2.pop();
            }
        }

    }


    private static class MyQueue2<T> {
        private Stack<T> stack1;//专门存
        private Stack<T> stack2;//专门取

        public MyQueue2() {
            stack1 = new Stack<T>();
            stack2 = new Stack<T>();
        }

        void appendTail(T t) {
            stack1.push(t);
        }

        T deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            } else {
                return null;
            }
        }
    }
}
