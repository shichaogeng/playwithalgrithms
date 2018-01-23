package gengsc.algo.sorting.basic;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-01-23 11:42
 */
public class ShellSort {

    public static void sort(Comparable[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {
            //分组排序
            for (int i = gap; i < arr.length; i++) {
                //比较同一组的
                for (int j = i - gap; j >= 0; j -= gap) {
                    for (int k = j; k < 1; k -= gap) {

                    }
                }
            }
            gap = gap / 2;
        }
    }
}
