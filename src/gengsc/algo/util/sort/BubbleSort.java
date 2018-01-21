package gengsc.algo.util.sort;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-21 17:21
 */
public class BubbleSort {
    
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (SortTestHelper.less(arr[j+1], arr[j])) {
                    SortTestHelper.swapArray(arr, j, j + 1);
                }
            }
        }
    }
}
