package com.lewis.leetcode.medium;

/*
 * 给定两个字符串str1和str2, 再给定三个整数ic, dc, rc
 * 分别代表插入、删除和替换一个字符的代价, 返回将str1编辑成
 * str2的最小代价
 */

// 和最长公共子串一个模型

// 一张表, 一个字符串做行, 一个字符串做列
// [i][j]表示str1前缀为i编辑成str2前缀为b代价是多少

public class EditString {
    public static int cost(String str1, String str2, int ic, int dc, int rc){
        if(str1 == null || str2 == null){
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int row = chars1.length + 1;
        int col = chars2.length + 1;

        int[][] dp = new int[row][col];
        for(int i = 0; i < col; i++){
            dp[0][i] = i * ic;
        }
        for(int i = 0; i < row; i++){
            dp[i][0] = i * dc;
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(chars1[i] == chars2[j]){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
            }
        }
        return dp[row - 1][col - 1];
    }
}
