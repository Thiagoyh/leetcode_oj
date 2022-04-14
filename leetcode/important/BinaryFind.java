package com.lewis.leetcode.important;

/*
 * 二分查找
 */

public class BinaryFind {
    // 有序数组中查找number
    public static int binaryFind(int[] arr, int number){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > number){
                right = mid - 1;
            }
            else if(arr[mid] < number){
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    // 查找有序数组中第一个等于value的下标
    public static int binarySearch(int[] arr, int value){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] >= value){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        if(left < arr.length && arr[left] == value){
            return left;
        }
        return -1;
    }

    // 查找最后一个等于value的下标
    public static int binarySearch2(int[] arr, int value){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] > value){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        if(right >= 0 && arr[right] == value){
            return right;
        }
        return -1;
    }

    // 查找第一个大于等于value的下标
    public static int binarySearch3(int[] arr, int value){
        int left = 0;
        int right = arr.length;

        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] >= value){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return (left < arr.length) ? left : -1;
    }

    // 查找最后一个小于value的下标
    public static int binarySearch4(int[] arr, int value){
        int left = 0;
        int right = arr.length;

        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if(arr[middle] > value){
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return (right >= 0) ? right : -1;
    }
}
