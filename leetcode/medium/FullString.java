package com.lewis.leetcode.medium;

/*
 * 一个完整的括号字符串定义规则如下:
 * 控制符串是完整的
 * 如果s是完整的字符串，那么(s)也是完整的
 * 如果s和t是完整的字符串, 那么将他们连接起来的st也是完整的
 *
 * 例如, "(()())", "" 和 "(())()"是完整括号
 */

import java.util.Arrays;

public class FullString {
    public static boolean isFull(String s){
        char[] str = s.toCharArray();
        int count = 0;
        for(int i = 0; i < str.length; ++i){
            if(str[i] == '('){
                count++;
            }
            if(str[i] == ')'){
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        if(count == 0)
            return true;
        return false;
    }

    public static int ways(String s){
        char[] str = s.toCharArray();
        int count = 0, res = 0;
        for(int i = 0; i < str.length; ++i){
            if(str[i] == '('){
                count++;
            }
            if(str[i] == ')'){
                count--;
            }
            if(count < 0){
                ++res;
                ++count;
            }
        }
        return res + count;
    }

    public static void main(String[] args) {
        String s = "(())";
        System.out.println(ways(s));
    }
}
