package com.lewis.leetcode;

public class HouseJump {
    public static int mainWays(int a, int b, int k){
          return jump(a, b, k);
    }

    public static int jump(int x, int y, int k){
        if(x < 0 || x > 8 || y < 0 || y > 9){
            return 0;
        }
        if(k == 0){
            if(x == 0 && y == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        return jump(x + 2, y + 1, k - 1) +
                jump(x +1, y + 2, k - 1) +
                jump(x + 2, y - 1, k -1) +
                jump(x + 1, y - 2, k - 1) +
                jump(x - 2, y + 1, k - 1) +
                jump(x -1, y + 2, k - 1) +
                jump(x - 2, y - 1, k -1) +
                jump(x - 1, y - 2, k - 1);
    }

    // 严格表结构
    public static int jumpWays(int x, int y, int k){
        if(x < 0 || x > 8 || y < 0 || y > 9 || k < 0){
            return 0;
        }
        int[][][] dp = new int[9][10][k + 1];
        dp[0][0][0] = 1;
        for(int h = 1; h <= k; ++h){
            for(int r = 0; r < 9; ++r){
                for(int c = 0; c < 10; ++r){
                    dp[r][c][h] += getValue(dp, r - 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c + 1, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c - 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c + 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c - 1, h - 1);
                }
            }
        }
        return dp[x][y][k];
    }

    public static int getValue(int[][][] dp, int x, int y, int k){
        if(x < 0 || x > 8 || y < 0 || y > 9 || k < 0){
            return 0;
        }
        return dp[x][y][k];
    }
}
