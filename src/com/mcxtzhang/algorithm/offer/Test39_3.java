package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Intro: 输入一课二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树任意结点的左右子树深度相差不超过1，那么它就是一课平衡二叉树。
 * <p>
 * 后序遍历去优化时间
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/20.
 * History:
 */
public class Test39_3 {
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

        System.out.println(isAvl(treeNode1));

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

        System.out.println(isAvl(treeNode1));

    }

    public static Map<TreeNode, Integer> depthMap = new HashMap<>();//以map缓存每个节点的对应的深度

    public static boolean isAvl(TreeNode root) {
        if (root == null) {
            depthMap.put(root, 0);
            return true;
        }
        boolean isLeftAvl = isAvl(root.left);
        boolean isRightAvl = isAvl(root.right);
        if (isLeftAvl && isRightAvl) {//后续遍历 先 遍历 左右子树
            //如果左右都是平衡的 再看看自己是否平衡，取出左右字数缓存的高度，计算自己是否平衡
            if (Math.abs(depthMap.get(root.left) - depthMap.get(root.right)) <= 1) {
                //只有左右都平衡， 自己也平衡，缓存自己的深度才有意义
                depthMap.put(root, 1 + Math.max(depthMap.get(root.left), depthMap.get(root.right)));
                return true;
            }
        }
        return false;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

}
