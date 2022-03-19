package com.lewis.leetcode.buteForceRecu;

/* 输入 int[N] a;
 * int s = start
 * int e = end
 * 机器人必须走k步，可以随意往左走或者往右走，不能停在原地
*/

/*
 * N = 5 s = 2 e = 4 k = 4
 * 2 3 4 5 4
 * 2 3 4 3 4
 * 2 3 2 3 4
 */

public class RobotRun {
    public static int f(int N, int e, int rest, int cur){
        if(rest == 0){
            return cur == e ? 1 : 0;
        }
        if(cur == 1){
            return f(N, e, rest - 1, 2);
        }
        if(cur == N){
            return f(N, e, rest - 1, N - 1);
        }
        return f(N, e, rest - 1, cur - 1) + f(N, e, rest - 1, cur + 1);
    }

    public static int walkWays(int N, int e, int start, int K){

        int[][] dp = new int[K + 1][N + 1];
        for(int i = 0; i <= K; i++){
            for(int j = 0; j <= N; j++){
                dp[i][j] = -1;
            }
        }
        return f2(N, e, K, start, dp);
    }
    public static int f2(int N, int e, int rest, int cur, int[][] dp){
        if(dp[rest][cur] != -1){
            return dp[rest][cur];
        }

        if(rest == 0){
            dp[rest][cur] = cur == e ? 1 : 0;
            return dp[rest][cur];
        }
        if(cur == 1){
            dp[rest][cur] = f2(N, e, rest - 1, 2, dp);
        }
        else if(cur == N){
            dp[rest][cur] = f2(N, e, rest - 1, N - 1, dp);
        }
        else {
            dp[rest][cur] = f2(N, e, rest - 1, cur - 1, dp) + f2(N, e, rest - 1, cur + 1, dp);
        }
        return dp[rest][cur];
    }

    public static int dpWay(int N, int P, int M, int K){
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;
        for(int rest = 1; rest <= K; ++rest){
            for(int cur = 1; cur <= N; ++cur){
                if(cur == 1){
                    dp[rest][cur] = dp[rest - 1][2];
                }
                else if( cur == N){
                    dp[rest][cur] = dp[rest - 1][N - 1];
                }
            }
        }
        return dp[M][K];
    }
}
