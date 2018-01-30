package gengsc.algo.heap;

import gengsc.algo.util.SortTestHelper;

import java.util.Arrays;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-30 20:39
 */
public class HeapSort2 {

    public static void sort(Comparable[] arr) {
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        System.out.println("Test for Random Array,size="+n+",randomRange=[0-"+n+"]");
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        Integer[] copy = Arrays.copyOfRange(arr, 0, arr.length);
        Integer[] copy2 = Arrays.copyOfRange(arr, 0, arr.length);
        SortTestHelper.testSort("gengsc.algo.heap.HeapSort1", arr);
        SortTestHelper.testSort("gengsc.algo.heap.HeapSort2", copy);
        SortTestHelper.testSort("gengsc.algo.heap._HeapSort", copy2);
    }
}
