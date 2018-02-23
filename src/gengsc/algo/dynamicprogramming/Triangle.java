package gengsc.algo.dynamicprogramming;

import java.util.*;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-23 22:32
 */
public class Triangle {

    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {

        //f(i)=triangle[i][i]+min(triangle[i+1][i],triangle[i+1][i+1])
        return minimumTotal(triangle, 0, 0);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {

        int[][] memo2 = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size(); i >= 0; i--) {
            for (int j = triangle.get(i).size(); j >= 0; j--) {

                memo2[i][j] = triangle.get(i).get(j) + Math.min(memo2[i + 1][j], memo2[i + 1][j + 1]);
            }
        }

        return memo2[0][0];

    }

    private int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        if (i > triangle.size() - 1 || j > triangle.get(i).size() - 1) {
            return 0;
        }
        if (memo[i][j] == -1) {
            memo[i][j] = triangle.get(i).get(j) + Math.min(minimumTotal(triangle, i + 1, j), minimumTotal(triangle, i + 1, j + 1));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        Triangle triangleObject = new Triangle();
        triangleObject.memo = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        for (int i = 0; i < triangleObject.memo.length; i++) {
            for (int j = 0; j < triangleObject.memo[i].length; j++) {
                triangleObject.memo[i][j] = -1;
            }
        }
        System.out.println(triangleObject.minimumTotal(triangle));
    }
}
