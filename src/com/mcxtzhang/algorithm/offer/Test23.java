package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.BreadthFirstSearch;
import com.mcxtzhang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 从上往下打印二叉树（广度遍历)
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/5.
 * History:
 */
public class Test23 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 8;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 6;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 10;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 5;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 7;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.value = 9;
        TreeNode treeNode7 = new TreeNode();
        treeNode7.value = 11;


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(treeNode1);

        System.out.println();
        bft(treeNode1);
    }

    public static void bft(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.remove(0);
            System.out.print(node.value);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
    }
}
