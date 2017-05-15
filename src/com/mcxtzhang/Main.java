package com.mcxtzhang;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(new DefaultClass().a);

        System.out.println(null instanceof Object);

        class methodInnerClass {
            private int i;
        }

        methodInnerClass test = new methodInnerClass();
        test.i = 455;

        System.out.println(test.i);


/*        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }*/


        //String 在函数中 是值传递 还是引用传递
        System.out.println("***********在函数中 是值传递 还是引用传递********************************");
        String before = "before";
        char[] beforeChars = new char[]{'a', 'b', 'c'};
        System.out.println(before);
        System.out.println(beforeChars);

        change(before,beforeChars);
        System.out.println(before);
        System.out.println(beforeChars);
    }

    public static void change(String string, char[] chars) {
        string = "changed";
        chars[0] = 'c';
    }
}
