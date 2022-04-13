package com.lewis.leetcode.medium;

/*
 * 给定一个整型矩阵, 返回子矩阵的最大累加和
 */

// 压缩数组

public class MaxSumMatrix {
    public static int maxArray(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cn = 0;
        for(int i = 0; i < arr.length; ++i){
            cn += arr[i];
            max = cn > max ? cn : max;
            cn = cn < 0 ? 0 : cn;
        }
        return max;
    }

    public static int maxMat(int[][] mat){
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for(int i = 0; i != mat.length; ++i){
            s = new int[mat[0].length];
            for(int j = i; j != mat.length; ++j){
                cur = 0;
                for(int k = 0; k != s.length; ++k){
                    s[k] += mat[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat = {{-5, 3, 6, 4},
                {-7, 9, -5, 3},
                {-10, 1, -200, 4}};
        System.out.println(maxMat(mat));
    }
}
