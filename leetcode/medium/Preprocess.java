package com.lewis.leetcode.medium;

/*
 * RG染色
 */

public class Preprocess {
    // 暴力解法
     public static int mainPaintTest(String s){
         char[] str = s.toCharArray();

         int N = str.length;
         // 枚举左侧部分为i, 则右侧有N - i
         int res = Integer.MAX_VALUE;
         for(int i = 0; i < N; ++i){
             int res_1 = 0;
             if(i == 0){
                 for(int j = 0; j < N; ++j){
                     if(str[j] == 'G'){
                         ++res_1;
                     }
                 }
                 res = res_1 < res ? res_1 : res;
             }
             if(i == N){
                 for(int j = 0; j < N; ++j){
                     if(str[j] == 'R'){
                         ++res_1;
                     }
                 }
                 res = res_1 < res ? res_1 : res;
             }
             for(int j = 0; j < i; ++j){
                 if(str[j] == 'G'){
                     ++res_1;
                 }
             }
             for(int j = i; j < N; ++j){
                 if(str[j] == 'R'){
                     ++res_1;
                 }
             }
             res = res_1 < res ? res_1 : res;
         }
         return res;
     }

     // 用一个数组统计0-i上R的数量
    public static int mainPaint(String s){
         char[] str = s.toCharArray();
         int[] numOfR = new int[str.length];
         int num = 0;
         for(int i = 0; i < str.length; ++i){
             if(str[i] == 'R'){
                 numOfR[i] = ++num;
             }
             else {
                 numOfR[i] = num;
             }
         }
         // 假设左边部分为i个, 右侧部分为N - i个
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < str.length; ++i){
            int tmp = i - 2 * numOfR[i] + str[str.length - 1];
            res = tmp < res ? tmp : res;
        }
        return res;
    }

}
