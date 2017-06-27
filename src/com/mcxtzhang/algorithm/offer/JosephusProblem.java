package com.mcxtzhang.algorithm.offer;

/**
 * Intro:  约瑟夫环
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/27.
 * History:
 */
public class JosephusProblem {
    public static void main(String[] args){

        int[] src = new int[30];

        System.out.println(finalOne(src,0,1)); ;
    }

    /**
     * 从k开始，数到m出圈
     *
     * @param src
     * @param k
     * @param m
     * @return
     */
    public static int finalOne(int[] src, int k, int m) {
        if (src == null || src.length == 0 || m <= 0 || k < 0) {
            return -1;
        }
        int result = -1;
        int deadCount = 0;
        int jCount = 0;//对应 m
        int i = 0 + k; //对应数组下标
        while (deadCount != src.length) {
            if (src[i % src.length] != -1) {//没出局的人里计数  排查
                jCount++;//数一个数字
                if (jCount == m) { //找到了  该死了
                    deadCount++;
                    src[i % src.length] = -1;
                    jCount = 0;
                    if (deadCount == src.length) {
                        result = i % src.length;
                    }
                    System.out.println("当前死的人是："+i % src.length);
                } else {
                    jCount++;
                }
                i++;
            } else {
                i++;
            }
        }
        return result;
    }
}
