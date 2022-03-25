package com.lewis.leetcode.medium;

/*
 *  给定一个非负整数n, 代表二叉树的节点个数. 返回能生成多少种不同结构的二叉树结构
 */

public class NTree {
      public static int f(int n){
          if(n < 0){
              return 0;
          }
          if(n == 0 || n == 1){
              return 1;
          }
          if(n == 2){
              return 2;
          }
          int res = 0;
          for(int i = 0; i <= n - 1; i++){
             int left = f(i);
             int right = f(n - 1 - i);
             res += left * right;
          }
          return res;
      }
      public static int ways(int n){
          if(n == 0){
              return 1;
          }
          if(n == 1){
              return 1;
          }
          if(n == 2){
              return 2;
          }
          int[] dp = new int[n + 1];
          dp[0] = 1;
          dp[1] = 1;
          dp[2] = 2;
          for(int index = 3; index <= n; ++index){
              int res = 0;
              for(int i = 0; i <= index - 1; ++i){
                  int left = dp[i];
                  int right = dp[index - 1 - i];
                  res += left * right;
              }
              dp[index] = res;
          }
          return dp[n];
      }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println("i = " + i + ": " + f(i) + "  " + ways(i));
        }
    }
}
