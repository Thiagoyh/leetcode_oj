package com.lewis.leetcode.medium;

public class Gift {
    public static int coins(int start, int end, int x, int y, int z){
        return process(start, end, x, y, z);
    }
    public static int process(int start, int end, int x, int y, int z){
        if(start == end){
            return 0;
        }
        else if(start < end){
            return Math.min(x + process(start + 2, end, x, y, z),
                            y + process(start * 2, end, x, y, z));
        }
        else {
            return z + process(start - 2, end, x, y, z);
        }
    }


    public static void main(String[] args) {
        System.out.println(coins(2, 6, 3, 100, 1));
    }

}
