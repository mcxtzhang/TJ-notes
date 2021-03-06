package com.mcxtzhang;

import com.mcxtzhang.algorithm.leetcode.Test23_MergeKSortedList.ListNode;
import com.mcxtzhang.chapter8.ExtendInitOrderTest;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("d");
        list.add(null);
        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        sb.append(1)
                .append("->")
                .append(1)
                .append("->")
                .append(100)
                .append("->");

        //only del one char
        System.out.println(sb.delete(sb.length() - 2, sb.length() - 1));
       /* System.out.println(sb.deleteCharAt(sb.length()-1));
        System.out.println(sb.deleteCharAt(sb.length()-1));
        System.out.println(sb.deleteCharAt(sb.length()-1));*/

/*        int i = sb.lastIndexOf(String.valueOf(100));
        System.out.println(i);
        System.out.println(sb.delete(i,sb.length()));


        sb = new StringBuilder();
        sb.append(1);

        i = sb.lastIndexOf(String.valueOf(1));
        System.out.println(i);
        System.out.println(sb.delete(i,sb.length()));*/


        System.out.println(1 % 5);
        System.out.println(5 % 5);
        System.out.println((-1) % 5);

        int a = 1;
        int b = 1;

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);


        float price = 89.89f;
        int itemNum = 3;
        float totalPrice = price * itemNum;
        System.out.println(totalPrice);
        float round = Math.round(totalPrice * 100);
        System.out.println(round);
        float num = (float) (round / 100);//如果要求精确4位就*10000然后/10000
        System.out.println(num);


        String hint = "识图中...";
        String hint2 = hint.substring(0, hint.length() - 1);
        String hint3 = hint.substring(0, hint.length() - 2);

        System.out.println(hint);
        System.out.println(hint2);
        System.out.println(hint3);


        System.out.println(System.currentTimeMillis());
        try {
            String a5 = null;
            System.out.println(System.currentTimeMillis());
            a5.toString();
        } catch (Exception e) {
            System.out.println(System.currentTimeMillis());
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());


        System.out.println(Math.random() * 1000);

        System.out.println(ExtendInitOrderTest.class.getName());
        System.out.println(ExtendInitOrderTest.class.getCanonicalName());
        System.out.println(ExtendInitOrderTest.class.getSimpleName());
        System.out.println(ExtendInitOrderTest.class.getPackage());


        System.out.println("保留小数点后两位");
        System.out.println(formatFps(12.23456));
        System.out.println(formatFps(0.23456));
        System.out.println(m4(12.23456f));
        System.out.println(m4(0.23456f));
        System.out.println(formatFloat(12.23456f));
        System.out.println(formatFloat(0.23456f));


        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("dddd");
            }
        }).start();
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





        long frameNums = Long.MAX_VALUE / 16;
        System.out.println("frameNums:" + frameNums);
        System.out.println(frameNums/10000);
        System.out.println(frameNums/10000/10000);


        List<String> list1  = new ArrayList<>(9);
        for (int i = 0; i < 10; i++) {
            list1.add(null);
        }
        System.out.println(list1);
        list1.get(5);




    }

    public static void change(String string, char[] chars) {
        string = "changed";
        chars[0] = 'c';
    }

    public static float formatFps(double originFps) {
        return ((float) Math.round(originFps * 100) / 100);
    }


    public static String m4(float f) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(f);
    }

    public static float formatFloat(float origin) {
        BigDecimal bd = new BigDecimal(origin);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
