package com.mcxtzhang.cjchap6;

/**
 * Intro: 用实例域代替序数 ordinal()
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/4/16.
 * History:
 */
public class Test31 {

    public static void main(String[] args) {
        whichFruid(Fruit.APPLE);
        whichFruid(Fruit.PAN);
    }

    static void whichFruid(Fruit fruit) {
        System.out.println(fruit);
        System.out.println(fruit.ordinal());
        System.out.println(fruit.getNumberOfFruit());
    }

    enum Fruit {
        APPLE(1), PAN(2), ORANGE(3);

        private final int numberOfFruit;

        Fruit(int numberOfFruit) {
            this.numberOfFruit = numberOfFruit;
        }

        public int getNumberOfFruit() {
            return numberOfFruit;
        }
    }
}
