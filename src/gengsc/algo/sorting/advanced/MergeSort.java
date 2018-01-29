package gengsc.algo.sorting.advanced;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import gengsc.algo.sorting.basic.InsertionSort_2;
import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;

/**
 * @Description
 * 当n小的时候,插入排序优于归并排序
 * @Author shichaogeng
 * @Create 2018-01-23 9:46
 */
public class MergeSort {

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        //当n小的时候,插入排序优于归并排序
        if (l >= r) {
            return;
        }
        /*if ((r - l) >= 5) {
            InsertionSort_2.sort(arr, l, r);
            return;
        }*/
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (SortTestHelper.less(arr[mid+1], arr[mid]))
            mergeSort(arr, l, mid, r);

    }

    public static void mergeSort(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {//左边遍历完
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {//右边遍历完
                arr[k] = aux[i++ - l];
            } else if (SortTestHelper.less(aux[i - l], aux[j - l])) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100000;
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(n, 1110);
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] copy = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.basic.InsertionSort_1", arr);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copy);
    }
}
