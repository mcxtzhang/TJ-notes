package com.mcxtzhang.Chapter5;

/**
 * Created by Administrator on 2017/2/3.
 */
public class Enum {
    public static void main(String[] args) {
        TYPE type = TYPE.HANDSOME;
        System.out.println(type);
        System.out.println(type.ordinal());
        System.out.println(TYPE.values());
        type.method1();
    }

    enum TYPE {
        HANDSOME, TALL, HIGH, LONG;

        public void method1(){
            System.out.println("method1");
        }
    }
}
