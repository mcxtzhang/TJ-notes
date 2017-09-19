package com.mcxtzhang;

public class TestMain {
    public static void  main(String[] args){
        hello();
    }
    
    public static void hello() {
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        
        System.out.println(className);
        System.out.println(methodName);
        System.out.println(lineNumber);
    }
}