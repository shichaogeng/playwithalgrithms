package gengsc.algo.sorting.basic;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * 插入排序有序的时候,复杂度会变成O(N)
 * 优化交换次数
 * @Author shichaogeng
 * @Create 2018-01-21 17:36
 */
public class InsertionSort_2 {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {

            //不必每次交换位置,减少赋值操作
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && SortTestHelper.less(e, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > l && SortTestHelper.less(e, arr[j-1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
