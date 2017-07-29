package com.mcxtzhang.algorithm.offer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * Created by Administrator on 17-7-29.
 */
public class Test44 {

    public static void main(String[] args){
        int[] src = new int[]{5,3,1,4,0};
        System.out.println(isContinuous(src));
        src = new int[]{5,3,1,1,0};
        System.out.println(isContinuous(src));
        src = new int[]{5,3,1,6,0};
        System.out.println(isContinuous(src));
    }

    public static boolean isContinuous(int[] src) {
        if (src == null || src.length < 5) return false;
        //先排序
        Arrays.sort(src);
        //计算大王的个数  和 各个数之间的差值，  大王个数  >= 各个数字之间的差值， 是顺子。 且不能有两个相同的牌
        int kingCount = 0;
        int gap = 0;

        for (int i = 0; i < src.length; i++) {
            if (src[i] == 0){
                kingCount++;
                continue;
            }else {
                if (i>0){
                    if (src[i-1] == src[i]){
                        return false;
                    }else {
                        gap = gap + src[i]-1-src[i-1];
                    }
                }
            }
        }
        if (kingCount >=gap ){
            return true;
        }else {
            return false;
        }
    }

}
