package com.mcxtzhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intro:119. Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/21.
 * History:
 */
public class Test119 {
    public static void main(String[] args) {
        new ArrayList<>();
    }

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex < 0) return new ArrayList<>();
            //从1 开始到rowIndex，一层一层构建，最后返回rowIndex这一层的数据
            //每一层内部构建时，从后向前构建，直接覆盖。（从前往后的话，数据会不正确）

            Integer[] temp = new Integer[rowIndex + 1];
            for (int i = 0; i <= rowIndex; i++) {

                for (int j = i; j >= 0; j--) {
                    if (j == i || j == 0) {
                        temp[j] = 1;
                    } else {
                        temp[j] = temp[j] + temp[j - 1];
                    }
                }
            }
            List<Integer> result = Arrays.asList(temp);
            return result;


        }
    }
}
