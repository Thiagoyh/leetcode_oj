package com.lewis.leetcode.medium;

/*
 * 给顶一个数组arr, 一直其中所有的值都是非负的, 将这个数组看做一个容器,
 * 请返回容器最多能装下多少水
 *
 * 比如, arr = { 3, 1, 2, 5, 2, 4 }, 根据画出的直方图的形状就是容器的形状,
 * 该容器可以装下5格水
 * 再比如, arr = { 4, 5, 1, 3, 2 }, 该容器可以装下2格水
 */

/*
 * 直观理解很容易理解, 但是用技术语言描述很困难的一道题
 */

public class WaterArray {
     public static int waterSum(int[] arr) {
         if(arr == null){
             return 0;
         }
         int[] maxLeft = new int[arr.length];
         int[] maxRight = new int[arr.length];
         int max = arr[0];
         for(int i = 1; i < arr.length; ++i){
             max = max > arr[i - 1] ? max : arr[i - 1];
             maxLeft[i] = max;
         }
         max = arr[arr.length - 1];
         for(int i = arr.length - 2; i >= 0; i--){
             max = max > arr[i + 1] ? max : arr[i + 1];
             maxRight[i] = max;
         }

         int res = 0;
         for(int i = 1; i < arr.length - 1; ++i){
             if(maxLeft[i] > arr[i] && maxRight[i] > arr[i]){
                 res += (Math.min(maxLeft[i], maxRight[i]) - arr[i]);
             }
         }
         return res;
     }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(waterSum(arr));
    }
}
