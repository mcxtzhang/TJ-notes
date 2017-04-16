package com.mcxtzhang.ejchap6;

import java.util.EnumSet;

/**
 * Intro: 用EnumSet代替位域
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/16.
 * History:
 */
public class Test32 {
    public static void main(String[] args) {
        EnumSet<Style> bold = EnumSet.of(Style.BOLD, Style.ITALIC);
        System.out.println(bold);
    }

    enum Style {
        BOLD, ITALIC, UNDERLINE;
    }
}
