package com.mcxtzhang.algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Intro: 用两个队列实现栈
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/29.
 * History:
 */
public class Test7_2 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }

        Integer i = null;
        while ((i = myStack.pop()) != null && i != 5) {
            System.out.println(i);
        }

        for (int j = 10; j < 20; j++) {
            myStack.push(i);
        }

        i = null;
        while ((i = myStack.pop()) != null ) {
            System.out.println(i);
        }
    }

    private static class MyStack<T> {
        private Queue<T> queue1 = new LinkedList<T>();
        private Queue<T> queue2 = new LinkedList<T>();

        public void push(T t) {
            if (queue2.isEmpty()) {
                queue1.offer(t);
            } else {
                queue2.offer(t);
            }
        }

        public T pop() {
            if (queue1.isEmpty()) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                if (queue2.isEmpty()) {
                    return null;
                } else {
                    return queue2.poll();
                }
            } else {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            }
        }

    }
}
