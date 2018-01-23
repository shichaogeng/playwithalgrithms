package gengsc.algo.sorting.basic;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-21 15:46
 */
public class SelectionSort{

    public static void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (SortTestHelper.less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            SortTestHelper.swapArray(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("SelectionSort", arr);
    }


}
