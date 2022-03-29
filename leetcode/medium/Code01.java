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
        for(int i = 0; i < length; ++i){
            sum += arr[i];
        }
        if(sum % length != 0){
            return -1;
        }

        avg = sum / length;
        int leftSum = 0;
        int res = 0;

        for(int i = 0; i < length; ++i){
            int leftRest = leftSum - avg * i;
            int rightRest = sum - leftSum - arr[i] - (length - i - 1) * avg;
            if(leftRest < 0 && rightRest < 0){
                res = (-leftRest - rightRest) > res ? (-leftRest - rightRest) : res;
            }
            else{
                res = Math.max(Math.max(Math.abs(leftRest), Math.abs(rightRest)), res);
            }
            leftSum += arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 0};
        System.out.println(modifyNum(arr));
    }
}
