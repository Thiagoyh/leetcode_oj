package com.lewis.leetcode.medium;

public class Baidu {

    public static int energy(int[] arr, int P){
        if(arr.length == 0){
            return 0;
        }
        int[] hashTable = new int[arr.length + 1];
        return process(arr, hashTable, P, 0, 1);
    }

    public static int process(int[] arr, int[] hashTable, int P, int last, int index){
        if(index == arr.length){
            return 0;
        }
        int tmp = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            int tmp1 = 0;
            if(hashTable[i] == 0){
                hashTable[i] = 1;
                if(Math.abs(i - last) == 1){
                   tmp1 = Math.max(0, arr[i] - arr[last]) + process(arr, hashTable, P, i, index + 1);
                }
                else {
                   tmp1 = P + process(arr, hashTable, P, i, index + 1);
                }
                tmp = tmp1 < tmp ? tmp1 : tmp;
                hashTable[i] = 0;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 10, 10, 100, 100};
        System.out.println(energy(arr, 3));
    }
}
