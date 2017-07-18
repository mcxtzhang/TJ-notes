package com.mcxtzhang.chapter21;

import java.io.IOException;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/7/18.
 * History:
 */
public class Test671 {


    private static class UI extends Thread {
        private static volatile double d = 1;

        public UI() {
            setDaemon(true);
            start();
        }

        @Override
        public void run() {
            while (true) {
                d = d + (Math.PI + Math.E) / d;
            }
        }


        public static void main(String[] args) throws IOException {
            new UI();
            System.in.read();
            System.out.println(d);
        }
    }


}
