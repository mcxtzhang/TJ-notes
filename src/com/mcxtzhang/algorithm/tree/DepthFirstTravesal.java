package com.mcxtzhang.algorithm.tree;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/5/11.
 * History:
 */
public class DepthFirstTravesal {
    public static void dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.value);
        dfs(treeNode.left);
        dfs(treeNode.right);

    }

    //中序遍历
    public static void dfs2(TreeNode root) {

        if (root.left != null) {
            dfs2(root.left);
        }
        System.out.print(root.value);
        if (root.right != null) {
            dfs2(root.right);
        }
    }

    //后序遍历
    public static void dfs3(TreeNode root) {
        if (root.left!=null){
            dfs3(root.left);
        }
        if (root.right!=null){
            dfs3(root.right);
        }
        System.out.println(root.value);
    }
}
