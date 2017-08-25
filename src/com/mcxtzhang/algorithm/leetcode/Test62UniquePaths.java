package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:Unique Paths
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/25.
 * History:
 */
public class Test62UniquePaths {
    public static void main(String[] args) {
        new Solution().uniquePaths(3, 3);
    }

    static class Solution {
        public int uniquePaths(int m, int n) {
            if (m <= 1 || n <= 1) return 1;
            int[][] paths = new int[m][n];
            for (int i = 0; i < m; i++) {
                paths[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                paths[0][i] = 1;
            }


            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
            return paths[m - 1][n - 1];
        }
    }
}
