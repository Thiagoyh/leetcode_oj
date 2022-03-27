package com.lewis.leetcode.medium;

/*
 * 将给定的数转换为字符串, 原则如下: 1对应a, 2对应b, ... , 26对应z, 例如12258
 * 可以转换为"abbeh", "aveh", "abyh", "lbeh", and "lyh", 个数为5,
 * 编写一个函数,给出可以转换不同字符串的个数
 */

// 从左往右的递归尝试模型 string[i]到后面所有

public class NumberAndLetter {
    public static int f(char[] str, int index){
        if(index == str.length){
            return 1;
        }
        if(str[index] == '0'){
            return 0;
        }
        int res = f(str, index + 1);
        if(index == str.length - 1){
            return res;
        }
        if( ((str[index] - '0') * 10 + (str[index + 1] - '0')) <= 26 ){
            res += f(str, index + 2);
        }
        return res;
    }

    public static int ways(String s){
        char[] str = s.toCharArray();
        return f(str, 0);
    }

    public static void main(String[] args) {
        String s = "12258";
        System.out.println(ways(s));
    }
}
