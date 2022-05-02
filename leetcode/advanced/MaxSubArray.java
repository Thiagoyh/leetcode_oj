package com.lewis.leetcode;

/*
 * 给定一个数组arr, 该数组无序, 但每个值均为正数,
 * 再给定一个正数k. 求arr的所有子数组中所有元素
 * 相加和为k的最长子数组长度
 *
 * 例如:
 * arr = [1, 2, 1, 1, 1], k = 3
 * 累加和为3的最长子数组为[1, 1, 1], 所以结果返回3
 * 要求: 时间复杂度O(N), 额外空间复杂度O(1)
 */

public class MaxSubArray {
     public static int maxLength(int[] arr, int k){
          if(arr == null){
              return 0;
          }
          int l = 0, r = 0;
          int res = 0;
          int sum = arr[0];
          while(r < arr.length){
              if(sum == k){
                  res = (r - l + 1) > res ? (r - l + 1) : res;
                  sum -= arr[l++];
              }
              else if(sum < k){
                  r++;
                  if(r == arr.length){
                      break;
                  }
                  sum += arr[r];
              }
              else {
                  sum -= arr[l];
              }
          }
          return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        System.out.println(maxLength(arr, 3));
    }
}
