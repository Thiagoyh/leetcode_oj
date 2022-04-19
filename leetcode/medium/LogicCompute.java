package com.lewis.leetcode.medium;

/*
 * 给定一个只由0(假)、1(真)、&(逻辑或)、和^(异或)五种字符
 * 组成的字符串express, 再给定一个布尔值desired. 返回
 * express能有多少种组合方式, 可以达到desired的结果
 *
 * 举例:
 * express="1^0|0|1", desired = false
 * 只有1^((0|0)|1)和1^(0|(0|1))的组合可以得到false
 * 返回2
 */

public class LogicCompute {
    public static int ways(String s, boolean desired){
        if(s == null || s.equals("")){
            return 0;
        }
        char[] str = s.toCharArray();

        return process(str, 0, str.length - 1, desired);
    }

    public static boolean isValid(char[] str){
        if((str.length & 1) == 0){
            return false;
        }
        for(int i = 0; i < str.length; i += 2){
            if((str[i] != '1') && (str[i] != '0')){
                return false;
            }
        }
        for (int i = 1; i < str.length; i += 2){
            if((str[i] != '&') && (str[i] != '|') && (str[i] != '^')){
                return false;
            }
        }
        return true;
    }

    public static int process(char[] str, int L, int R, boolean desired){
        if(L == R){
            if(str[L] == '1'){
                return desired ? 1 : 0;
            }
            else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if(desired){
            for(int i = L + 1; i < R; i += 2){
                if(str[i] == '&'){
                    res += (process(str, L, i - 1, true) * process(str, i + 1, R, true));
                }
                else if(str[i] == '|'){
                    res += (process(str, L, i - 1, true) * process(str, i + 1, R, false));
                    res += (process(str, L, i - 1, false) * process(str, i + 1, R, true));
                    res += (process(str, L, i - 1, true) * process(str, i + 1, R, true));
                }
                else {
                    res += (process(str, L, i - 1, true) * process(str, i + 1, R,false));
                    res += (process(str, L, i - 1, false) * process(str, i + 1, R,true));
                }
            }
        }
        else {
            for(int i = L + 1; i < R; i += 2){
                if(str[i] == '&'){
                    res += (process(str, L, i - 1, false) * process(str, i + 1, R, false));
                    res += (process(str, L, i - 1, true) * process(str, i + 1, R, false));
                    res += (process(str, L, i - 1, false) * process(str, i + 1, R, true));
                }
                else if(str[i] == '|'){
                    res += (process(str, L, i - 1, false) * process(str, i + 1, R, false));
                }
                else {
                    res += (process(str, L, i - 1, true) * process(str, i + 1, R,true));
                    res += (process(str, L, i - 1, false) * process(str, i + 1, R,false));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String express = "1^0|0|1";
        boolean desired = false;

        System.out.println(ways(express, desired));
    }
}
