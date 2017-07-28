package com.mcxtzhang.algorithm.offer;

/**
 * 不能继承的类 (用枚举做， 因为枚举被编译器设定为 final。 或者私有构造函数)
 * Created by Administrator on 17-7-28.
 */
public class Test48 {
    public static void main(String[] args){
        CanNotExtendClass a;
        a =CanNotExtendClass.INSTANCE;
        a.func();
    }

    private static enum CanNotExtendClass{
        INSTANCE;
        public void func(){
            System.out.println("I am in enum.");
        }
    }

/*    private static class Child extends CanNotExtendClass{

    }*/
}
