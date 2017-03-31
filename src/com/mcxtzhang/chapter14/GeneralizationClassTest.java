package com.mcxtzhang.chapter14;

/**
 * Intro: 泛化的类型，
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/3/31.
 * History:
 */
public class GeneralizationClassTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Child> childClass = Child.class;
        //可以
        Child child = childClass.newInstance();
        System.out.println(child.getClass());

        // getSuperclass() 必须是 ? super Child 形式接收
        Class<? super Child> parentClass1 = childClass.getSuperclass();
        //生成的是object
        Object object = parentClass1.newInstance();
        System.out.println(object.getClass());

        //强转可以
        Class<Parent> parentClass2 = (Class<Parent>) childClass.getSuperclass();
        System.out.println(parentClass2);

        Class<? super Child> superclass = childClass.getSuperclass();
        System.out.println(superclass);



/*        System.out.println("==============================");
        List<Child> testList = new ArrayList<>();
        Child a = new Child();
        for (int i = 0; i < 3; i++) {
            testList.add(a);
        }
        System.out.println(testList.size());
        for (Child child1 : testList) {
            System.out.println(child1);
        }*/


    }

}

class Parent {

}

class Child extends Parent {

}
