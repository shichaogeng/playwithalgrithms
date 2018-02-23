package gengsc.algo.dynamicprogramming;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-23 22:10
 */
public class ClimbingStairs {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int climb(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (!memo.containsKey(n)) {
            memo.put(n, climb(n - 1) + climb(n - 2));
        }
        return memo.get(n);
    }

    public int climb2(int n) {

        HashMap<Integer, Integer> memo2 = new HashMap<>();
        memo2.put(1, 1);
        memo2.put(2, 2);

        for (int i = 3; i <= n; i++) {
            memo2.put(i, memo2.get(i - 1) + memo2.get(i - 2));
        }
        return memo2.get(n);
    }

    public static void main(String[] args) {
        int n = 3;
        long start = new Date().getTime();
        int res = new ClimbingStairs().climb2(n);
        long end = new Date().getTime();
        System.out.println("climb(" + n + ")=" + res);
        System.out.println("time:" + (end - start));
    }
}
