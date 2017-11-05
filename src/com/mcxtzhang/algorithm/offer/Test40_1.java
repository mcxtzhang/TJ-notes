package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 数组中只出现一次的数字
 * 一个整形数组中，除了两个数字以外，其他的数字都出现了两次。
 * 请写出程序找出这两个只出现一次的数字。要求时间复杂度是o n.
 * 空间复杂度o 1.
 * <p>
 * 2017 10 31 ：
 * 之前的方法 遍历三次数组，这里可以改为遍历两次。
 * 第一次找到一个数，求出这个数里第一个1出现的位数，
 * 后面根据这个位数 分别用两个数字去 亦或。得到最终结果
 * <p>
 * <p>
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/21.
 * History:
 */
public class Test40_1 {
    public static void main(String[] args) {
        int[] src = new int[]{2, 4, 3, 6, 3, 2, 5, 5};

        int[] onceNums = getOnceNums(src);
        System.out.println("最终的结果" + onceNums);
        for (int i : onceNums) {
            System.out.println(i);
        }

    }

    public static int[] getOnceNums(int[] src) {
        int[] result = new int[2];
        if (null == src || src.length < 1) return result;

        int temp = 0;
        for (int i : src) {
            temp ^= i;
        }

        System.out.println("第一遍亦或的结果是" + temp);
        int index = findFirst1Index(temp);
        System.out.println("低位起，第一个1的位数是:" + index);

        int num1 = 0, num2 = 0;
        for (int i : src) {
            if (isSameIndex1(i, index)) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;

    }

    //找到第一个1的位数
    public static int findFirst1Index(int num) {
        int index = 1;
        //第一位是0
        while ((num & 0x01) == 0) {
            index++;
            num = num >>> 1;
        }
        return index;
    }

    /**
     * num 的 index位 是否为1
     *
     * @param num
     * @param index
     * @return
     */
    public static boolean isSameIndex1(int num, int index) {
        num = num >>> (index - 1);
        if ((num & 0x01) == 0) return false;
        else return true;
    }

}
