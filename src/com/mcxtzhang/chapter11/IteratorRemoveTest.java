package com.mcxtzhang.chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Intro: 迭代器 Iterator remove 影不影响srcList(影响啊)
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/24.
 * History:
 */
public class IteratorRemoveTest {
    public static void main(String[] args) {
        List src = new ArrayList();
        for (int i = 0; i < 10; i++) {
            src.add(i);
        }
        System.out.println(src);

        Iterator iterator = src.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        System.out.println(src);

    }
}
