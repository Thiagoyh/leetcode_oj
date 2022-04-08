package com.lewis.leetcode.medium;

/*
 * 如果一个字符串为str, 把字符串str前面任意部分挪到后面形成的字符串叫做str的旋转词,
 * 比如str="12345", str的旋转词有"12345", "23451", "34512", "45123"和
 * "51234". 给定两个字符串a和b, 请判断a和b是否互为旋转词.
 */

// kmp算法
// a字符串扩展成两倍之后, 看b是不是a的子串

public class RotationString {

    public static int getIndex(String str1, String str2){
        if(str1 == null || str1 == null || str1.length() < 1 ||
                str1.length() < str1.length()){
            return -1;
        }
        char[] strA = str1.toCharArray();
        char[] strB = str2.toCharArray();
        int i1 = 0, i2 = 0;
        int[] next = getNextArray(strB);
        while(i1 < strA.length && i2 < strB.length){
            if(strA[i1] == strB[i2]){
                i1++;
                i2++;
            }
            else if(i2 == 0){
                i1++;
            }
            else {
                i2 = next[i2];
            }
        }
        return i2 == strB.length ? i1 - i2 : -1;
    }
    public static int[] getNextArray(char[] str2){
        if(str2.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;

        while(i < str2.length){
            if(str2[i - 1] == str2[cn]){
                next[i++] = ++cn;
            }
            else if (cn > 0){
                cn = next[cn];
            }
            else{
                next[i++] = 0;;
            }
        }
        return next;
    }

     public static boolean isRotation(String a, String b){
         String a2 = a + a;
         int index = getIndex(a2, b);
         if(index >= 0)
             return true;
         else
             return false;
     }

    public static void main(String[] args) {
        String str1 = "12345";
        String str2 = "45123";
        System.out.println(isRotation(str1, str2));
    }
}
