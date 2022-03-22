package com.lewis.leetcode;

/*
 * 小虎去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个
 * 每袋的包装。可是小虎现在只想购买恰好n个苹果, 小虎想购买尽量少的袋数
 * 方便携带。如果不能恰好购买n个, 小虎将不会购买。输入一个整数n，表示
 * 小虎想购买的苹果个数，返回最少使用多少袋子。如果无论如何都装不下, 返回-1
 */

// 普通解法，一定的贪心，用最多用8个的袋子

public class TigerApple {
     public static int bagNum(int n){
         if(n % 2 != 0 || n < 6){
             return -1;
         }
         int bag6 = -1;
         int bag8 = n / 8;
         int rest = n - bag8 * 8;
         while(bag8 >= 0 && rest < 24){
             bag6 = minBag6(rest);
             if(bag6 != -1){
                 return bag6 + bag8;
             }
             bag8--;
             rest = n - bag8 * 8;
         }
         return bag6 == -1 ? -1 : bag6 + bag8;
     }

     public static int minBag6(int rest){
         return (rest % 6 == 0) ? (rest / 6) : -1;
     }

     
}
