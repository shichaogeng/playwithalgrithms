package gengsc.algo.dynamicprogramming.minimumpathsum;

/**
 * @Description
 * leetcode 64
 * @Author shichaogeng
 * @Create 2018-02-24 10:01
 */
public class Solution {
    public int minPathSum(int[][] grid) {

        //最优子结构
        //f(3,3)=grid[3][3]+min(f(3,2),f(2,3))

        //方程
        //f[i][j]=grid[i][j]+min(f(i,j-1),f(i-1,j))

        //边界
        //grid[0][0]

        if (grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[i][j];
                } else if (i == 0) {
                    memo[i][j] = grid[i][j] + memo[i][j - 1];
                } else if (j == 0) {
                    memo[i][j] = grid[i][j] + memo[i - 1][j];
                } else {
                    memo[i][j] = grid[i][j] + Math.min(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[m - 1][n - 1];
    }

    public static void main(String[] args) {

        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        System.out.println(new Solution().minPathSum(grid));
    }
}
