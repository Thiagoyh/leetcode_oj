package com.lewis.leetcode.medium;

public class MaxSubStr {
    public static int maxLength(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        dp[0] = 1;
        for(int i = 1; i < str.length; ++i){
            dp[i] = dp[i - 1] + 1;
            for(int j = i - 1; j >= i - dp[i - 1]; --j){
                if(str[j] == str[i]){
                    dp[i] = (dp[i - 1] -dp[j] + 1);
                    break;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < str.length; ++i){
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(maxLength(s));
    }
}
