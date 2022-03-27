package com.lewis.leetcode.medium;

/*
 * 复杂度O(n+m)
 */

public class OrderedMatrix {
    public static boolean inMatrix(int[][] mat, int n){
        if(mat.length == 0){
            return false;
        }
        int M = mat.length, N = mat[0].length;
        int row = 0, col = N - 1;
        while (row < M && col >= 0){
            if(mat[row][col] == n){
                System.out.println("row: " + row + "   col: " + col);
                return true;
            }
            else if(mat[row][col] > n){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 5, 9, 10},
                {2, 6, 11, 13},
                {7, 9, 15, 17}};
        System.out.println(inMatrix(mat, 12));
    }
}
