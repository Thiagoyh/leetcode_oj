package com.lewis.leetcode.medium;

/*
 * 有一个洗衣机如果有衣服, 就可以把衣服扔到或者左边或者右边洗衣机
 * 问: 把所有洗衣机里衣服数量调整到一样多至少需要几轮
 */

// 基于业务的贪心, 只看一台机器, 看他遭遇什么状态

/*
 * 左右都是负数, 左侧加右侧
 * 左右都是整数, 取最大值
 * 左负右正, 至少最大值
 * 左正右负, 至少最大值
 */

// 最痛的瓶颈就是答案

public class Code01 {
    public static int modifyNum(int[] arr){
        int sum = 0, avg = 0;
        int length = arr.length;
        // 先把i之前的算出来
        int[] leftArr = new int[length];
        for(int i = 0; i < length; ++i){
            sum += arr[i];
            leftArr[i] = sum;
        }
        if(sum % length != 0){
            return -1;
        }
        avg = sum / length;
        int res = 0;

        for(int i = 0; i < length; ++i){
            int leftSum = 0, rightSum = 0;
            int cur = 0;
            if(i == 0){
                cur = Math.abs(arr[0] - avg);
                continue;
            }
            if(i == length - 1){
                cur = Math.abs(avg - arr[length - 1]);
                res = cur > res ? cur : res;
                continue;
            }

            // 普适情况
            leftSum = leftArr[i - 1];
            rightSum = sum - arr[i];
            rightSum = rightSum - leftSum;

            // 左边需要avg * i
            int left = leftSum - avg * i;
            int right = rightSum - avg * (length - i - 1);
            if(left < 0 && right < 0){
                cur = -left - right;
                res = cur > res ? cur : res;
            }
            else{
                cur = Math.max(Math.abs(left), Math.abs(right));
                res = cur > res ? cur : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 0};
        System.out.println(modifyNum(arr));
    }
}
