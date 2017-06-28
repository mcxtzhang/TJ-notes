package com.mcxtzhang.algorithm.offer;

import com.mcxtzhang.algorithm.tree.BreadthFirstSearch;
import com.mcxtzhang.algorithm.tree.DepthFirstTravesal;
import com.mcxtzhang.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.mcxtzhang.algorithm.tree.DepthFirstTravesal.dfs2;
import static com.mcxtzhang.algorithm.tree.DepthFirstTravesal.dfs3;

/**
 * Intro: 重建二叉树
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/28.
 * History:
 */
public class RebuildBinaryTreeTest6 {
    public static void main(String[] args) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(7);
        pre.add(3);
        pre.add(5);
        pre.add(6);
        pre.add(8);

        List<Integer> middle = new ArrayList<>();
        middle.add(4);
        middle.add(7);
        middle.add(2);
        middle.add(1);
        middle.add(5);
        middle.add(3);
        middle.add(8);
        middle.add(6);
        //System.out.println(pre.subList(0,0));
/*        System.out.println(pre.subList(2, 3));
        System.out.println(pre.subList(3, pre.size()));*/
        TreeNode root = rebuild(pre, middle);


        DepthFirstTravesal.dfs(root);
        System.out.println();
        dfs2(root);
        System.out.println();
        dfs3(root);

        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(root);
    }

    public static TreeNode rebuild(List<Integer> pre, List<Integer> middle) {
        if (pre == null || pre.isEmpty() || middle == null || middle.isEmpty())
            return null;
        TreeNode node = new TreeNode();
        node.value = pre.get(0);
        int index = middle.indexOf(node.value);
        if (index == 0) {
            node.left = null;
        } else {
            node.left = rebuild(pre.subList(1, index + 1), middle.subList(0, index));
        }

        if (index == middle.size() - 1) {
            node.right = null;
        } else {
            node.right = rebuild(pre.subList(index + 1, pre.size()), middle.subList(index + 1, middle.size()));
        }


        return node;
    }
}
