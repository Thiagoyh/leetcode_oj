package com.lewis.leetcode.medium;

/*
 * 给定一个正方形矩阵, 只用有限几个变量, 实现矩阵中每个位置的数顺时针转动
 * 90度, 比如如下的矩阵
 * 0  1  2  3
 * 4  5  6  7
 * 8  9  10 11
 * 12 13 14 15
 *
 * 旋转之后被调整为
 * 12  8  4  0
 * 13  9  5  1
 * 14  10 6  2
 * 15  11 7  3
 */

public class RotationMatrix {
    public static void rotationMat(int[][] mat){
        int a = 0;
        int b = mat.length - 1;

        while (a < b ){
            rotation(mat, a, b);
            a++;
            b--;
        }
    }
    public static void rotation(int[][] mat, int a, int b){
        for(int i = 0; i < b - a; ++i){
            int tmp = mat[a][a + i];
            mat[a][a + i] = mat[b - i][a];
            mat[b - i][a] = mat[b][b - i];
            mat[b][b - i] = mat[a + i][b];
            mat[a + i][b] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 2, 3},
                       {4, 5, 6, 7},
                       {8, 9, 10, 11},
                       {12, 13, 14, 15}};
        rotationMat(mat);
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[0].length; ++j){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
