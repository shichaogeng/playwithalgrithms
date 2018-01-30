package gengsc.algo.heap;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-30 22:24
 */
public class _HeapSort {

    public static void sort(Comparable[] arr) {

        //heapify转化为最大堆
        int n = arr.length;
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            SortTestHelper.swapArray(arr, 0, i);//最大值换到最后
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(Comparable[] arr, int n, int k) {
        Comparable e = arr[k];
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j+1].compareTo(arr[j]) > 0) {
                j++;
            }
            if (e.compareTo(arr[j]) >= 0) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;

    }
}
