package com.mcxtzhang.Chapter2;

/**
 * Created by Administrator on 17-1-29.
 */
public class First {
    public static void main(String[] arg) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
    }
}
