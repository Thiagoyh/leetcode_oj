package com.lewis.leetcode.medium;

/*
 * 给定一个有序数组arr，代表数轴上从左到右有n个点arr[0], ... , arr[n - 1]
 * 给定一个正数L，代表一根长度为L的绳子, 求绳子最多可以覆盖其中的几个点
 */

// 找到>=某个数最小的数

public class Rope {

    // 生成对数器
    public static int[] generateRandomArray(int len, int max){
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for(int i = 0; i < arr.length; ++i){
            arr[i] = (int)(Math.random() * max) + 1;
        }
        return arr;
    }


    public static int unmPoints(int[] arr, int L){
        int left = 0, right = 0, index = 0;
        int res = 1, tmp = 1;
        while(left < arr.length && right < arr.length){
            while(arr[right] - arr[left] < L){
                ++right;
                ++tmp;
            }
            res = tmp > res ? tmp : res;
            left++;
            tmp = res--;
        }
        return res;
    }
}
