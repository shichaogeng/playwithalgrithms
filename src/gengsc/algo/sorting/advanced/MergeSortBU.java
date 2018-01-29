package gengsc.algo.sorting.advanced;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-23 22:52
 */
public class MergeSortBU {

    public static void sort(Comparable[] arr) {
        for (int size = 1; size < arr.length ; size += size) {
            for (int i = 0; i + size < arr.length; i += 2 * size) {
                if (arr[i + size - 1].compareTo(arr[i + size]) > 0) {
                    MergeSort.mergeSort(arr, i, i + size - 1, Math.min(i + 2 * size - 1, arr.length - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
    }

}
