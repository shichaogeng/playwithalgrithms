package gengsc.algo.dynamicprogramming.IntegerBreak;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-25 15:41
 */
public class Solution {
    public int integerBreak(int n) {

        if (n == 1) {
            return 1;
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * integerBreak(n - i));
        }
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().integerBreak(10));
    }
}
