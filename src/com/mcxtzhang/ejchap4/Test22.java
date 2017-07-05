package com.mcxtzhang.ejchap4;

/**
 * Intro: 私有 静态成员类， 不应该能被导出在 公有 静态final 域里？
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/17.
 * History:
 */
public class Test22 {

    public static final InnerClass INNER_CLASS = new InnerClass(2);

    public Test22() {

    }

    private static class InnerClass {
        private int value;

        public InnerClass(int value) {
            this.value = value;
        }

        public void func() {
            System.out.println(value);
        }
    }
}
