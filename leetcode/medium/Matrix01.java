package com.lewis.leetcode.medium;

/*
 * 一个矩阵每一行的0一定在1的左边
 */

// 返回1最多的行

import java.util.ArrayList;

public class Matrix01 {
      public static ArrayList<Integer> maxOne(int[][] mat){
          if(mat.length == 0){
              return null;
          }
          ArrayList<Integer> res = new ArrayList<>();
          int max = 0;
          int M = mat.length, N = mat[0].length;
          int row = 0, col = N - 1;
          while (row < M && col >= 0){
              if(mat[row][col] == 1){
                  col--;
              }
              if(mat[row][col] == 0){
                  row++;
              }
          }
          for(int i = 0; i < M; ++i){
              if(mat[i][col + 1] == 1){
                  res.add(i);
              }
          }
          System.out.println(col);
          return res;
      }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0, 0, 0, 1, 1, 1, 1},
                       {0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 1}};
        ArrayList res = maxOne(mat);
        for(int i = 0; i < res.size(); ++i){
            System.out.println(res.get(i));
        }
    }
}
