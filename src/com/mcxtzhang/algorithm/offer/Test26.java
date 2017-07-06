package com.mcxtzhang.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Intro: 复杂链表的复制
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/6.
 * History:
 */
public class Test26 {
    public static void main(String[] args) {
        ComplexNode node1 = new ComplexNode();
        node1.value = "A";
        ComplexNode node2 = new ComplexNode();
        node2.value = "B";
        ComplexNode node3 = new ComplexNode();
        node3.value = "C";
        ComplexNode node4 = new ComplexNode();
        node4.value = "D";
        ComplexNode node5 = new ComplexNode();
        node5.value = "E";

        node1.next = node2;
        node1.any = node3;

        node2.next = node3;
        node2.any = node5;

        node3.next = node4;

        node4.next = node5;
        node4.any = node2;

        System.out.println(node1);
        ComplexNode clone = clone(node1);
        System.out.println(clone);


    }

    private static class ComplexNode {
        String value;
        ComplexNode next;
        ComplexNode any;

        @Override
        public String toString() {
            return "ComplexNode{" +
                    "value='" + value + ", next:" + next;
        }
    }

    public static ComplexNode clone(ComplexNode root) {
        if (root == null) return null;
        ComplexNode newRoot = new ComplexNode();
        newRoot.value = root.value;
        Map<ComplexNode, ComplexNode> addedNodeMap = new HashMap<>();
        addedNodeMap.put(root, newRoot);

        ComplexNode tempRoot = root, tempNewRoot = newRoot;
        while (tempRoot.next != null) {
            ComplexNode tobeAdd = addedNodeMap.get(tempRoot.next);
            if (tobeAdd == null) {//新建 说明之前没有被添加过 需要创建
                tobeAdd = new ComplexNode();
                tobeAdd.value = tempRoot.next.value;
            }
            tempNewRoot.next = tobeAdd;
            addedNodeMap.put(tempRoot.next, tobeAdd);
            if (tempRoot.any != null) {
                tobeAdd = addedNodeMap.get(tempRoot.any);
                if (tobeAdd == null) {//新建 说明之前没有被添加过 需要创建
                    tobeAdd = new ComplexNode();
                    tobeAdd.value = tempRoot.any.value;
                }
                tempNewRoot.any = tobeAdd;
                addedNodeMap.put(tempRoot.any, tobeAdd);
            }
            tempRoot = tempRoot.next;
            tempNewRoot = tempNewRoot.next;
        }
        return newRoot;

    }
}
