package gengsc.algo.sorting.advanced;

import gengsc.algo.util.SortTestHelper;

import java.util.Random;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-25 19:32
 */
public class QuickSort2ways {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        //随机索引作为基准，在基本有序的数组中防止时间复杂度为O(N^2)
        SortTestHelper.swapArray(arr, l, /*new Random().nextInt(r - l + 1) + l*/Math.abs(new Random().nextInt()) % (r - l + 1) + l);
        Comparable v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) {
                i++;
            }
            while (j > l && arr[j].compareTo(v) > 0) {
                j--;
            }
            if (i > j) break;
            SortTestHelper.swapArray(arr, i++, j--);
        }
        SortTestHelper.swapArray(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort2ways", arr);
    }
}
