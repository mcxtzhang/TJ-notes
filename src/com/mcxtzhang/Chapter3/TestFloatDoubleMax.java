package com.mcxtzhang.Chapter3;

/**
 * Created by Administrator on 17-1-29.
 */
public class TestFloatDoubleMax {
    public static void main(String[] arg) {
        float a  = 2e38f;
        System.out.println(a);
        double b = 2e65;
        System.out.println(b);



        float fmax=Float.MAX_VALUE;
        float fmin=Float.MIN_VALUE;
        System.out.println(fmax);
        System.out.println(fmin);
    }
}
