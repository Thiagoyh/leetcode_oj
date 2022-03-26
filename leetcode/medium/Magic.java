package com.lewis.leetcode.medium;

/*
 * 给定一个包含n个整数元素的集合a, 一个包含m个整数元素的集合b
 * 定义magic操作, 从一个集合中取出一个元素, 放在另外一个集合中,
 * 且操作过后每个集合的平均值都大于操作前
 *
 * 注意一下两点:
 * 不可以把一个集合的元素取空, 这样就没有平均值了
 * 值为x的元素从集合b取出放入集合a, 但是集合a中已经有值为x的元素,
 * 则a的平均值不变(因为集合元素不会重复), b的平均值可能发生改变
 *
 * 问: 最多可以进行多少次magic操作
 */

import java.util.Arrays;

public class Magic {
    public static int numMagic(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        
    }
}
