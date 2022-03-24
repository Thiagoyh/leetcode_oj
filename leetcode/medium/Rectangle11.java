package com.lewis.leetcode.medium;

/*
 * 给定一个N*N的矩阵matrix, 只有0和1两种值, 返回边框全是1的最大正方形的边长长度
 * 例如
 * 0 1 1 1 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 1 1 1
 * 0 1 0 1 1
 */

public class Rectangle11 {
    // brute force solution
    public static int maxSquare(int[][] mat){
        int res = 0;
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[0].length; ++j){
                for(int k = 1; k + i < mat.length && k + j < mat[0].length; ++k){
                    int tmp = 0;
                    for(int row = 0; row < k; ++row){
                        tmp += mat[i + row][j];
                        tmp += mat[i][j + row];
                        tmp += mat[i + k][j + row];
                        tmp += mat[i + row][j + k];
                    }
                    if(tmp == 4 * k - 4){
                        res = tmp > res ? tmp : res;
                    }
                }
            }
        }
        return res;
    }
}
