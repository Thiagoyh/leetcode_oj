package com.lewis.leetcode.medium;

/*
 * 给定一个数组, 求差值为k的去重数字对
 */

import java.util.HashMap;
import java.util.HashSet;

public class RepeatNum {
    public static int repeatK(int[] arr, int k){
        HashSet<Integer> map = new HashSet<>();
        int res = 0;
        for(int i = 0; i < arr.length; ++i){
            map.add(arr[i]);
        }
        for(int i = 0; i < arr.length; ++i){
            if(map.contains(arr[i] - k)){
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 7, 0, 0};
        System.out.println(repeatK(arr, 2));
    }
}
