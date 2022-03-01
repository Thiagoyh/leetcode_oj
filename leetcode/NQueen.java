package com.lewis.leetcode;

/*
 * n皇后问题，在n*n的棋盘上要摆n个皇后，要求任何两个皇后不同行、不同列，也不能在一条直线上。
 * 给定一个整数n，返回n皇后的摆法有多少种
 * n = 1, 返回1
 * n = 2或3, 返回0
 * n = 8返回92
 */

public class NQueen {
    public static int num(int n){
        if(n < 1 || n > 32){
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0, 0);
    }
    public static int process(int limit,
                              int colLim,
                              int leftDiaLim,
                              int rightDiaLim){
        if(colLim == limit){
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;

        return process(limit, 0, 0, 0);
    }
}
