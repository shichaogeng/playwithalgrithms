package gengsc.algo.sorting.advanced;

import java.util.Arrays;

/**
 * @Description
 * 求逆序数
 * @Author shichaogeng
 * @Create 2018-01-28 14:43
 */
public class ReverseNumber {
    private static int num = 0;

    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);

    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l;
        int j = mid + 1;
        for (int k = l ; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j++ - l];
            } else if (j > r) {
                arr[k] = aux[i++ - l];
            } else if (aux[i - l].compareTo(aux[j - l]) <= 0) {
                arr[k] = aux[i++ - l];
            } else {
                num += mid - i + 1;
                arr[k] = aux[j++ - l];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10,3,1,0,20,5};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    num++;
                }
            }
        }
//        SortTestHelper.testSort("gengsc.algo.sorting.advanced.ReverseNumber", arr);
        System.out.println(num);
    }
}
