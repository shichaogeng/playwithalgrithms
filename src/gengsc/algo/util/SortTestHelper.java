package gengsc.algo.util;

import sun.applet.Main;

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
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        if (rangeL > rangeR) {
            throw new RuntimeException("参数错了，左范围应小于右范围");
        }
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(random.nextInt()) % (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        printArray(generateRandomArray(10, 100, 500));
    }
}
