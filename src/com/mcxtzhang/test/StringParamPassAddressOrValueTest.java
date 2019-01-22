package com.mcxtzhang.test;

public class StringParamPassAddressOrValueTest {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        class1.fun();
        class2.fun();
    }

    public static String getString(String text) {
        if (text == null) {
            return null;
        } else {
            text = "modified";
            return text;
        }
    }

    private static class Class1 {
        String mText;

        public void fun() {
            getString(mText);
            System.out.println("Class1::mText=" + mText);
        }
    }

    private static class Class2 {
        String mText;

        public void fun() {
            getString(mText);
            System.out.println("Class2::mText=" + mText);
        }
    }
}
