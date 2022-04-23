package com.lewis.leetcode.medium;

public class MaxSubStr {
    public static int maxLength(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0; i < 256; i++){
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for(int i = 0; i != chars.length; ++i){
            pre = Math.max(pre, map[chars[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chars[i]] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(maxLength(s));
    }
}
