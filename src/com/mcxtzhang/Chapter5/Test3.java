package com.mcxtzhang.Chapter5;

public class Test3 {
    {  
        a = 4;  
        System.out.println(a);//这里不会报错，但是这条语句并不会执行  
    }  
    private static int a;  
      
    public static void main(String[] args){
        System.out.println(a);
    }  
}  