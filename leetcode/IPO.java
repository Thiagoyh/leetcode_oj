package com.lewis.leetcode;

/*
 * 输入：
 * 正数数组costs
 * 正数数组profits
 * 正数k
 * 正数m
 * 含义：
 * costs[i]代表i号项目的花费
 * profits[i]表示i号项目在扣除花费后还能挣到的钱
 * k表示只能串行的最多项目
 * m表示初始资金
 * 说明：
 * 你每次做完一个项目，马上就会获得收益，可以支持立马去做下一个项目
 * 输出
 * 最后获得的最大钱数
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c){
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }
    public static class MaxCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital){
        PriorityQueue<Node> minCost = new PriorityQueue<Node>(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue<Node>(new MaxCostComparator());

        for(int i = 0; i < Profits.length; ++i){
            minCost.add(new Node(Profits[i], Capital[i]));
        }
        for(int i = 0; i < k; ++i){
            while(!minCost.isEmpty() && minCost.peek().c <= W){
                maxProfit.add(minCost.poll());
            }
            if(maxProfit.isEmpty()){
                return W;
            }
            W += maxProfit.poll().p;
        }
        return W;
    }
}
