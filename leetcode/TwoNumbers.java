package com.lewis.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i != n; ++i){
            nums[i] = sc.nextInt();
        }
        System.out.println("");
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i != n; ++i){
            if(map.containsKey(sum - nums[i])){
                System.out.println(map.get(sum - nums[i])
                + " " + i);
            }
           map.put(nums[i], i);
        }
    }
}
