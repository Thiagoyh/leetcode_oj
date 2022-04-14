package com.lewis.leetcode.medium;

/*
 * 最长递增子序列问题
 * 例如: [3, 1, 2, 6, 3, 4, 8, 5, 9, 10, 0]
 * 返回: [1, 2, 3, 4]
 */

// 正常来讲这是一个O(n^2)的一个问题

/*
 * 常规 dp[i]子序列必须以arr[i]结尾的情况下最长递增子序列
 */

// ends[i] 所有长度为i + 1的递增子序列中最小结尾

public class MaxSequence {

    // 第一个小于的数
    public static int binaryFind(int[] arr, int number){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > number){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return (left < arr.length) ? left : -1;
    }

    public static int maxLength(int[] arr){
        if(arr == null){
            return 0;
        }
        int[] dp = new int[arr.length];
        int ans = 1;
        for(int i = 0; i < arr.length; ++i){
            int max = 0;
            for(int j = i - 1; j >= 0; --j){
                if(arr[j] < arr[i]){
                    max = dp[j] > max ? dp[j] : max;
                }
            }
            dp[i] = max + 1;
            ans = dp[i] > ans ? dp[i] : ans;
        }
        return ans;
    }
    public static int maxLength2(int[] arr){
        if(arr == null){
            return 0;
        }
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            ends[i] = -1;
        }
        int ans = 1, index = 0;
        for(int i = 0; i < arr.length; ++i){
            int max = 0;
            for(int j = i - 1; j >= 0; --j){
                if(arr[j] < arr[i]){
                    max = dp[j] > max ? dp[j] : max;
                }
            }
            dp[i] = max + 1;
            if(ends[max] == -1){
                ends[max] = i;
            }
            else{
                if(arr[i] < arr[ends[max]]){
                    ends[max] = i;
                }
            }
            ans = dp[i] > ans ? dp[i] : ans;
        }
        return ans;
    }

        public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 3, 4, 8, 5, 3, 10,0};
        int[] num = {1, 4 , 7 , 13, 16, 19, 45, 47, 56, 78, 89};
        System.out.println(binaryFind(num, 5));
        System.out.println(maxLength(arr));

    }
}
