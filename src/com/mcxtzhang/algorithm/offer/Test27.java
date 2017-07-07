package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.BreadthFirstSearch;
import com.mcxtzhang.algorithm.tree.TreeNode;

/**
 * Intro: 二叉搜索树与双向链表
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/7.
 * History:
 */
public class Test27 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 10;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 6;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 14;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 8;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.value = 12;
        TreeNode treeNode7 = new TreeNode();
        treeNode7.value = 16;


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(treeNode1);

        System.out.println(treeNode1);

        tree2DoubleLinkedList(treeNode1);
        System.out.println(treeNode1);
    }

    public static void tree2DoubleLinkedList(TreeNode root) {
        if (root == null) return;
        tree2DoubleLinkedList(root.left);

        if (root.left != null) {
            root.left.right = root;
        } else {

        }

        if (root.right != null) {
            root.right.left = root;
        }

        tree2DoubleLinkedList(root.right);


    }
}
