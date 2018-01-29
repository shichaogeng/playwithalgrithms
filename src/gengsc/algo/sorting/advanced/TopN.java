package gengsc.algo.sorting.advanced;

import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * 获取第n大的元素
 * @Author shichaogeng
 * @Create 2018-01-28 15:39
 */
public class TopN {

    private static int n;
    private static Comparable e;

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        //找出分割点
        SortTestHelper.swapArray(arr, l, new Random().nextInt(r - l + 1) + l);
        Comparable v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                SortTestHelper.swapArray(arr, ++j, i);
            }
        }
        SortTestHelper.swapArray(arr, l, j);
        if (n-1 > j) {
            sort(arr, j + 1, r);
        } else if (n-1 < j) {
            sort(arr, l, j - 1);
        } else {
            e = arr[j];
            return;
        }

    }

    public static void main(String[] args) {
        //找出第n大的元素
        n = 4;
        Integer[] arr = new Integer[]{10,3,2,14,23,72,0,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(e);
    }
}
