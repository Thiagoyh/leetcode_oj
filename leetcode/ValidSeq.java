package com.lewis.leetcode;

import java.util.Scanner;

public class ValidSeq {
    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence =  new int[]{1, 6, -1, 10};

        int iter_arr = 0;
        int iter_seq = 0;

        while(iter_arr != array.length && iter_seq != sequence.length){
            if(array[iter_arr] == sequence[iter_seq]){
                ++iter_seq;
            }
            ++iter_arr;
        }
        if(iter_seq == sequence.length)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
