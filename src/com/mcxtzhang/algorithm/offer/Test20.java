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

        // 5*5
        src = new int[5][5];
        int temp = 1;
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                src[i][i1] = temp++;
            }
        }

        printMatrix(src);

        // 4*5
        src = new int[4][5];
        temp = 1;
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                src[i][i1] = temp++;
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

        int min = Math.min(m, n);
        min = (int) ((min+0.5f) / 2);

        for (int i = 0; i < min; i++) {
            for (int j = i; j <= n - 1 - i; j++) {
                System.out.print("向右:"+matrix[i][j] + " ");
            }
            System.out.println();
            for (int j = i + 1; j <= m - 1 - i; j++) {
                System.out.print("向下:"+matrix[j][n - 1 - i] + " ");
            }
            System.out.println();
            for (int j = n - 2 - i; j >= i; j--) {
                System.out.print("向左:"+matrix[m - 1 - i][j] + " ");
            }
            System.out.println();
            for (int j = m - 2 - i; j >= i + 1; j--) {
                System.out.print("向上:"+matrix[j][i] + " ");
            }
            System.out.println();
        }

    }
}
