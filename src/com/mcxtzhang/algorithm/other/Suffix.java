package com.mcxtzhang.algorithm.other;

/**
 * Intro: 判断一个字符数组是否以suffix结尾，并写出case
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/15.
 * History:
 */
public class Suffix {
    public static void main(String[] args){
        //  I am a programmer, programmer
        //  I am a programmer, programme
        //  I am a programmer, rogrammer
        //  I am a programmer, a
        //  I am a programmer, prorammer
        //  I am a programmer, null
        //  I am a programmer, []

        //  null, programmer
        //  null, null
        //  null, []
        //  [], []

        System.out.println(endWithSuffix("I am a programmer".toCharArray(),"programmer".toCharArray()));//true
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),"programme".toCharArray()));//false
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),"rogrammer".toCharArray()));//true
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),"a".toCharArray()));//false
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),"r".toCharArray()));//true
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),"prorammer".toCharArray()));//false
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),null));//false
        System.out.println(endWithSuffix("I am a programmer".toCharArray(),new char[0]));//true

        System.out.println(endWithSuffix(null,"programmer".toCharArray()));//false
        System.out.println(endWithSuffix(null,null));//false
        System.out.println(endWithSuffix(null,new char[0]));//false
        System.out.println(endWithSuffix(new char[0],new char[0]));//true


    }



    public static boolean endWithSuffix(char[] originalString, char[] suffix) {
        //1 空 2 长度 3 suffix的长度
        if (null == originalString || null == suffix) return false;
        if (suffix.length > originalString.length) return false;
        if (suffix.length == 0) return true;

        for (int i = 0; i < suffix.length; i++) {
            if (suffix[suffix.length - 1 - i] != originalString[originalString.length - 1 - i]) {
                return false;
            }
        }
        return true;

    }

}
