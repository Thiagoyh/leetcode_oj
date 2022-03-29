package com.lewis.leetcode.medium;

/*
 * a b c d e
 * f g h i j
 * k l m n o
 * d q r s t
 */

// abcdejotrsqbkfghinml

// 一个宏观调度过程

public class CirclePrint {
     public static void printRec(char[][] mat, int ax, int ay, int bx, int by){
         for(int i = 0; i < by - ay + 1; ++i){
             System.out.println(mat[ax][ay + i]);
         }
         for(int i = 0; i < bx - ax; ++i){
             System.out.println(mat[ax + i + 1][by]);
         }
         for(int i = 0; i < by - ay; ++i){
             System.out.println(mat[bx][by - i -1]);
         }
         for(int i = 0; i < bx - ax - 1; ++i){
             System.out.println(mat[bx - i - 1][ay]);
         }
     }

     public static void print(char[][] mat){
         int bx = mat.length - 1;
         int by = mat[0].length - 1;
         int ax = 0, ay = 0;
         while(ax < bx && ay < by){
             printRec(mat, ax, ay, bx, by);
             ax++;
             ay++;
             bx--;
             by--;
         }
         if(ay < by && ax == bx){
            for(int i = 0; i < by - ay + 1; ++i){
                System.out.println(mat[ax][ay + i]);
            }
         }
         else if(ax < bx && ay == by){
             for(int i = 0; i < bx - ax + 1; ++i){
                 System.out.println(mat[ax +  i][by]);
             }
         }
         else return;

     }

    public static void main(String[] args) {
        char[][] mat = {{'a', 'b', 'c', 'd', 'e'},
                        {'f', 'g', 'h', 'i', 'j'},
                        {'k', 'l', 'm', 'n', 'o'}
                        };
        print(mat);
    }

}
/*
 * a b c d e
 * f g h i j
 * k l m n o
 * p q r s t
 */
// abcdejotsrqpkfghinml
