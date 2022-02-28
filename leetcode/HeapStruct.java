package com.lewis.leetcode;

/*
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好序的话，每个元素移动的距离
 * 可以不超过k, 并且k相对于数组来说比较小。
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapStruct {

    public void sortedArrDistanceLessK(int[] arr, int k){
        //默认最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <= Math.min(arr.length, k); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; ++i, ++index){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(8);
        heap.add(4);
        heap.add(4);
        heap.add(9);
        heap.add(10);
        heap.add(3);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}