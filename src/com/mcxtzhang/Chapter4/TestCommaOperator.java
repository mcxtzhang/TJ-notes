package com.mcxtzhang.Chapter4;

/**
 * Created by Administrator on 17-1-31.
 */
public class TestCommaOperator {
    public static void main(String[] arg) {
        for (int i = 0,j=i+1; i < 10; j++,i++) {
            System.out.println(i+","+j);
        }
    }
}
