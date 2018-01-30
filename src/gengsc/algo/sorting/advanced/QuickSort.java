package gengsc.algo.sorting.advanced;

import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-25 19:32
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        /*if (r - l >= 5) {
            InsertionSort_2.sort(arr, l, r);
            return;
        }*/
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);

    }

    private static int partition(Comparable[] arr, int l, int r) {
        //当数组近乎有序时，会变成深度为N的右倾树，时间复杂度为O(N^2)
        //在这里使用随机算法 这样时间复杂度的期望值就为O(NlogN)
        //随机取一个索引
        SortTestHelper.swapArray(arr, l, new Random().nextInt(r - l) + l);
        Comparable v = arr[l];
        int p = l;
        for (int i = l+1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                SortTestHelper.swapArray(arr, ++p, i);
            }
        }
        SortTestHelper.swapArray(arr, l, p);
        return p;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10);
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(n, 10);
        Integer[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copy2 = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copy3 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort2ways", arr);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort", copy3);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSortBU", copy);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copy2);

    }
}
