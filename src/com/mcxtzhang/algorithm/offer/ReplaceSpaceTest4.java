package com.mcxtzhang.algorithm.offer;

/**
 * Intro: 替换空格   和 合并两个有序数组
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
        src = "Wearehappy";
        System.out.println(replaceSpace(src));
        src = "";
        System.out.println(replaceSpace(src));
        src = " ";
        System.out.println(replaceSpace(src));
        src = "  ";
        System.out.println(replaceSpace(src));
        src = null;
        System.out.println(replaceSpace(src));


        System.out.println("准备合并两个有序数组");
        int[] src1 = new int[20];
        int[] src2 = new int[10];
        for (int i = 0; i < 10; i++) {
            src1[i] = i * 5;
            src2[i] = i * 10;
        }

        for (int i : src1) {
            System.out.print(i + ",");
        }
        System.out.println();
        for (int i : src2) {
            System.out.print(i + ",");
        }

        System.out.println("合并两个有序数组");
        merge2OrderedArrays(src1, src2);

        for (int i : src1) {
            System.out.print(i + ",");
        }

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


    /**
     * 合并两个有序的数组
     *
     * @param src1
     * @param src2
     */
    public static void merge2OrderedArrays(int[] src1, int[] src2) {
        if (src1 == null || src2 == null) {
            return;
        }

        int j = 0;
        for (int i = 1; i < src1.length; i++) {
            if (src1[i] == 0) {
                j = i - 1;
                break;
            }
        }

        int k = src2.length - 1;
        for (int i = src1.length - 1; i >= 0; i--) {
            if (j == -1) {
                src1[i] = src2[k];
                k--;
            } else if (k == -1) {
                src1[i] = src1[j];
                j--;
            } else if (src1[j] > src2[k]) {
                src1[i] = src1[j];
                j--;
            } else {
                src1[i] = src2[k];
                k--;
            }
        }
    }
}
