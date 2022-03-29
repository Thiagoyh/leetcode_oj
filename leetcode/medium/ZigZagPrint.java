package com.lewis.leetcode.medium;

public class ZigZagPrint {
    public static void slashPrint(int[][] mat, int ax, int ay, int bx, int by, boolean flag){
        // 左下到右上(ax, ay)到(bx, by)
        if(flag){
            while(ax <= bx){
                System.out.println(mat[bx--][by++]);
            }
        }
        // 右上到左下
        else {
            while (ay >= by){
                System.out.println(mat[ax++][ay--]);
            }
        }
    }

    public static void print(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int ax = 0, ay = 0, bx = 0, by = 0;
        boolean flag = true;
        for (int i = 0; i < m + n -1; ++i){
            slashPrint(mat, ax, ay, bx, by, flag);
            if(i < m - 1){
                bx++;
            }
            else{
                by++;
            }
            if(i < n - 1){
                ay++;
            }
            else {
                ay = n -1;
                ax++;
            }
            flag = !flag;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        print(mat);
    }
}
