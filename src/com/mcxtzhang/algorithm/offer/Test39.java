package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.TreeNode;

/**
 * Intro: 二叉树的深度
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/20.
 * History:
 */
public class Test39 {
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


        System.out.println(treeDepth(treeNode1, 0));


        treeNode1 = new TreeNode();
        treeNode1.value = 1;
        treeNode2 = new TreeNode();
        treeNode2.value = 2;
        treeNode3 = new TreeNode();
        treeNode3.value = 3;
        treeNode4 = new TreeNode();
        treeNode4.value = 4;
        treeNode5 = new TreeNode();
        treeNode5.value = 5;
        treeNode6 = new TreeNode();
        treeNode6.value = 6;
        treeNode7 = new TreeNode();
        treeNode7.value = 7;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode6;

        treeNode5.left = treeNode7;

        System.out.println(treeDepth(treeNode1, 0));

    }


    public static int treeDepth(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(1 + treeDepth(root.left, depth), 1 + treeDepth(root.right, depth));
    }

    private static int depth = 0;

    public static void treeDepth2(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {

        }

        if (root.right != null) {

        }


    }
}
