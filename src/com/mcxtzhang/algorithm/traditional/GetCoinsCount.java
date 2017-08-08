package com.mcxtzhang.algorithm.traditional;

import java.util.Arrays;

/**
 * Intro: 硬币找零
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/8.
 * History:
 */
public class GetCoinsCount {
    public static void main(String[] args) {
        // 硬币面值预先已经按降序排列
        int[] coinValue = new int[]{25, 21, 10, 5, 1};
        // 需要找零的面值
        int money = 63;
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
        int[] coinsUsed = new int[money + 1];
        Arrays.fill(coinsUsed, -1);

        //getCoinsCount(coinValue,63,coinsUsed);
        System.out.println(getTargetCoinsCount(coinValue, 63, coinsUsed));
        //System.out.println(coinsUsed[63]);
    }

    /**
     * @param moneys 货币种类面值数组
     * @param target 需要找零的钱数
     * @param result 下标为需要找零的钱值， 值为 钱的数量
     */
    public static int getTargetCoinsCount(int[] moneys, int target, int[] result) {
        if (moneys == null || moneys.length < 1 || target < 1 || result == null)
            return 0;
        if (result[target] != -1) {
            return result[target];
        }

        int temp = 0;
        for (int money : moneys) {//循环每一种面值
            if (money <= target) {
                int targetCoinsCount = getTargetCoinsCount(moneys, target - money, result);
                if (temp == 0 || temp > targetCoinsCount + 1) {
                    temp = targetCoinsCount + 1;
                }
            }
        }
        result[target] = temp;
        return temp;
    }


    /**
     * @param moneys 货币种类面值数组
     * @param target 需要找零的钱数
     * @param result 下标为需要找零的钱值， 值为 钱的数量
     */
    public static void getCoinsCount(int[] moneys, int target, int[] result) {
        if (moneys == null || moneys.length < 1 || target < 1 || result == null)
            return;
        result[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int money : moneys) {
                if (money <= i) {
                    int temp = 1 + result[i - money];
                    if (result[i] == 0 || temp < result[i]) {
                        result[i] = temp;
                    }
                }
            }
            System.out.println("面值为 " + (i) + " 的最小硬币数 : "
                    + result[i]);
        }
    }
}
