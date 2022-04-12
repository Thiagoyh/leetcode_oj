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

        if(leftInfo != null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        if(rightInfo != null){
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        int maxBSTSize = 0;
        Node maxBSTHead = null;
        if(leftInfo != null){
            maxBSTSize = leftInfo.maxBSTSize;
            maxBSTHead = leftInfo.maxBSTHead;
        }
        if(rightInfo != null && rightInfo.maxBSTSize > maxBSTSize){
            maxBSTSize = rightInfo.maxBSTSize;;
            maxBSTHead = rightInfo.maxBSTHead;
        }
        boolean isBST = false;
        if(((leftInfo == null) || leftInfo.isBST) && ((rightInfo == null) || rightInfo.isBST)){
            if(((leftInfo == null) || leftInfo.max < x.val) && ((rightInfo == null) || rightInfo.min > x.val)){
                isBST = true;
                maxBSTHead = x;
                int leftSize = leftInfo == null ? 0 : leftInfo.maxBSTSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.maxBSTSize;
                maxBSTSize = leftSize + 1 + rightSize;
            }
        }
        return new Info(maxBSTHead, isBST, min, max, maxBSTSize);
    }
}
