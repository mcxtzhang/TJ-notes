package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.BreadthFirstSearch;
import com.mcxtzhang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 树的子结构.
 * 输入两颗二叉树A 、B。
 * 判断B 是不是 A  的子结构。
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/3.
 * History:
 */
public class Test18 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.value = 8;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.value = 8;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.value = 7;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.value = 9;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.value = 2;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.value = 4;
        TreeNode treeNode7 = new TreeNode();
        treeNode7.value = 7;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;

        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(treeNode1);


        TreeNode treeNode11 = new TreeNode();
        treeNode11.value = 8;
        TreeNode treeNode12 = new TreeNode();
        treeNode12.value = 9;
        TreeNode treeNode13 = new TreeNode();
        treeNode13.value = 2;
        treeNode11.left = treeNode12;
        treeNode11.right = treeNode13;

        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(treeNode11);

        System.out.println();
        System.out.println(hasChild(treeNode1, treeNode11));

    }


    public static boolean hasChild(TreeNode parent, TreeNode child) {
        if (parent == null || child == null)
            return false;

        TreeNode root = parent;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode remove = list.remove(0);
            if (isChild(remove, child)) {
                return true;
            }
            if (remove.left != null) {
                list.add(remove.left);
            }
            if (remove.right != null) {
                list.add(remove.right);
            }
        }
        return false;
    }

    public static boolean isChild(TreeNode parent, TreeNode child) {
        if (parent == null) {
            if (child == null) {
                return true;
            } else {
                return false;
            }
        } else if (child == null) {
            return true;
        }
        if (parent.value == child.value) {
            return isChild(parent.left, child.left) && isChild(parent.right, child.right);
        } else {
            return false;
        }
    }

}
