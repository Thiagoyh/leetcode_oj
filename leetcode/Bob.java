package com.lewis.leetcode;

public class Bob {

    public static long f1(int M, int N, int x, int y, int k){
        if(x < 0 || x > M || y < 0 || y > N){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        long live =  f1(M, N, x - 1, y, k - 1);
             live += f1(M, N, x + 1, y, k - 1);
             live += f1(M, N, x, y + 1, k - 1);
             live += f1(M, N, x, y - 1, k - 1);
        return live;
    }
    public static long f2(int M, int N, int x, int y, int k){
        if(x < 0 || x > M || y < 0 || y > N){
            return 1;
        }
        if(k == 0){
            return 0;
        }
        long die = f2(M, N, x - 1, y, k - 1);
             die += f2(M, N, x + 1, y, k - 1);
             die += f2(M, N, x, y + 1, k - 1);
             die += f2(M, N, x, y - 1, k - 1);
        return die;
    }
}
