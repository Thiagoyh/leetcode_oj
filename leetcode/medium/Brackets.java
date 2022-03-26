package com.lewis.leetcode.medium;

/*
 * 合法的括号序
 * 例如"()", "()()", "((()))"
 * 深度为 1 1 3
 */

//  求连续子数组的问题,就求每个位置作为最后一个位置的答案是多少

public class Brackets {

    public static boolean isFull(char[] str){
        int count = 0;
        for(int i = 0; i < str.length; ++i){
            if(str[i] == '('){
                count++;
            }
            if(str[i] == ')'){
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        if(count == 0)
            return true;
        return false;
    }

    public static int subStr(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        // dp[i]表示从i位置结束最长的有效长度
        int pre = 0;
        int res = 0;
        for (int i = 0; i < str.length; ++i){
            if(str[i] == ')'){
                pre = i - dp[i - 1] - 1;
                if(pre >= 0 && str[pre] == '('){
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "())()(())()))(())";
        System.out.println(subStr(s));
    }
}
