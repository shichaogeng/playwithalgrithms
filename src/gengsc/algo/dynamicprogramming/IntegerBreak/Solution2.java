package gengsc.algo.dynamicprogramming.IntegerBreak;

import java.util.HashMap;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-25 16:12
 */
public class Solution2 {
    public int integerBreak(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo.put(i, max3(memo.get(i) == null ? -1 : memo.get(i), j * (i - j), j * memo.get(i - j)));
            }
        }

        return memo.get(n);
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
