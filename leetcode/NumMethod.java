package com.lewis.leetcode;

/*
 * 一个正数数组，里面没有重复值
 * [3, 5, 10, 2]
 * 每个数字可以用任意次, 组成一个值的方法数
 */

public class NumMethod {
      public static int f(int[] arr, int index, int rest){
          if(index == arr.length){
              return rest == 0 ? 1 : 0;
          }
          int num = 0;
          for(int i = 0; arr[index] * i <= rest; ++i){
              num += f(arr, index + 1, rest - arr[index] * i);
          }
          return num;
      }

      // 严格表结构
      public static int moneyWays(int[] arr, int aim){
          if(arr == null || arr.length == 0){
              return 0;
          }
          int N = arr.length;
          int[][] dp = new int[N + 1][aim + 1];
          dp[N][0] = 1;
          for(int index = N - 1; index >= 0; --index){
              for(int rest = 0; rest <= aim; ++rest){
                  dp[index][rest] = dp[index + 1][rest];
                  if(rest - arr[index] >= 0){
                      dp[index][rest] += dp[index][rest - arr[index]];
                  }
              }
          }
          return dp[0][aim];
      }
}
