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



        TransformRefOrValue obj = new TransformRefOrValue(2);
        testTransformValue(obj);
        System.out.println(obj);
    }


    public static void testTransformValue(TransformRefOrValue object){
        object = new TransformRefOrValue(10);
    }
}

class T {
    static String aString = "abc";
    String bString = "abc";
}

class TransformRefOrValue{
    private int value ;

    public TransformRefOrValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TransformRefOrValue{" +
                "value=" + value +
                '}';
    }
}