package com.mcxtzhang.ejchap5;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 利用 有限制通配符 来提升API的灵活性
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/16.
 * History:
 */
public class Test28 {
    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();
        //list.add("a");
        //list.add(new Object());


    }

    //类型参数和通配符之间具有双重性，许多方法都可以利用其中一个或者另一个进行声明
    //一般来说，如果类型参数只在方法声明中出现一次，就可以用通配符取代它。
    public static <E> void swap1(List<E> list, int i, int j) {
    }

    public static void swap2(List<?> list, int i, int j) {

    }

    public static <E> void swap3(E list, int i, int j) {

    }
    //这个是错误的， 因为E不是类型参数
/*    public static void swap4(? list, int i, int j) {

    }*/
}
