package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 二维数组中的查找
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/26.
 * History:
 */
public class DimensionalArraySearchTest3 {
    public static void main(String[] args) {
        int[][] src = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 7;
        dimensionalArraySearch(src, target);
    }





    public static void dimensionalArraySearch(int[][] src, int searchKey) {
        int j = src[0].length - 1;
        for (int i = 0; i < src.length; i++) {
            for (; j >= 0; j--) {
                System.out.println("遍历到:" + i + "," + j);
                int temp = src[i][j];
                if (temp == searchKey) {
                    System.out.println("找到了" + i + "," + j);
                    return;
                } else if (temp < searchKey) {
                    //小于，下一行
                    break;
                } else {//大于 删除这一列的， 向左列继续查询
                    continue;
                }
            }
        }
    }
}
