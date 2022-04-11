package com.lewis.leetcode.medium;

/*
 *  找到一颗二叉树中, 最大的搜索二叉树, 返回最大搜索二叉树的节点个数
 */

public class MaxNumBinary {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public  Node(){}
        public Node(int val){
            this.val = val;
            this.left = new Node();
            this.right = new Node();
        }
    }
    public static class Info{
        public Node maxBSTHead;
        public boolean isBST;
        public int min;
        public int max;
        public int maxBSTSize;

        public Info(Node node, boolean is, int min, int max, int maxBSTSize){
            this.maxBSTHead = node;
            this.isBST = is;
            this.min = min;
            this.max = max;
            this.maxBSTSize = maxBSTSize;
        }
    }

    public static Info process(Node x){
        if(x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int min = x.val;
        int max = x.val;


    }
}
