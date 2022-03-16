package com.lewis.leetcode;

/*
 * 位运算
 * 给定两个有符号的32位整数a和b, 返回a和b中较大的
 *
 * 要求: 不做任何比较判断
 */

public class BitComp {

      public static int flip(int n){
          return n^1;
      }

      public static int sign(int n){
          return flip( (n >> 31) & 1 );
      }

      public static int getMax1(int a, int b){
          int c = a - b;
          int scA = sign(c);
          int scB = flip(scA);

          return a * scA + b * scB;
      }

      // 考虑a - b可能溢出
      public static int getMax2(int a, int b){
          int c = a - b;
          int sa = sign(a);
          int sb = sign(b);
          int sc = sign(c);
          int difSab = sa ^ sb;
          int sameSab = flip(difSab);
          int returnA = difSab * sa + sameSab * sc;
          int returnB = flip(returnA);
          return a * returnA + b * returnB;
      }
}
