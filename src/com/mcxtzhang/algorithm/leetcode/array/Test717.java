package com.mcxtzhang.algorithm.leetcode.array;

/**
 * Intro: 717. 1-bit and 2-bit Characters
 * <p>
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/11/3.
 * History:
 */
public class Test717 {
    class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            // 遍历数组，当前位是1，就步进2，
            // 当前位是0，就步进1，
            // 如果当前下标是数组最后一个且为0，则 返回true
            // 其他返回false。（正好遍历完 跳出循环也是false）
            for(int i=0; i<bits.length; ){
                if(i == bits.length-1  && bits[i]==0    ){
                    return true;
                }

                if(bits[i] ==1){
                    i = i+2;
                }else{
                    i = i+1;
                }

            }
            return false;

        }
    }
}
