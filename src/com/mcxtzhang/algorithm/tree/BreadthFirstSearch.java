package com.mcxtzhang.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 广度优先遍历
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/5/12.
 * History:
 */
public class BreadthFirstSearch {
    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while (list.size() > 0) {
            TreeNode remove = list.remove(0);
            System.out.print(remove.value);
            if (remove.left != null) {
                list.add(remove.left);
            }
            if (remove.right != null) {
                list.add(remove.right);
            }
        }

    }
}
