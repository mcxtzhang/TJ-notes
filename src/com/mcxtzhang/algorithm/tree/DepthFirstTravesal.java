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
}
