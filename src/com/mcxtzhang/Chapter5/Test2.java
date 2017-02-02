package com.mcxtzhang.Chapter5;

public class Test2 {
      
    {  
        a = 4;  
    }  
      
    private final int a;//这里我并没有对a做初始化。  
      
    public static void main(String[] args){  
        Test2 test2 = new Test2();  
        System.out.println(test2.a);//4
    }  
}  