package com.lewis.leetcode;

/*
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，把大于num的数放在数组的右边
 * 要求额外空间复杂度O(1), 时间复杂度O(n)
 */

public class Netherlands01 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 6, 7, 4, 3, 5, 8};
        int num = 5;
        int pointer = 0;
        for(int i = 0; i != arr.length; ++i){
            if(arr[i] <= num){
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
            else{
                continue;
            }
        }
    for(int i = 0; i != arr.length; ++i) {
        System.out.println(arr[i] + " ");
    }
    }
}
