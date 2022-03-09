package com.lewis.leetcode;


// 给定两个长度为N的数组weights和values, weights[i]和values[i]分别表示i号货物的重量和价值。
// 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量。
public class Goods {
    public static int process(int[] weights, int[] values, int i, int result, int bag){
        if(result > bag){
            return 0;
        }
        if(i == weights.length){
            return 0;
        }
        return Math.max(
                process(weights, values, i + 1, result, bag),
                values[i] + process(weights, values, i + 1, result + weights[i], bag));
    }
}
