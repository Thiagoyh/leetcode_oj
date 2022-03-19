package com.lewis.leetcode.buteForceRecu;

public class Coins {
    public static void main(String[] args) {

    }

    public static int main01(int[] arr, int aim){
        return f(arr, 0, 0, aim);
    }

    public static int f(int[] arr, int index, int pre, int aim){
        if(index == arr.length){
            return pre == aim ? 1 : 0;
        }
        return f(arr, index + 1, pre, aim) + f(arr, index + 1, pre + arr[index], aim);
    }

    public static int process(int[] arr, int index, int rest){
        if(rest < 0){
            return -1;
        }
        if(rest == 0){
            return 0;
        }
        if(index == arr.length){
            return -1;
        }
        int p1 = process(arr, index + 1, rest);
        int p2Next = process(arr, index + 1, rest - arr[index]);
        if(p1 == -1 && p2Next == -1){
            return -1;
        }
        else{
            if(p1 == -1){
                return 1 + p2Next;
            }
            if(p2Next == -1){
                return p1;
            }
            return Math.min(p1, 1 + p2Next);
        }
    }

    // 记忆化搜索的方式
    public static int mainCoins2(int[] arr, int aim){
        int[][] dp = new int[arr.length + 1][aim + 1];
        for(int i = 0; i <= arr.length; ++i){
            for(int j = 0; j <= aim; ++j){
                dp[i][j] = -2;
            }
        }

        return process2(arr, 0, aim, dp);
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp){
        if(rest < 0){
            return -1;
        }

        if(dp[index][rest] != -2){
            return dp[index][rest];
        }


        if(rest == 0){
            dp[index][rest] = 0;
        }
        else if(index == arr.length){
            dp[index][rest] = -1;
        }
        else{
            int p1 = process2(arr, index + 1, rest, dp);
            int p2Next = process2(arr, index + 1, rest - arr[index], dp);
            if(p1 == -1 && p2Next == -1){
                dp[index][rest] = -1;
            }
            else{
                if(p1 == -1){
                    dp[index][rest] = 1 + p2Next;
                }
                else if(p2Next == -1){
                    dp[index][rest] = p1;
                }
                else{
                    dp[index][rest] = Math.min(p1, 1 + p2Next);
                }
            }
        }
        return dp[index][rest];

    }

    // 严格表结构
    public static int mainCoins3(int[] arr, int aim){
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];

        for(int row = 0; row <= N; row++){
            dp[row][0] = 0;
        }
        for(int col = 1; col <= aim; ++col){
            dp[N][col] = -1;
        }
        for(int index = N - 1; index >= 0; index--){
            for(int rest = 1; rest <= aim; rest++){
                int p1= dp[index + 1][rest];
                int p2Next = -1;
                if(rest - arr[index] >= 0){
                    p2Next = dp[index + 1][rest - arr[index]];
                }
                if(p1 == -1 && p2Next == -1){
                    dp[index][rest] = -1;
                }else {
                    if(p1 == -1){
                        dp[index][rest] = p2Next + 1;
                    }
                    if(p2Next == -1){
                        dp[index][rest] = p1;
                    }
                    dp[index][rest] = Math.min(p1, p2Next + 1);
                }
            }
        }
        return dp[0][aim];
    }


}
