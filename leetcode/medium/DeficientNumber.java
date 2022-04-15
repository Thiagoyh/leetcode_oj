package com.lewis.leetcode.medium;

/*
 * 给定一个整数数组A, 长度为n, 有1 <= A[i] <= n, 而且
 * 对于[1, n]的整数, 其中部分会重复而部分不出出现
 * 找到[1, n]中所有未出现在A中的整数
 *
 * 例如:
 * 输入 1 3 4 3
 * 输出 2
 */

import java.util.ArrayList;

public class DeficientNumber {
    public static int[] getArray(int[] arr){
        if(arr == null ||arr.length == 0){
            return null;
        }
        int[] hash = new int[arr.length];
        for(int i = 0; i < arr.length; ++i){
            hash[i] = -1;
        }
        for(int i = 0; i < arr.length; ++i){
            hash[arr[i] - 1] = i;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; ++i){
            if(hash[i] == -1){
                res.add(i + 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    // O(n)而且空间复杂度为0(1)的方法
    public static int[] getArray2(int[] arr){
        if(arr == null ||arr.length == 0){
            return null;
        }
//        for(int i = 0; i < arr.length; ++i){
//            while(arr[arr[i] - 1] != arr[i]){
//                int tmp = arr[arr[i] - 1];
//                arr[arr[i] - 1] = arr[i];
//                arr[i] = tmp;
//            }
//        }
        for(int value : arr){
            while(arr[value - 1] != value){
                int tmp = arr[value - 1];
                arr[value - 1] = value;
                value = tmp;
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] != i + 1){
                res.add(i + 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 3, 3, 5, 6, 7, 9, 7};
        int[] res = getArray2(arr);
        for(int i = 0; i < res.length; ++i){
            System.out.println(res[i] + " ");
        }
    }
}
