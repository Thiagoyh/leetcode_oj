package com.lewis.leetcode.medium;

/*
 * 给定一个包含n个整数元素的集合a, 一个包含m个整数元素的集合b
 * 定义magic操作, 从一个集合中取出一个元素, 放在另外一个集合中,
 * 且操作过后每个集合的平均值都大于操作前
 *
 * 注意一下两点:
 * 不可以把一个集合的元素取空, 这样就没有平均值了
 * 值为x的元素从集合b取出放入集合a, 但是集合a中已经有值为x的元素,
 * 则a的平均值不变(因为集合元素不会重复), b的平均值可能发生改变
 *
 * 问: 最多可以进行多少次magic操作
 */

// 集合是去重的数组


import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Magic {
    public static int numMagic(int[] a, int[] b){
        TreeSet<Integer> setA = new TreeSet<>();
        TreeSet<Integer> setB = new TreeSet<>();
        int sumA = 0, sumB = 0;
        int lengthA = a.length, lengthB = b.length;
        for(int i = 0; i < lengthA; ++i){
            setA.add(a[i]);
            sumA += a[i];
        }
        double averageA = sumA / lengthA;
        for(int i = 0; i < lengthB; ++i){
            setB.add(b[i]);
            sumB += b[i];
        }
        double averageB = sumB / lengthB;
        int count = 0;
        while(!setA.isEmpty()){
            int popA = setA.pollFirst();
            sumA -= popA;
            lengthA--;
            double tmpA = sumA / lengthA;
            if(tmpA <= averageA){
                break;
            }
            if(setB.contains(popA)){
                continue;
            }
            sumB += popA;
            lengthB++;
            double tmpB = sumB / lengthB;
            if(tmpB <= averageB){
                break;
            }
            averageA = tmpA;
            averageB = tmpB;
            ++count;
        }
        return count;
    }

    public static int maxOps(int[] arr1, int[] arr2){
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += (double) arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += (double) arr2[i];
        }
        if(avg(sum1, arr1.length) == avg(sum2, arr2.length)){
            return 0;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if(avg(sum1, arr1.length) > avg(sum2, arr2.length)){
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        }
        else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for(int num : arrLess){
            setLess.add(num);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for(int i = 0; i < arrMore.length; i++){
            double cur = (double) arrMore[i];
            if(cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize)
            && !setLess.contains(arrMore[i])){
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int size){
        return sum / (double) size;
    }
}
