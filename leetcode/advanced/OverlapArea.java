package com.lewis.leetcode.advanced;

/*
 * 给出n个数字, a_1, ......, a_n, 问最多有多少不重叠的非空区间
 * 使得每个区间内数字的异或值都等于0
 */

// dp[i]表示在0-i范围上最优解

import java.util.HashMap;

public class OverlapArea {
      public static int maxXOR(int[] arr){
          if(arr == null){
              return 0;
          }
         int[] dp = new int[arr.length];
         int xor = 0;
          HashMap<Integer, Integer> map = new HashMap<>();
          map.put(0, -1);
          for(int i = 0; i < arr.length; ++i){
              xor ^= arr[i];
              if(map.containsKey(xor)){
                  int pre = map.get(xor);
                  dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
              }
              if(i > 0){
                  dp[i] = Math.max(dp[i - 1], dp[i]);
              }
              map.put(xor, i);
          }
          return dp[dp.length - 1];
      }
}
