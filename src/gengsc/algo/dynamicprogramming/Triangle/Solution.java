package gengsc.algo.dynamicprogramming.Triangle;

import java.util.List;

/**
 * @Description
 * leetcode 120
 * @Author shichaogeng
 * @Create 2018-02-24 9:47
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.isEmpty()) return 0;
        int[] memo = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                memo[j] = triangle.get(i).get(j) + Math.min(memo[j], memo[j + 1]);
            }
        }
        return memo[0];
    }

}
