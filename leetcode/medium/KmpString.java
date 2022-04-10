package com.lewis.leetcode.medium;

import java.util.Locale;

public class KmpString {
    public static int getIndex(String a, String b){
        if(a.length() < b.length() || a.length() == 0){
            return -1;
        }
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getArray(str2);
        while(i1 != str1.length && i2 != str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }
            else if(i2 == 0){
                i1++;
            }
            else{
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getArray(char[] str2){
        if(str2.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i != str2.length){
            if(str2[i - 1] == str2[cn]){
                next[i++] = ++cn;
            }
            else if(cn > 0){
                cn = next[cn];
            }
            else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
