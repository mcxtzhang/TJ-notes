package com.mcxtzhang.interview;

/**
 * Intro: 初始化顺序
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/10/25.
 * History:
 */
public class InitOrder {

    public static void main(String[] args) {
        Base a = new Sub();
    }
}


class Base {
    private String baseName = "base";

    public Base() {
        func();
    }

    public void func() {
        System.out.println(baseName);
    }
}

class Sub extends Base {
    private String baseName = "sub";

    public Sub() {
        super();
        System.out.println("2:"+baseName);
    }

    @Override
    public void func() {
        System.out.println(baseName);
    }
}
