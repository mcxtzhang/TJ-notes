package com.mcxtzhang.asm;

public class Person {
    public static void main(String[] args){
        Person p = new Person();
        p.talk();
        p.walk();
    }
    public void talk() {
        System.out.println("talk");
    }

    public void walk() {
        System.out.println("walk");
    }
}
