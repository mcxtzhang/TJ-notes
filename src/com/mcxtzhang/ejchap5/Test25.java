package com.mcxtzhang.ejchap5;

import java.util.ArrayList;
import java.util.List;

/**
 * Intro: 列表优先于数组
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/16.
 * History:
 */
public class Test25 {
    public static void main(String[] args) {

        //fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";//Throws ArrayStoreException

        //Won't compile
        //List<Object> listObject = new ArrayList<Long>();//Incompatible types
        List<String> stringList = new ArrayList<>();
    }
}
