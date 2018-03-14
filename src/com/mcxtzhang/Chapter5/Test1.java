package com.mcxtzhang.Chapter5;

/**
 * copy from http://blog.csdn.net/luohuacanyue/article/details/13169173
 */
public class Test1 {
    {
        a = 1;
        //System.out.println(a);//这里会抛错。
    }
    private int a=2;//这里初始化一次，上面的动态块中也对a进行了赋值，这个时候a=?，为什么可以对a进行赋值，而不可以对a进行输出
    //如果不对a 赋值， a 是 1
    public static void main(String[] args){  
        Test1 test1 = new Test1();  
        System.out.println(test1.a);  
    }  
}  