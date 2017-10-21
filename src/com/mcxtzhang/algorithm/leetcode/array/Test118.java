package com.mcxtzhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/21.
 * History:
 */
public class Test118 {
    public static void main(String[] args){
    new Solution().generate(5);
    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            //第 n行的元素，0为1， n-1为1， i(0,n-1)为， 上一行（n-1）里对应 i-1, i 相加

            List<List<Integer>> result = new ArrayList<>();
            if(numRows<1) return result;

            List<Integer> rowDatas ;
            for(int i=0;i<numRows;i++){
                rowDatas =  new ArrayList<>();

                for(int j=0;j<=i;j++){
                    if(j==0 || j==i){
                        rowDatas.add(1);
                    }else{
                        rowDatas.add( result.get(i-1).get(j-1) +  result.get(i-1).get(j) );
                    }
                }


                result.add(rowDatas);
            }
            return result;

        }
    }

}
