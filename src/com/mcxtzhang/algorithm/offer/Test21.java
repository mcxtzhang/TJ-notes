package com.mcxtzhang.algorithm.offer;

import java.util.Stack;

/** 包含min函数的栈
 * Created by mcxtzhang on 2017/7/5.
 */
public class Test21 {

    public static void main(String[] args) {
        CustomStack  customStack = new CustomStack();
        System.out.println(customStack.min());;
        customStack.push(3);
        System.out.println(customStack.min());;
        customStack.push(4);
        System.out.println(customStack.min());;
        customStack.push(2);
        System.out.println(customStack.min());;
        customStack.push(1);
        System.out.println(customStack.min());;
        customStack.pop();
        System.out.println(customStack.min());;
        customStack.pop();
        System.out.println(customStack.min());;
        customStack.push(0);
        System.out.println(customStack.min());;
    }


    public static class CustomStack {
        private Stack<Integer> mStack = new Stack<>();
        private Stack<Integer> mMin = new Stack<>();

        public void push(Integer integer) {
            mStack.push(integer);
            if (mMin.isEmpty()) {
                mMin.push(integer);
            } else {
                Integer pop = mMin.pop();
                mMin.push(pop);
                if (integer < pop) {
                    mMin.push(integer);
                }
            }

        }

        public Integer pop() {
            if (mStack.isEmpty()) return null;

            Integer pop = mStack.pop();
            Integer pop1 = mMin.pop();
            if (pop.equals(pop1)) {

            } else {
                mMin.push(pop);
            }

            return pop;
        }

        public Integer min() {
            if (mMin.isEmpty())
                return null;
            Integer pop = mMin.pop();
            mMin.push(pop);
            return pop;
        }

    }


}
