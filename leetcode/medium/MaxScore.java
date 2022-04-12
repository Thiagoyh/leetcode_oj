package com.lewis.leetcode.medium;

/*
 * 公司为每个职位设计了打分系统, 打分可以为正数, 也可以为负数,
 * 正数表示用户认可帖子的质量, 负数则表示用户不认可帖子的质量.
 * 打分的分数根据评价用户的等级大小不定. 假设数组A记录了一条帖子
 * 所有的打分记录, 现在需要找出帖子曾经得到过的最高分数是多少.
 * 最高分的定义为: 用户所有的打分记录中, 连续打分之和的最大值即认为是帖子曾经
 * 获得的做高分
 *
 * [1, 1, -1, -10, 11, 4, -6, 9, 20, -10, -2}, 那么该条帖子
 * 曾经达到的最高分数为11+4+(-6)+9+20 = 38
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxScore {
    public static class ArrayComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static int maxScore(int[] arr){
        if(arr == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum_i = 0;
        for(int i = 0; i < arr.length; i++){
            sum_i += arr[i];
            max = sum_i > max ? sum_i : max;
            min = sum_i < min ? sum_i : min;
        }
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 4, -9, 4, -2, 3, 4, -2, 6};
        System.out.println(maxScore(arr));
    }
}
