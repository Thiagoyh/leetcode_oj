package com.lewis.leetcode.medium;

/*
 * 动态规划的空间压缩技巧
 * 给你一个二位数组matrix, 其中每一个数都是正数, 要求从左上角到右下角
 * 每一步只能向右或者向下, 沿途经过的数据要累加起来. 求最后返回的
 * 最小路径和.
 */

import java.util.Arrays;

public class DpMatrix {
    public static int minSum(int[][] mat, int x, int y){
        if(x == mat.length - 1 && y == mat[0].length - 1){
            return mat[x][y];
        }
        if(x == mat.length - 1){
            return mat[x][y] + minSum(mat, x, y + 1);
        }
        if(y == mat[0].length - 1){
            return mat[x][y] + minSum(mat, x + 1, y);
        }
        return mat[x][y] + Math.min(minSum(mat, x + 1, y), minSum(mat, x, y + 1));
    }

    public static int minSum2(int[][] mat){
        int[][] dp = new int[mat.length][mat[0].length];
        dp[mat.length - 1][mat[0].length - 1] = mat[mat.length - 1][mat[0].length - 1];
        for(int i = mat[0].length - 2; i >= 0; i--){
            dp[mat.length - 1][i] = mat[mat.length - 1][i] + dp[mat.length - 1][i + 1];
        }
        for(int i = mat.length - 2; i >= 0; i--){
            dp[i][mat[0].length - 1] = mat[i][mat[0].length - 1] + dp[i + 1][mat[0].length - 1];
        }
        for(int i = 0; i < mat.length - 1; i++){
            for(int j = 0; j < mat[0].length - 1; j++){
                dp[mat.length - 2 - i][mat[0].length - 2 - j] =
                  mat[mat.length - 2 - i][mat[0].length - 2 - j] +
                  Math.min(dp[mat.length - 1 - i][mat[0].length - 2 - j],
                          dp[mat.length - 2 - i][mat[0].length - 1 - j]);
            }
        }
        return dp[0][0];
    }

    public static int minSum(int[][] mat){
        int[] dp = new int[mat[0].length];
        dp[mat[0].length - 1] = mat[mat.length - 1][mat[0].length - 1];

        for(int i = mat[0].length - 2; i >= 0; i--){
            dp[i] = mat[mat.length - 1][i] + dp[i + 1];
        }

        int n = mat.length - 1;
        while(n >= 0){
            n--;
            if(n < 0)
                break;
            dp[mat[0].length - 1] += mat[n][mat[0].length - 1];
            for(int j = 0; j < mat[0].length - 1; j++){
                dp[mat[0].length - 2 - j] = mat[n][mat[0].length - 2 - j]
                         + Math.min(dp[mat[0].length - 1 - j], dp[mat[0].length - 2 - j]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 1},
                {4, 5, 6, 2},
                {7, 8, 9, 5}};
        System.out.println(minSum(mat, 0, 0));
        System.out.println(minSum2(mat));
        System.out.println(minSum(mat));
    }
}
