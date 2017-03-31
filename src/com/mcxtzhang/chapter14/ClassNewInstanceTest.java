package com.mcxtzhang.chapter14;

/**
 * Intro: 直接用 A.class.newInstance() 创建实例 可以
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/31.
 * History:
 */
public class ClassNewInstanceTest {

    public static void main(String[] args) {
        try {
            A a = A.class.newInstance();
            System.out.println(a.sth);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
