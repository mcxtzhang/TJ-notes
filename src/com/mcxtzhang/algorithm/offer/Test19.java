package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.BreadthFirstSearch;
import com.mcxtzhang.algorithm.tree.TreeNode;

/**
 * Intro: 二叉树的镜像
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/4.
 * History:
 */
public class Test19 {
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
        System.out.println(treeNode1);

        System.out.println("镜像后 广度优先遍历：");
        TreeNode treeNode = mirrorTree(treeNode1);
        BreadthFirstSearch.bfs(treeNode);
        System.out.println(treeNode);

    }
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode mirrorRoot = new TreeNode();
        mirrorRoot.value = root.value;
        if (root.left != null) {
            mirrorRoot.right = mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorRoot.left = mirrorTree(root.right);
        }
        return mirrorRoot;
    }
}
