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

    // a better solution
    // record the number of arranged continuously 1111
    public static int maxOneMatrix(int[][] mat){
        int N = mat.length;
        int numR = 0, numD = 0;
        int[][] numMatR = new int[N][N];
        int[][] numMatD = new int[N][N];
        for(int i = N - 1; i >= 0; i--){
            for(int j = N - 1; j >= 0; j--){
                if(mat[i][j] == 1){
                    numR++;
                    numMatR[i][j] = numR;
                }
                else{
                    numMatR[i][j] = 0;
                    numR = 0;
                }
            }
            numR = 0;
        }
        for(int j = N - 1; j >= 0; j--){
            for(int i = N - 1; i >= 0; i--){
                if(mat[i][j] == 1){
                    numD++;
                    numMatD[i][j] = numD;
                }
                else{
                    numMatD[i][j] = 0;
                    numD = 0;
                }
            }
            numD = 0;
        }
        int res = 0;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(numMatD[i][j] == 0 || numMatR[i][j] == 0){
                    continue;
                }
                if(Math.min(numMatD[i][j], numMatR[i][j]) == 1){
                    res = res < 1 ? 1 : res;
                }

                int k = Math.min(numMatD[i][j], numMatR[i][j]);
                int downNum = numMatR[i + k - 1][j];
                int rightNum = numMatD[i][j + k - 1];
                int tmp = Math.min(Math.min(k, downNum), rightNum);
                res = tmp > res ? tmp : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1, 1, 1, 1},
                       {0, 1, 0, 0, 1},
                       {0, 1, 0, 0, 1},
                       {0, 1, 1, 1, 1},
                       {0, 1, 0, 1, 1}};
        System.out.println(maxOneMatrix(mat));
    }
}

/*
 * 0 1 1 1 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 1 1 1
 * 0 1 0 1 1
 */