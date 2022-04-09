package com.lewis.leetcode.medium;

// 没有条件转移的严格递归, 同意都有log(n)的解

public class Fibonacci {
    public static int f(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static int fibonacci(int n){
        if(n < 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int[][] base = {{1, 1,},
                {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] base, int p){
        int[][] res = new int[base.length][base[0].length];
        for(int i = 0; i < res.length; i++){
               res[i][i] = 1;
            }
        int[][] t = base;
        for(; p != 0; p >>= 1){
            if((p & 1) != 0){
                 res = multiMatrix(res, t);
            }
            t = multiMatrix(t, t);
        }
        return res;
        }

    public static int[][] multiMatrix(int[][] a, int[][] b){
        if(a[0].length != b.length){
            throw new RuntimeException("gfdhuj");
        }
        int[][] res = new int[a.length][b[0].length];
        for(int i = 0; i < a.length; ++i){
            for(int j = 0; j < b[0].length; ++j){
                for(int k = 0; k < a[0].length; ++k){
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(f(16));
        System.out.println(fibonacci(16));
    }
}
