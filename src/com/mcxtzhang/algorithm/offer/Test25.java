package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.BreadthFirstSearch;
import com.mcxtzhang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 二叉树中和为某一值的所有路径
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/6.
 * History:
 */
public class Test25 {
    public static void main(String[] args) {
/*        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 10;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 5;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 12;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 7;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;


        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(treeNode1);*/

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
        outputAllPathValue(treeNode1, 19);
        outputAllPathValue(treeNode1, 21);
        outputAllPathValue(treeNode1, 29);
        outputAllPathValue(treeNode1, 27);

    }

    public static void outputAllPathValue(TreeNode root, int pathValue) {
        if (root == null) return;
        List<TreeNode> pathNodes = new ArrayList<>();
        outputPathValue(root, pathValue, pathNodes);

    }

    public static void outputPathValue(TreeNode node, int pathValue, List<TreeNode> pathNodes) {
        if (node == null || pathNodes == null) return;

        if (pathValue == node.value) {//正好相等 就输出序列
            for (TreeNode pathNode : pathNodes) {
                System.out.print(pathNode.value);
            }
            System.out.print(pathValue);
            System.out.println();
        } else if (pathValue > node.value) {//大于 减去 继续递归
            pathValue = pathValue - node.value;
            pathNodes.add(node);
            if (node.left != null) {
                outputPathValue(node.left, pathValue, pathNodes);
            }
            if (node.right != null) {
                outputPathValue(node.right, pathValue, pathNodes);
            }
            pathNodes.remove(node);

        } else {//小于 不够~  终结
            return;
        }

    }
}
