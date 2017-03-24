package com.mcxtzhang.chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Intro: List Iterator
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/24.
 * History:
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        List<Integer> src = new ArrayList();
        for (int i = 0; i < 10; i++) {
            src.add(i);
        }
        System.out.println(src);

        ListIterator<Integer> listIterator = src.listIterator();
        while (listIterator.hasNext()) {
            //顺序时，previousIndex 其实是它本身，nextIndex 是下一个
            System.out.println(listIterator.next() + ", listIterator.nextIndex():" + listIterator.nextIndex() + ",   listIterator.previousIndex():" + listIterator.previousIndex());
        }

        System.out.println();

        while (listIterator.hasPrevious()) {
            //逆序时，nextIndex 是它本神， previousIndex 是下一个
            //System.out.println(listIterator.previous());
            System.out.println(listIterator.previous() + ", listIterator.nextIndex():" + listIterator.nextIndex() + ",   listIterator.previousIndex():" + listIterator.previousIndex());

        }

        System.out.println();
        System.out.println(src);


        listIterator = src.listIterator(5);
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(0);
        }

        System.out.println(src);

    }
}
