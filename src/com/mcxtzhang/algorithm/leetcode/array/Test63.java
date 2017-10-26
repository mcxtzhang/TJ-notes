package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro:
 * <p>
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/26.
 * History:
 */
public class Test63 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0},{0,0}};
        new Solution().uniquePathsWithObstacles(a);
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // 行列
            int m  = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            //结果缓存
            int[][] paths = new int[m][n];

            //先给第一行的赋值
            for (int i = 0; i < m; i++) {
                if(obstacleGrid[i][0] == 0){
                    //考虑有障碍
                    if(i == 0 ){
                        paths[i][0] = 1;
                    }else{
                        paths[i][0] = paths[i-1][0];
                    }
                }else{
                    paths[i][0] = 0;
                }
            }
            //第一列
            for (int i = 0; i < n; i++) {
                if(obstacleGrid[0][i] == 0){
                    if(i==0){
                        paths[0][i] = 1;
                    }else{
                        paths[0][i] = paths[0][i-1];
                    }

                }else{
                    paths[0][i] = 0;
                }
            }

            //遍历里层
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    //如果当前走不通
                    if(obstacleGrid[i][j] == 1){
                        paths[i][j] = 0;
                    }else{
                        //走得通
                        paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                    }
                }
            }
            return paths[m - 1][n - 1];
        }
    }
}
