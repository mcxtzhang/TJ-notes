package com.mcxtzhang.reflect;

import java.lang.reflect.Field;

/**
 * Intro:
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/8/12.
 * History:
 */
public class ReplaceFieldTest {
    public static void main(String[] args){
        Work programmer = new Work("程序员");
        Work pm = new Work("产品经理");
        Person person = new Person("mcxtzhang","男",pm);
        System.out.println(person);

        try {
            Field mWork = person.getClass().getDeclaredField("mWork");
            mWork.setAccessible(true);
            mWork.set(person,programmer);
            System.out.println("After replace："+person);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static class Person {
        private String name;
        private String sex;
        private Work mWork;

        public Person(String name, String sex, Work work) {
            this.name = name;
            this.sex = sex;
            mWork = work;
        }

        public String getName() {
            return name;
        }

        public Person setName(String name) {
            this.name = name;
            return this;
        }

        public String getSex() {
            return sex;
        }

        public Person setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Work getWork() {
            return mWork;
        }

        public Person setWork(Work work) {
            mWork = work;
            return this;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", mWork=" + mWork +
                    '}';
        }
    }

    public static class Work {
        private String work;

        @Override
        public String toString() {
            return "Work{" +
                    "work='" + work + '\'' +
                    '}';
        }

        public Work(String work) {
            this.work = work;
        }

        public String getWork() {
            return work;
        }

        public Work setWork(String work) {
            this.work = work;
            return this;
        }
    }
}
