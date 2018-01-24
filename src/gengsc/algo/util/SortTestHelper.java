package gengsc.algo.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-20 21:24
 */
public class SortTestHelper {

    /**
     * 生成rangeL到rangeR的n个元素的随机数组
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL < rangeR;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(random.nextInt()) % (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    /**
     * 遍历打印
     * @param arr
     */
    public static void printArray(Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 交换数组i和j索引的元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swapArray(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 小于
     * @param x
     * @param y
     * @return
     */
    public static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    /**
     * 测试是否有序及排序效率
     * @param sortName
     * @param arr
     */
    public static void testSort(String sortName, Comparable[] arr) {
        try {
            Class<?> sortClass = Class.forName(sortName);
            Method method = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            method.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

//            printArray(arr);
            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 是否有序
     * @param arr
     * @return
     */
    private static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        //随机的挑选元素进行交换
        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int posx = Math.abs(random.nextInt()) % n;
            int posy = Math.abs(random.nextInt()) % n;
            swapArray(arr, posx, posy);
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(n, 10);
//        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 3);
        Integer[] copy = Arrays.copyOf(arr, arr.length);
        Integer[] copy1 = Arrays.copyOf(copy, copy.length);
        SortTestHelper.testSort("InsertionSort_1", arr);
        SortTestHelper.testSort("BubbleSort", copy1);
        SortTestHelper.testSort("SelectionSort", copy);
    }
}
