package com.mcxtzhang.chapter11;

import java.util.LinkedList;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/24.
 * History:
 */
public class StackTest {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String src = new String("This is my first custom Stack !");
        String[] split = src.split(" ");
        for (String s : split) {
            stack.push(s);
        }

        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println(stack);


        // + 进  - 出
        String src2 = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        Stack<Character> stack2 = new Stack<>();
        char[] chars = src2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('+' == chars[i]
                    && '+' != chars[i + 1]
                    && '-' != chars[i + 1]) {
                stack2.push(chars[i + 1]);
                i++;
                continue;
            }
            if ('-' == chars[i]) {
                System.out.println(stack2.pop());
            }

        }


    }
}

class Stack<T> {
    private LinkedList<T> datas = new LinkedList<T>();

    public void push(T t) {
        datas.addFirst(t);
    }

    public T pop() {
        return datas.poll();
    }

    public T peek() {
        return datas.getFirst();
    }

    public boolean isEmpty() {
        return datas.isEmpty();
    }

    public String toString() {
        return datas.toString();
    }

}
