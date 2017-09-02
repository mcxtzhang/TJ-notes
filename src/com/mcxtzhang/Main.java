package com.mcxtzhang;

public class Main {

    public static void main(String[] args) {
        // write your code here
/*        System.out.println(new DefaultClass().a);

        System.out.println(null instanceof Object);

        class methodInnerClass {
            private int i;
        }

        methodInnerClass test = new methodInnerClass();
        test.i = 455;

        System.out.println(test.i);


*//*        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5");
        for (String temp : a) {
            if ("1".equals(temp)) {
                a.remove(temp);
            }
        }*//*


        //String 在函数中 是值传递 还是引用传递
        System.out.println("***********在函数中 是值传递 还是引用传递********************************");
        String before = "before";
        char[] beforeChars = new char[]{'a', 'b', 'c'};
        System.out.println(before);
        System.out.println(beforeChars);

        change(before,beforeChars);
        System.out.println(before);
        System.out.println(beforeChars);*/

/*        String s = "2.0.0".replaceAll("\\.", "");
        System.out.println(s);
        s = "2.0.0".replace(".", "");
        System.out.println(s);

        s = "my.test.txt";
        System.out.println(s.replace(".", "#"));
        System.out.println(s.replaceAll(".", "#"));
        System.out.println(s.replaceFirst(".", "#"));*/


/*        Double a=1.0;
        Double b=1.0;
        Integer c=1;
        Integer d=1;
        System.out.println(a==b);
        System.out.println(c==d);*/


/*        String a ="123";
        String b = a+"4";
        String c =a+"4";
        System.out.println(b==c);*/

        Integer a = -129;//-128 ~ 127 是true
        Integer b = -129;
        System.out.println(a == b);
        Integer c = a + 1;
        Integer d = a + 1;
        System.out.println(c == d);
    }

    public static void change(String string, char[] chars) {
        string = "changed";
        chars[0] = 'c';
    }
}
