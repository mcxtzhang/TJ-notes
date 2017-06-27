package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 替换空格
 * Author: zhangxutong
 * E-mail: mcxtzhang@163.com
 * Home Page: http://blog.csdn.net/zxt0601
 * Created:   2017/6/27.
 * History:
 */
public class ReplaceSpaceTest4 {
    public static void main(String[] args) {
        String src = " We are happy ";
        String s = src.replaceAll(" ", "%20");
        System.out.println(s);


        System.out.println(replaceSpace(src));


    }

    public static String replaceSpace(String src) {
        if (src == null || src.length() <= 0) {
            return "";
        }
        //step 1 ,compute the count of space
        int spaceCount = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == ' ') {
                spaceCount++;
            }
        }
        //step 2,
        char[] result = new char[spaceCount * 2 + src.length()];
/*        int i = result.length - 1;
        int j = src.length() - 1;

        char temp;
        while (i >= 0 && j >= 0) {
            temp = src.charAt(j);
            if (temp != ' ') {
                result[i] = temp;
            } else {
                //step 3 replace space
                result[i] = '0';
                result[i-1] = '2';
                result[i-2] = '%';
                i=i-2;
            }
            i--;
            j--;
        }*/
        char temp;
        int j = 0;
        for (int i = 0; i < src.length(); i++) {
            temp = src.charAt(i);
            if (temp == ' ') {
                result[j] = '%';
                result[j + 1] = '2';
                result[j + 2] = '0';
                j += 3;
            } else {
                result[j] = temp;
                j++;
            }

        }


        return new String(result);
    }
}
