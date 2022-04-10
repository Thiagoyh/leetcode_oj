package com.lewis.leetcode.medium;

/*
 * 在迷迷糊糊的大草原上, 小红捡到了n根木棍, 第i根木棍长度为i,
 * 小红现在很开心. 想选出其中的三根组成美丽的三角形.
 * 但小明想捉弄小红, 想去掉一些木棍, 使得小红任意三根木棍都不能
 * 组成三角形.
 *
 * 请问小明最少要去掉多少根木棍呢?
 * 给定N, 返回去掉多少根木棍
 */

public class RedStick {
    public static int f(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    public static int fibonacci(int n){
        if(n <= 0){
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

    public static int removeStick(int n){
        if(n <= 3){
            return 0;
        }

        int fibonacci_1 = 1;
        int fibonacci_2 = 2;
        int fibonacci = 0;
        int res = 2;
        while(fibonacci < n){
            fibonacci = fibonacci_1 + fibonacci_2;
            res++;
            fibonacci_1 = fibonacci_2;
            fibonacci_2 = fibonacci;
            System.out.println(fibonacci);
        }
        if(res == n){
            return res;
        }
        return --res;
    }

    public static void main(String[] args) {
        System.out.println(removeStick(17));
    }
}
