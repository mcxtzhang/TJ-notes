package com.mcxtzhang.chapter12;

/**
 * Created by Administrator on 2017/3/27.
 */
public class ExceptionInfoTest {
    public static void main(String[] args) {

        try {
            throw new Exception("Sb errors!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println("e.getClass().getName():" + e.getClass().getName());
            System.out.println("getSimpleName():" + e.getClass().getSimpleName());
            System.out.println("getCanonicalName :" + e.getClass().getCanonicalName());
            System.out.println("getTypeName :" + e.getClass().getTypeName());
            //e.printStackTrace();

            System.out.println("=====================Get StackTraceElement===================:");
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println(stackTraceElement.getMethodName());
                System.out.println("Cst Print:" + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")");
                System.out.println(stackTraceElement);
            }
        }
    }
}
