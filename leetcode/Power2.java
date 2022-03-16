package com.lewis.leetcode;

// 2的幂

public class Power2 {
    public static boolean isPower2(int n){
        return (n & (n - 1)) == 0;
    }

    public static boolean isPower4(int n){
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
