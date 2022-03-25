package com.lewis.leetcode;

/*
 * 32位有符号整数, 不使用算数运算符, 实现加减乘除
 */




 ////
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

    // 减法
    public static int negNum(int n){
        return add(~n, 1);
    }
    public static int minus(int a, int b){
        return add(a, negNum(b));
    }

    // 加法
    public static int multi(int a, int b){
        int res = 0;
        while(b != 0){
            if((b & 1) != 0){
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n){
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for(int i = 31; i > -1; i = minus(i, 1)){
            if((x >> i) >= y){
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }
}
