package gengsc.algo.sorting.basic;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * 插入排序有序的时候,复杂度会变成O(N)
 * @Author shichaogeng
 * @Create 2018-01-21 17:36
 */
public class InsertionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            /*for (int j = i; j > 0; j--) {
                if (SortTestHelper.less(arr[j], arr[j - 1])) {
                    SortTestHelper.swapArray(arr, j, j - 1);
                } else {
                    break;
                }
            }*/


            //条件放到for中
            /*for (int j = i; j > 0 && SortTestHelper.less(arr[j], arr[j - 1]); j--) {
                SortTestHelper.swapArray(arr, j, j - 1);
            }*/

            //不必每次交换位置,减少赋值操作
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && SortTestHelper.less(e, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
