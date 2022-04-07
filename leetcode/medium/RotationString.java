package com.lewis.leetcode.medium;

/*
 * 如果一个字符串为str, 把字符串str前面任意部分挪到后面形成的字符串叫做str的旋转词,
 * 比如str="12345", str的旋转词有"12345", "23451", "34512", "45123"和
 * "51234". 给定两个字符串a和b, 请判断a和b是否互为旋转词.
 */

// kmp算法
// a字符串扩展成两倍之后, 看b是不是a的子串

public class RotationString {
     public static boolean isRotation(String a, String b){
         char[] strA = a.toCharArray();
         char[] strB = b.toCharArray();

         return true;
     }
}
