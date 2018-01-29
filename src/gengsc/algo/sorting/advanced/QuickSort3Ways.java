package gengsc.algo.sorting.advanced;

import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-27 21:57
 */
public class QuickSort3Ways {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        Comparable v = arr[l];
        int lt = l;//l+1...lt
        int i = l + 1;//lt+1...i-1
        int gt = r + 1;//gt...r
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                SortTestHelper.swapArray(arr, ++lt, i++);
            } else if (arr[i].compareTo(v) > 0) {
                SortTestHelper.swapArray(arr, i, --gt);
            } else {
                i++;
            }
        }
        SortTestHelper.swapArray(arr, l, lt--);

        sort(arr, l, lt);
        sort(arr, gt, r);

    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10);
        Integer[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copy2 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort3Ways", arr);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort", copy);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copy2);

        System.out.println("===================");
        System.out.println("near:");
        Integer[] arrNear = SortTestHelper.generateNearlyOrderedArray(n, 100);
        Integer[] copyNear = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copyNear2 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort3Ways", arrNear);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort", copyNear);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copyNear2);
    }
}
