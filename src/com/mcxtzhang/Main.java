package com.mcxtzhang;

import com.mcxtzhang.algorithm.leetcode.Test23_MergeKSortedList.ListNode;

import java.math.BigDecimal;

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
/*
        Integer a = -129;//-128 ~ 127 是true
        Integer b = -129;
        System.out.println(a == b);
        Integer c = a + 1;
        Integer d = a + 1;
        System.out.println(c == d);*/

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1.next, cur2 = dummy2.next;
        cur1 = new ListNode(3);
        System.out.println(dummy1);

        System.out.println(1 % 2);
        System.out.println(-1 % 2);


        String url = "tel:15012345678";
        if (url.startsWith("tel:")) {
            String phone = url.substring(url.indexOf(':') + 1);
            System.out.println(phone);
        }


        double limitPrice = 20;
        //2 然后获取到本地购物车 ，当前物品所属店铺 所有选中物品的总金额
        double localSumPrices = 1;
        if (limitPrice > localSumPrices && localSumPrices > 0) {
            BigDecimal subtract = new BigDecimal(limitPrice).subtract(new BigDecimal(localSumPrices));
            double f1 = subtract.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            System.out.println(f1);
        }


        StringBuilder sb = new StringBuilder();
        sb.append(1)
                .append("->")
                .append(1)
                .append("->")
                .append(1)
                .append("->");

        //only del one char
        System.out.println(sb.delete(sb.length()-2,sb.length()-1));


    }

    public static void change(String string, char[] chars) {
        string = "changed";
        chars[0] = 'c';
    }
}
