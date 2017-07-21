package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 数组中只出现一次的数字
 * 一个整形数组中，除了两个数字以外，其他的数字都出现了两次。
 * 请写出程序找出这两个只出现一次的数字。要求时间复杂度是o n.
 * 空间复杂度o 1.
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/21.
 * History:
 */
public class Test40 {
    public static void main(String[] args) {
        int[] src = new int[]{2, 4, 3, 6, 3, 2, 5, 5};

        int[] onceNums = getOnceNums(src);
        System.out.println("最终的结果" + onceNums);
        for (int i : onceNums) {
            System.out.println(i);
        }

    }

    public static int[] getOnceNums(int[] src) {

        if (src == null || src.length < 2) return null;
        int[] result = new int[2];

        int temp = src[0];
        for (int i = 1; i < src.length; i++) {
            temp = temp ^ src[i];
        }

        System.out.println("亦或所有数的结果:" + temp);
        int firstBit1 = findFirstBit1(temp);
        System.out.println("第一个是1的是第几位:" + firstBit1);

        int filterNum = getFilterNum(firstBit1);
        System.out.println("用于筛选的数字是 :" + filterNum);

        int lastBit0index = src.length - 1;
        for (int i = 0; i < src.length && i <= lastBit0index; i++) {
            if ((src[i] & filterNum) == filterNum) {//条件为为1 分成一组
                temp = src[i];
                src[i] = src[lastBit0index];
                src[lastBit0index] = temp;

                lastBit0index--;
                i--;
            } else {

            }
        }
        //经过上面的，应该已经将 数组里的数字，以  lastBit0Index  分割开了 [0,lastBit0Index] = 指定位为0 的
        temp = 0;
        for (int i = 0; i <= lastBit0index; i++) {
            temp = src[i] ^ temp;
        }
        result[0] = temp;
        temp = 0;
        for (int i = lastBit0index + 1; i < src.length; i++) {
            temp = temp ^ src[i];
        }
        result[1] = temp;
        return result;
    }

    //找出从低位(1)起，第一个为1的是第几位
    public static int findFirstBit1(int num) {
        int result = 1;
        while ((num & 0x1) != 0x1) {
            num = num >>> 1;
            result++;
        }
        return result;
    }

    public static int getFilterNum(int whichIndex1) {
        return 0x1 << (whichIndex1 - 1);
    }
}
