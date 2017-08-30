package com.mcxtzhang.algorithm.offer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Intro: 约瑟夫环
 * 1~n,数m出列
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/30.
 * History:
 */
public class Test45 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
        System.out.println(finalOneIndex(list, 3));
    }

    //用List去做，遍历到m 就删除。遍历到尾部，手动循环一下。 直到list元素为1为止
    public static int finalOneIndex(LinkedList<Integer> head, int m) {
        if (null == head) return 0;
        Iterator<Integer> iterator = head.iterator();
        int temp = m;
        while (head.size() > 1) {
            iterator.next();
            temp--;
            if (temp == 0) {
                iterator.remove();
                temp = m;
            }
            if (!iterator.hasNext()) {
                iterator = head.iterator();
            }
        }

        return head.get(0);
    }
}
