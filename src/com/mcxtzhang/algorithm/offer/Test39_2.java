package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.TreeNode;

/**
 * Intro: 输入一课二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树任意结点的左右子树深度相差不超过1，那么它就是一课平衡二叉树。
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/20.
 * History:
 */
public class Test39_2 {
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


        System.out.println(treeDepth(treeNode1));
        System.out.println(isAvl(treeNode1));
        System.out.println(isAvl2(treeNode1, new Depth()));

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

        System.out.println(treeDepth(treeNode1));
        System.out.println(isAvl(treeNode1));
        System.out.println(isAvl2(treeNode1, new Depth()));

    }

    public static boolean isAvl(TreeNode root) {
        if (root == null) return true;
        //return isTreeAvl(root) && isAvl(root.left) && isAvl(root.right);
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1)
            return false;
        return isAvl(root.left) && isAvl(root.right);
    }

/*    public static boolean isTreeAvl(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) > 1)
            return false;
        else
            return true;
    }*/


    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }


    //20171031 add more efficiency
    public static boolean isAvl2(TreeNode root, Depth depth) {
        //后序遍历 不会重复遍历节点
        if (root == null) {
            depth.value = 0;
            return true;
        }
        //int 类型无法传递副作用给函数调用者，所以用一个Class来holder一下
        Depth leftDepth = new Depth();
        Depth rightDepth = new Depth();
        //任意一个不是AVL false
        if (!isAvl2(root.left, leftDepth) || !isAvl2(root.right, rightDepth)) return false;
        //计算高度差值
        int abs = Math.abs(rightDepth.value - leftDepth.value);
        depth.value = Math.max(rightDepth.value, leftDepth.value) + 1;
        if (abs <= 1) return true;
        else return false;


    }

    private static class Depth {
        int value;
    }

}
