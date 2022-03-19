package com.lewis.leetcode;

public class FirstScore {
    public static int mian01(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        return Math.max(
                f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1)
        );
    }

    public static int f(int[] arr, int i, int j){
        if(i == j){
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j -1));
    }
    public static int s(int[] arr, int i, int j){
        if(i == j){
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j -1));
    }

    // 使用严格表结构, 表仅有右上半区有效
    public static int dpMain(int[] arr){
        int[][] dpF = new int[arr.length][arr.length];
        int[][] dpS = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; ++i){
            dpF[i][i] = arr[i];
        }
        int row = 0;
        int col = 1;
        while(col < arr.length){
            int i = row;
            int j = col;
            while(i < arr.length && j < arr.length){
                dpF[i][j] = Math.max(arr[i] + dpS[i + 1][j], arr[j] + dpS[i][j - 1]);
                dpS[i][j] = Math.min(dpF[i + 1][j], dpF[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }

        return Math.max(dpF[0][arr.length - 1], dpS[0][arr.length - 1]);
    }
}
