package com.mcxtzhang.Chapter3;

/**
 * Created by Administrator on 17-1-29.
 */
public class Random {
    public static void main(String[] arg) {
        //
        java.util.Random random = new java.util.Random(47);
        float v = random.nextFloat();
        float v1 = random.nextFloat();
        System.out.println(v);
        System.out.println(v1);

    }
}
