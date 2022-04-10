package com.lewis.leetcode.medium;

/*
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包装入一些零食, 牛牛的
 * 背包容量是w, 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]
 * 牛牛想知道在总体积不超过背包容量的情况下, 他一共有多少种零食放法
 * 总体积为0也算一种放法
 */

// 改成动态规划之后, dp[最后一行][j]求和
public class BagVariant {
    public static int bag(int[] arr, int index, int target){
        if(target == 0){
            return 1;
        }
        if(index == arr.length){
            return 0;
        }
        return bag(arr, index + 1, target) + bag(arr, index + 1, target - arr[index]);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        System.out.println(bag(arr, 0, 8));
    }
}
