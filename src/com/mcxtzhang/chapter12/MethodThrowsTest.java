package com.mcxtzhang.chapter12;

/**
 * Created by Administrator on 2017/3/27.
 */
public class MethodThrowsTest {

    public static void main(String[] args) {

        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f() throws Exception {
        System.out.println("实际上我没抛出任何异常");
    }
}
