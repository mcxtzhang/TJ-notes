package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 顺时针打印矩阵
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/4.
 * History:
 */
public class Test20 {
    public static void main(String[] args) {
        int[][] src = new int[0][0];
        printMatrix(src);
        printMatrix(null);

        src = new int[5][5];
        int temp = 1;
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                src[i][i1] = temp++;
            }
        }


        for (int[] ints : src) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }


        printMatrix(src);

    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        System.out.println("开始打印矩阵");
        if (matrix == null) return;
        int m = matrix.length;
        if (m <= 0) return;
        int n = matrix[0].length;

        int max = Math.max(m, n);
        max = max / 2;


        for (int i = 0; i <= max; i++) {
            for (int j = i; j <= m - 1 - i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            for (int j = i + 1; j <= n - 1 - i; j++) {
                System.out.print(matrix[j][m - 1 - i] + " ");
            }
            for (int j = m - 2 - i; j >= i; j--) {
                System.out.print(matrix[n - 1 - i][j] + " ");
            }
            for (int j = n - 2 - i; j >= i + 1; j--) {
                System.out.print(matrix[j][i]+ " ");
            }
            System.out.println();
        }


    }
}
