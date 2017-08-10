package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/10.
 * History:
 */
public class Test48_RotateImage {
    public static void main(String[] args) {

    }

    public class Solution {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0].length != matrix.length) return;
            int temp;
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n+1) / 2; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }


        }
    }
}
