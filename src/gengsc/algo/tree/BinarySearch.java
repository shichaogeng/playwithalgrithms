package gengsc.algo.tree;

import gengsc.algo.util.SortTestHelper;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-05 22:58
 */
public class BinarySearch {

    public static int find(Comparable[] arr, Comparable target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target.compareTo(arr[mid]) < 0) {
                r = mid - 1;
            } else if (target.compareTo(arr[mid]) > 0) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findByRecursion(Comparable[] arr, Comparable target) {
        return findByRecursion(arr, 0, arr.length - 1, target);
    }

    private static int findByRecursion(Comparable[] arr, int l, int r, Comparable target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (target.compareTo(arr[mid]) < 0) {
            return findByRecursion(arr, 0, mid - 1, target);
        } else if (target.compareTo(arr[mid]) > 0) {
            return findByRecursion(arr, mid + 1, r, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(20, 0, 20);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort3Ways", arr);
        SortTestHelper.printArray(arr);
        System.out.println(findByRecursion(arr, 12));
    }
}
