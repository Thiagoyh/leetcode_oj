package com.lewis.leetcode.medium;

public class ZigZagPrint {
    public static void printMatrixZigZag(int[][] mat){
        int ax = 0, ay = 0;
        int bx = 0, by = 0;
        int endR = mat.length - 1;
        int endD = mat[0].length - 1;
        boolean flag = false;
        while(ax != endR + 1){
            printLine(mat, ax, ay, bx, by, flag);
            ax = ay == endD ? ax + 1 : ax;
            ay = ay == endD ? ay : ay + 1;
            bx = bx == endR ? bx : bx + 1;
            by = bx == endR ? by + 1 : by;
            flag = !flag;
        }
        System.out.println();
    }

    public static void printLine(int[][] mat, int ax, int ay, int bx, int by, boolean flag){
        if(flag){
            while(ax != bx + 1){
                System.out.print(mat[ax][ay] + " ");
                ax++;
                ay--;
            }
        }
        else {
            while(bx != ax - 1){
                System.out.print(mat[bx][by] + " ");
                bx--;
                by++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12}};
        printMatrixZigZag(mat);
    }
}
