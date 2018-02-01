package gengsc.algo.sorting.heap;

import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-30 20:39
 */
public class HeapSort1 {

    public static void sort(Comparable[] arr) {
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        System.out.println("Test for Random Array,size="+n+",randomRange=[0-"+n+"]");
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10);
        Integer[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copy2 = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copy3 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort3Ways", arr);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort", copy);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copy2);
        SortTestHelper.testSort("gengsc.algo.heap.HeapSort1", copy3);

        System.out.println("===================");
        int swapTimes = 100;
        System.out.println("Test for NearlyOrderedArray,size=" + n + ",swapTime=" + swapTimes);
        Integer[] arrOrdered = SortTestHelper.generateNearlyOrderedArray(n, swapTimes);
        Integer[] copyOrdered = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copyOrdered2 = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copyOrdered3 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort3Ways", arrOrdered);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort", copyOrdered);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copyOrdered2);
        SortTestHelper.testSort("gengsc.algo.heap.HeapSort1", copyOrdered3);

        System.out.println("===================");
        System.out.println("Test for Near Array,size="+n+",randomRange=[0-"+10+"]");
        Integer[] arrNear = SortTestHelper.generateRandomArray(n, 0, 10);
        Integer[] copyNear = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copyNear2 = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copyNear3 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort3Ways", arrNear);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.QuickSort", copyNear);
        SortTestHelper.testSort("gengsc.algo.sorting.advanced.MergeSort", copyNear2);
        SortTestHelper.testSort("gengsc.algo.heap.HeapSort1", copyNear3);
    }
}
