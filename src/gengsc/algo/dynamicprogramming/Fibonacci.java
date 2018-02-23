package gengsc.algo.dynamicprogramming;

import sun.applet.Main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 斐波那契
 * a1=1, a2=1 an=an-1+an-2
 * @Author shichaogeng
 * @Create 2018-02-23 21:30
 */
public class Fibonacci {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        //记忆化搜索
        if (!memo.containsKey(n)) {
            memo.put(n, fib(n - 1) + fib(n - 2));
        }

        return memo.get(n);
    }

    public int fib2(int n) {
        Map<Integer, Integer> memo2 = new HashMap<>();
        memo2.put(1, 1);
        memo2.put(2, 1);

        for (int i = 3; i <= n; i++) {
            memo2.put(i, memo2.get(i - 1) + memo2.get(i - 2));
        }

        return memo2.get(n);
    }

    public static void main(String[] args) {
        int n = 1;
        long start = new Date().getTime();
        int res = new Fibonacci().fib2(n);
        long end = new Date().getTime();
        System.out.println("fib(" + n + ")=" + res);
        System.out.println("time:" + (end - start));
    }
}
