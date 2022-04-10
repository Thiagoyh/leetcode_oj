package com.lewis.leetcode.medium;

/*
 * 字符串只由'0'和'1'组成
 * 当字符串长度为1时, 所有可能的字符串为"0","1"
 * 当字符串长度为2时, 所有可能的字符串为"00","01","10","11"
 * 当字符串长度为3时, 所有可能的字符串为"000", "001", "010",
 * "011", "100", "101", "110", "111"
 *
 * 如果某一个字符串中, 只要出现'0'的位置, 左边就靠着'1', 这样的子串叫达标子串
 * 给定一个正数N, 返回所有长度为N的字符串中达标字符串的数量
 * 比如, N = 3, 返回3, 因为"101", "110", "111"达标
 */

public class String0101 {
    public static int fibonacci(int n){
         if(n <= 0){
             return 0;
         }
         if(n == 1 || n == 2 || n == 3){
             return n;
         }
         int[][] base = {{1, 1},
                   {1, 0}};
         int[][] res = matrixPower(base, n - 2);
         return 2 * res[0][0] + res[0][1];
    }

    public static int[][] matrixPower(int[][] base, int p){
        if(base.length != base[0].length){
            throw new RuntimeException("Please input square matrix");
        }
        int[][] res = new int[base.length][base[0].length];
        for(int i = 0; i < res.length; i++){
            res[i][i] = 1;
        }

        int[][] tmp = base;
        for(; p != 0; p >>= 1){
            if((p & 1) != 0){
                res = matrixMulti(tmp, res);
            }
            tmp = matrixMulti(tmp, tmp);
        }
        return res;
    }

    public static int[][] matrixMulti(int[][] m1, int[][] m2){
        if(m1[0].length != m2.length){
            throw new RuntimeException("m1 cant multi m2");
        }
        int[][] res = new int[m1.length][m2[0].length];
        for(int i = 0; i < m1.length; ++i){
            for(int j = 0; j < m2[0].length; ++j){
                for(int k = 0; k < m2.length; ++k){
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }
}
