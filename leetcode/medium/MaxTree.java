package com.lewis.leetcode.medium;

public class MaxTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
    }

    public static int maxNum(Node x){
        return f(x);
    }

    public static int max = Integer.MIN_VALUE;

    // 以x为头的整棵树上, 求这个问题的解
    // x往左走, x往右走
    public static int f(Node x){
        if(x.left == null && x.right == null){
            return x.value;
        }
        int next = 0;
        if(x.left != null){
            next = f(x.left);
        }
        if(x.right != null){
            next = Math.max(f(x.right), next);
        }
        return x.value + next;
    }

    public static void process(Node x, int pre){
        if(x.left == null && x.right == null){
            max = Math.max(pre, pre + x.value);
        }
        if(x.left != null){
            process(x.left, pre + x.value);
        }
        if(x.right != null){
            process(x.right, pre + x.value);
        }
    }

}
