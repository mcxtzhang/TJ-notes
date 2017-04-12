package com.mcxtzhang.ejchap4;

/**
 * Intro: 一个不可变类
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/11.
 * History:
 */
public class ImmutableExampleTest {
    private final int value;

    public ImmutableExampleTest(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImmutableExampleTest add(ImmutableExampleTest b) {
        return new ImmutableExampleTest(value + b.value);
    }
}
