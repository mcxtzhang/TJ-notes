package com.mcxtzhang.algorithm.leetcode;

/**
 * Intro:
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/9.
 * History:
 */
public class Test36_ValidSudoku {
    public static void main(String[] args) {
        char[] c1 = new char[]{'.', '8', '7', '6', '5', '4', '3', '2', '1'};
        char[] c2 = new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c3 = new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c4 = new char[]{'4', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c5 = new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c6 = new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c7 = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c8 = new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] c9 = new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[][] src = new char[][]{c1, c2, c3, c4, c5, c6, c7, c8, c9};
        new Solution().isValidSudoku(src);
    }

    public static class Solution {
        public boolean isValidSudoku(char[][] board) {
            if (board == null || board.length != 9 || board[0].length != 9) return false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char current = board[i][j];
                    if (current != '.') {
                        for (int k = 0; k < board[i].length; k++) {
                            if (k != j && board[i][k] == current) {
                                return false;
                            }
                        }
                        for (int k = 0; k < board.length; k++) {
                            if (k != i && board[k][j] == current) {
                                return false;
                            }
                        }

                        int beginI = (i / 3) * 3;
                        int endI = (i / 3) * 3 + 3;

                        int beginJ = (j / 3) * 3;
                        int endJ = (j / 3) * 3 +3;
                        for (int m = beginI; m < endI; m++) {
                            for (int n = beginJ; n < endJ; n++) {
                                if (m != i && n != j && board[m][n] == current) {
                                    return false;
                                }
                            }
                        }

                    }
                }
            }
            return true;

        }

    }
}
