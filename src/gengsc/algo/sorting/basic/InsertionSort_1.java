package gengsc.algo.sorting.basic;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * 插入排序有序的时候,复杂度会变成O(N)
 * 最好的情况:当数组有序时,只需要比较N-1次
 * 最坏的情况:数组逆序时,需要比较/交换次数为N(N-1)/2
 * @Author shichaogeng
 * @Create 2018-01-21 17:36
 */
public class InsertionSort_1 {

    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {

            //条件放到for中
            for (int j = i; j > 0 && SortTestHelper.less(arr[j], arr[j - 1]); j--) {
                SortTestHelper.swapArray(arr, j, j - 1);
            }

        }
    }
}
