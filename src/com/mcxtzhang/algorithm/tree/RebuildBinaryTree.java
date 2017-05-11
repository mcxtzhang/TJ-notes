package com.mcxtzhang.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/5/11.
 * History:
 */
public class RebuildBinaryTree {

    public static void main(String[] args) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(7);
        pre.add(3);
        pre.add(5);
        pre.add(6);
        pre.add(8);

        List<Integer> middle = new ArrayList<>();
        middle.add(4);
        middle.add(7);
        middle.add(2);
        middle.add(1);
        middle.add(5);
        middle.add(3);
        middle.add(8);
        middle.add(6);
        System.out.println(pre.subList(1, 3));
        System.out.println(pre.subList(3, pre.size()));

        TreeNode treeNode = rebuild(pre, middle);

        DepthFirstTravesal.dfs(treeNode);
    }




    private static TreeNode rebuild(List<Integer> pre, List<Integer> middle) {
        int value = pre.get(0);
        TreeNode node = new TreeNode();
        node.value = value;
        if (pre.size() > 1) {
            int index = middle.indexOf(value);//也相当于长度
            if (pre.size() >= index + 1  && index !=0) {
                node.left = rebuild(pre.subList(1, index + 1), middle.subList(0, index ));
            }
            if (index + 1 != pre.size() && index + 1  != middle.size()) {
                node.right = rebuild(pre.subList(index + 1, pre.size()), middle.subList(index + 1 , middle.size()));
            }
        }
        return node;


    }
}
