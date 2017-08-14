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

        int[] p = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] m = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
/*          p = new int[]{1, 2, 3};
          m = new int[]{2,1,3};*/
        TreeNode root2 = rebuild3(p, m);


        DepthFirstTravesal.dfs(root);
        System.out.println();
        DepthFirstTravesal.dfs(root2);
        System.out.println();
        dfs2(root);
        System.out.println();
        dfs2(root2);
        System.out.println();

        dfs3(root);
        System.out.println();
        dfs3(root2);

        System.out.println("广度优先遍历：");
        BreadthFirstSearch.bfs(root);
        System.out.println();
        BreadthFirstSearch.bfs(root2);


    }

    ///20170814
    public static TreeNode rebuild3(int[] pre, int[] middle) {
        if (pre == null || middle == null) return null;
        return rebuild3(pre, 0, pre.length - 1, middle, 0, middle.length - 1);
    }

    public static TreeNode rebuild3(int[] pre, int pBegin, int pEnd, int[] middle, int mBegin, int mEnd) {
        if (pre == null || middle == null || pBegin < 0 || pEnd >= pre.length || pBegin > pEnd
                || mBegin < 0 || mEnd >= middle.length || mBegin > mEnd) {
            return null;
        }

        int index = search(middle, pre[pBegin]);
        if (index < 0) return null;
        TreeNode root = new TreeNode();
        root.value = pre[pBegin];//根
        int leftCount = index - mBegin;
        root.left = rebuild3(pre, pBegin + 1, pBegin + leftCount, middle, mBegin, index - 1);
        root.right = rebuild3(pre, pBegin + leftCount + 1, pEnd, middle, index + 1, mEnd);
        return root;
    }

    private static int search(int[] nums,int key){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==key){
                return i;
            }
        }
        return -1;
    }


    public static TreeNode rebuild(List<Integer> pre, List<Integer> middle) {
        if (pre == null || pre.isEmpty() || middle == null || middle.isEmpty())
            return null;
        TreeNode node = new TreeNode();
        node.value = pre.get(0);
        int index = middle.indexOf(node.value);
/*        if (index == 0) {//不这么判断的话，就要判断是否越界
            node.left = null;
        } else {
            node.left = rebuild(pre.subList(1, index + 1), middle.subList(0, index));
        }*/
        node.left = rebuild(pre.subList(1, index + 1), middle.subList(0, index));
/*        if (index == middle.size() - 1) {
            node.right = null;
        } else {
            node.right = rebuild(pre.subList(index + 1, pre.size()), middle.subList(index + 1, middle.size()));
        }*/
        node.right = rebuild(pre.subList(index + 1, pre.size()), middle.subList(index + 1, middle.size()));

        return node;
    }
}
