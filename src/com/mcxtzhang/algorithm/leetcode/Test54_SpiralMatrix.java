package com.mcxtzhang.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/12.
 * History:
 */
public class Test54_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix = new int[][]{{1, 2, 3}};
        new Solution().spiralOrder(matrix);
    }


    public static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return result;

            int m = matrix.length;
            int n = matrix[0].length;

            int i, j;
            int right = 0, botton = 0, left = 0, top = 0;
            while (true) {

                i = top;
                for (j = right; j <= n - 1 - right; j++) {
                    result.add(matrix[i][j]);
                }
                right++;
                if (result.size()==n*m)
                    break;

                j = n - 1 - botton;
                for (i = right; i <= m - 1 - botton; i++) {
                    result.add(matrix[i][j]);
                }
                botton++;
                if (result.size()==n*m)
                    break;

                i = m - 1 - left;
                for (j = n - 1 - botton; j >= left; j--) {
                    result.add(matrix[i][j]);
                }
                left++;
                if (result.size()==n*m)
                    break;

                j = top;
                for (i = m - 1 - left; i >= right; i--) {
                    result.add(matrix[i][j]);
                }
                top++;
                if (result.size()==n*m)
                    break;


            }
            return result;

        }
    }
}
