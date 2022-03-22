package com.lewis.leetcode;

public class Grass {
    // 普通方法
    public static String winner1(int n){
        if(n < 5){
            return (n == 0 || n == 2) ? "back" : "front";
        }
        int base = 1;
        while (base <= n){
            if(winner1(n - base).equals("back")){
                return "front";
            }
            if(base > n / 4){
                break;
            }
            base *= 4;
        }
        return "back";
    }

    // 牛逼解法
    public static String winner2(int n){
        if(n % 5 == 0 || n % 5 == 2){
            return "back";
        }
        else {
            return "front";
        }
    }
}
