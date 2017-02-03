package com.mcxtzhang.Chapter5;

import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/2/3.
 */
public class Enum {
    public static void main(String[] args) {
        TYPE type = TYPE.HANDSOME;
        System.out.println(type);
        System.out.println(type.ordinal());
        System.out.println(TYPE.values());
    }

    enum TYPE {
        HANDSOME, TALL, HIGH, LONG
    }
}
