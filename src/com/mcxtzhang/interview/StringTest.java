package com.mcxtzhang.interview;

public class StringTest {
    private static String aString = "abc";
    public static void main(String[] args) {
        String aString = "abc";
        String bString = new String("abc");
        String cString = "abc";
        System.out.println(aString == new T().bString);
        System.out.println(aString == T.aString);
        System.out.println(aString == StringTest.aString);
        System.out.println(aString == cString);
        System.out.println(aString == bString);
        System.out.println(aString.equals(bString));
    }
}

class T {
    static String aString = "abc";
    String bString = "abc";
}