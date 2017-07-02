package com.mcxtzhang.algorithm.offer;

/**
 * 调整 数组顺序 使    奇数位于偶数前面
 * Created by pc on 2017/7/2.
 */
public class Test14 {
    public static void main(String[] rags) {
        Integer[] src = new Integer[]{1, 2, 3, 4, 5};
        reorderArray(src, integer -> (integer & 1) == 1);

        for (Integer integer : src) {
            System.out.println(integer);
        }

    }

    private static interface IOrder<T> {
        public boolean first(T t);
    }

    public static <T> void reorderArray(T[] array, IOrder<T> iOrder) {
        if (array == null || array.length <= 1 || iOrder == null)
            return;
        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            while (first < last && iOrder.first(array[first])) {
                first++;
            }
            if (!iOrder.first(array[first])) {
                while (first < last && !iOrder.first(array[last])) {
                    last--;
                }
                if (iOrder.first(array[last])) {
                    T temp = array[first];
                    array[first] = array[last];
                    array[last] = temp;
                    first++;
                    last--;
                }
            }
        }
    }
}
