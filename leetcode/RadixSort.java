package com.lewis.leetcode;

public class RadixSort {

    public static void radicSort(int[] arr, int L, int R, int digit){
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少数，准备多少额外空间
        int[] bucket = new int[R - L + 1];
        for(int d = 1; d <= digit; ++d){
               int[] count = new int[radix];
               for(i = L; i < R; ++i){
                   j = getDigit(arr[i], d);
                   count[j]++;
               }
               for(i = 1; i < radix; ++i){
                   count[i] = count[i] + count[i - 1];
               }
               for(i = R; i >= L; i--){
                   j = getDigit(arr[i], d);
                   bucket[count[j] - 1] = arr[i];
                   count[j]--;
               }
               for(i = L, j = 0;  i <= R; i++, j++){
                   arr[i] = bucket[j];
               }
        }
    }
    public static int getDigit(int i, int d){

        return 1;
    }

}
