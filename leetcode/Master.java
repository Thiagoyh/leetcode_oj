package com.lewis.leetcode;

public class Master {
    public static int func(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        return Math.max(arr[L] + sfunc(arr, L + 1, R), arr[R] + sfunc(arr, L, R - 1));

    }

    public static int sfunc(int[] arr, int L, int R){
        if(L == R){
            return 0;
        }
        return Math.min(func(arr, L + 1, R), func(arr, L, R - 1));
    }
}
