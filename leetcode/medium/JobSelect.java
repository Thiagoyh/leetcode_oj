package com.lewis.leetcode.medium;

/*
 * 选工作的标准是在难度不超过自身能力值的情况下, 选择报酬最高的工作
 * 给定一个job类型的数组jobarr, 表示所有的工作. 给定一个int类型的
 * 数组arr, 表示所有小伙伴的能力
 * 返回int类型的数组,表示每一个小伙伴按照牛牛的标准选工作后所能获得的报酬
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class JobSelect {
     public static class Job{
         public int money;
         public int hard;

         public Job(int money, int hard){
             this.money = money;
             this.hard = hard;
         }
     }

     public static class JobComparator implements Comparator<Job>{
         @Override
         public int compare(Job o1, Job o2) {
             return o1.hard != o2.hard ? o1.hard - o2.hard : o2.money - o1.money;
         }
     }

     public static int[] salary(Job[] jobarr, int[] arr){
         Arrays.sort(jobarr, new JobComparator());
         TreeMap<Integer, Integer> map = new TreeMap<>();
         map.put(jobarr[0].hard, jobarr[0].money);
         Job pre = jobarr[0];
         for(int i = 1; i < jobarr.length; ++i){
             if(jobarr[i].hard != pre.hard && jobarr[i].money > jobarr[i].money){
                 pre = jobarr[i];
                 map.put(pre.hard, pre.money);
             }
         }
         int[] ans = new int[arr.length];
         for(int i = 0; i < arr.length; ++i){
             Integer key = map.floorKey(arr[i]);
             ans[i] = key != null ? map.get(key) : 0;
         }
         return ans;
     }
}
