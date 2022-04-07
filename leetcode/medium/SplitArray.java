package com.lewis.leetcode.medium;

/*
 * 给定一个数组arr, 长度为N, 你可以把任意长度大于0且小于N的前缀作为左半部分,
 * 剩下的作为右半部分. 但是每种划分都有左部分的最大值和右部分的最大值, 请返回
 * 最大的, 左部分最大值减去右部分最大值的绝对值.
 */

public class SplitArray {
    public static int maxSplit(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; ++i){
            max = arr[i] > max ? arr[i] : max;
        }

        return arr[0] > arr[arr.length - 1] ? (max - arr[arr.length]) : (max - arr[0]);
    }
}
