package com.lewis.leetcode;

/*
 * 32位有符号整数, 不使用算数运算符, 实现加减乘除
 */
public class BitPlus {

    public static int add(int a, int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
}
