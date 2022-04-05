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
         int res = 0;
         int maxLeft = arr[0];
         int maxRight = arr[arr.length - 1];
         int l = 1, r = arr.length - 2;
         while (l <= r){
             if(maxLeft > maxRight){
                 if(arr[r] < maxRight){
                     res += (maxRight - arr[r]);
                 }
                 else {
                     maxRight = arr[r];
                 }
                 r--;
             }
             else {
                 if(arr[l] < maxLeft){
                     res += (maxLeft - arr[l]);
                 }
                 else{
                     maxLeft = arr[l];
                 }
                 l++;
             }
         }
         return res;
     }

    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        System.out.println(waterSum(arr));
    }
}
