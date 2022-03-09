package com.lewis.leetcode;

/*
 * 一个矩阵中只有0和1两种值，每个位置上都可以和自己的上下左右四个位置相连，
 * 如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛。
 * 举例：
 * 001010
 * 111010
 * 100100
 * 000000
 * 这个矩阵中有三个岛
 */

// 感染过程把1变成2

public class Island {

    public static int countIsland(int[][] m){
        if(m == null || m[0] == null){
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;

        for(int i = 0; i < N; ++i){
            for(int j = 0; j < M; ++j){
                if(m[i][j] == 1){
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M){
        if(i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;
        infect(m, i - 1, j, N, M);
        infect(m, i + 1, j, N, M);
        infect(m, i , j - 1, N, M);
        infect(m, i , j + 1, N, M);
    }

    public static void main(String[] args) {
        int[][] m1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 }
        };
    }

    // 设计一个并行算法

}
