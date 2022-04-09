package com.lewis.leetcode.medium;

/*
 * 给定一个数组arr, 如果通过调整可以做到arr中任意两个相邻的数字相乘
 * 是4的倍数, 返回true, 如果不能返回false
 */

// 遍历 奇数, 只有2因子的数, 包含4因子的数
// a, b, c个

/*
 * b == 0时
 * a == 1, c >= 1
 * a > 1, c >= a - 1
 */

/*
 * b != 0
 * a = 0, c >= 0
 * a = 1, c >= 1
 * a > 1, c >= a
 */

public class FourNum {



}
