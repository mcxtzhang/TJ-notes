package com.mcxtzhang.chapter11;

import java.util.Iterator;

/**
 * Intro: 任意实现Iterator接口的类都可以用forEach循环
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/27.
 * History:
 */
public class AnyIteratorCanForEach {
    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.println(s);
        }
    }

    static class IterableClass implements Iterable<String> {
        String[] src = ("I am a man " + ", What is your name ? ").split(" ");

        @Override
        public Iterator<String> iterator() {
            return new Iterator<String>() {
                private int index = 0;

                @Override
                public boolean hasNext() {
                    return index < src.length;
                }

                @Override
                public String next() {
                    return src[index++];
                }
            };
        }
    }


}
