package com.mcxtzhang.chapter9;

/**
 * 组合接口时的名字冲突
 * Created by xtzhang on 2017/3/2.
 */
public class CombineInterfaceWhitchMethodConflictTest {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
    }


}

interface I1 {

    void f();

}

interface I2 {

    int f(int i);

}

interface I3 {

    int f();

}

class C {

    public int f() {
        return 1;
    }

}

class C2 implements I1,I2{

    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 2;
    }
}

class C3 extends C implements I2{
    @Override
    public int f(int i) {
        return 3;
    }
}

class C4 extends C implements I3{
    //不用重写也可以编译通过

}


//编译不过  因为编译器懵逼了
/*
class C5 extends C implements I1{

}
*/


