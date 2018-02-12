package gengsc.algo.tree;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-07 9:57
 */
public class Floor {

    public static int floor(Comparable[] arr, Comparable target) {
        int l = -1;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (target.compareTo(arr[mid]) <= 0) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return 0;
    }
}
