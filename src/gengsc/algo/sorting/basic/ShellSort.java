package gengsc.algo.sorting.basic;

import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-23 11:42
 */
public class ShellSort {

    public static void sort(Comparable[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            //分组排序
            for (int i = gap; i < arr.length; i++) {
                Comparable e = arr[i];
                int j;
                for (j = i; j >= gap && SortTestHelper.less(arr[j], arr[j - gap]); j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = e;
            }
            gap = gap / 2;
        }
    }
}
