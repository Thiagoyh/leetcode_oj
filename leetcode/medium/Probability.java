package com.lewis.leetcode.medium;

/*
 * 给定一个函数f, 可以1-5等概率返回一个. 请加工出1-7等概率返回的
 * 一个函数g
 */

public class Probability {
    public static int f(){
        return (int) (Math.random() * 5 + 1);
    }

    // 加工一个等概率返回01的函数
    public static int r01(){
        int res = 0;
        do{
            res = f();
        }while (res == 3);
        return res < 3 ? 0 : 1;
    }

    // 用01的随机发生器 创造二进制
    public static int g(){
        int res = 0;
        do{
            res = (r01() << 2) + (r01() << 1) + r01();
        } while (res == 7);
        return res + 1;
    }

    // 给定一个函数f, 以p概率返回0, 以1-p概率返回1, 请加工出等概率返回0和1的函数g
    // 扔骰子扔两回, 得到00或者11重新扔, 直到得到01或者10
}
