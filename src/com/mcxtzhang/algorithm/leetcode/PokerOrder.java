package com.mcxtzhang.algorithm.leetcode;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽 5 张牌,判断是不是顺子,即这 5 张牌是不是连续的。
 * 2-10 为数字本身,A 为 1,J 为 11,Q 为 12,K 为 13,而大小王可以看成任意的 数字。
 * <p>
 * Created by mcxtzhang on 2017/5/14.
 */
public class PokerOrder {
    public static final int WING = 0;

    public static void main(String[] args) {

        //大小王算作0

        int[] a = new int[]{1, 5, 2, 0, 9};
        System.out.println("是顺子嘛？" + isOrder(a));
    }

    /**
     * 解题思路：我们可以把5张牌看成是由5个数字组成的俄数组。大小王是特殊的数字，我们可以把它们都定义为0，这样就可以和其他的牌区分开来。
     * 首先把数组排序，再统计数组中0的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。
     * 如果空缺的总数小于或者等于0的个数，那么这个数组就是连续的，反之则不连续。
     * 如果数组中的非0数字重复出现，则该数组是不连续的。
     * 换成扑克牌的描述方式就是如果一幅牌里含有对子，则不可能是顺子。
     *
     * @param pokers
     * @return
     */
    public static boolean isOrder(int[] pokers) {
        Arrays.sort(pokers);

        int gap = 0;
        int wingNumss = 0;

        for (int poker : pokers) {
            if (poker == WING) {
                wingNumss++;
            }
        }

        for (int i = 0; i < pokers.length - 1; i++) {
            if (pokers[i] != WING) {
                if (pokers[i] == pokers[i + 1]) {
                    return false;
                }
                gap += pokers[i + 1] - pokers[i];
            }
        }

        if (gap - 5 <= wingNumss) {
            return true;
        } else {
            return false;
        }

    }

}
