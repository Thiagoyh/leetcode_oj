package com.lewis.leetcode.advanced;

/*
 * 现在有n1 + n2种面值的硬币, 其中前n1种为普通币,
 * 可以取任意枚, 后n2种为纪念币, 每种最多只能取一枚,
 * 每种硬币有一个面值, 问有多少种方法拼出m的面值
 */

public class Coins {
    public static int ways(int[] arr, int n1, int n2, int m){
         int res = 0;
         for(int i = 0; i <= m; ++i){
             res += process2(arr, n1, 0, i) * process1(arr, n1, n2, 0, m - i);
         }
         return res;
    }

    public static int process1(int[] arr, int n1, int n2, int index, int target){
        if(target == 0){
            return 1;
        }
        if(index == n2){
            return 0;
        }
        return process1(arr, n1,  n2, index + 1, target - arr[n1 + index])
                + process1(arr, n1,  n2, index + 1, target);
    }

    public static int process2(int[] arr, int n1, int index, int target){
        if(target == 0){
            System.out.println(111);
            return 1;
        }
        if(index == n1){
            return 0;
        }
        int res = 0;
        for(int i = 0; i <= (target / arr[index]); ++i){
            res += process2(arr, n1, index + 1, target - (i * arr[index]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 2, 4};
        System.out.println(ways(arr, 3, 3, 10));
    }
}
